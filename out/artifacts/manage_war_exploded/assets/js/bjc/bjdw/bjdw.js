// JavaScript Document
var oper;
var selId;
jQuery(function ($) {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: "hcDep/queryDep.action",//组件创建完成之后请求数据的url
        datatype: "json",
        mtype: "post",
        height: 250,
        colNames: ['ID', '保健单位', '地址', '管理员账号', '密码', '联系电话', '操作'],
        colModel: [{
            name: 'id',
            index: 'id',
            hidden: true,
            key: true,
            sorttype: "int"
        }, {
            name: 'deptName', index: 'deptName', width: 90, editable: true, sorttype: "String"
        },
            {
                name: 'address', index: 'address', width: 90, editable: true, sorttype: "String"
            },
            {
                name: 'admin', index: 'admin', width: 60, sorttype: "String", editable: true,
            },
            {
                name: 'password', index: 'password', width: 90, editable: true, sorttype: "String",

            },

            {
                name: 'contactTel', index: 'contactTel', width: 60, sorttype: "Date", editable: true, sortable: false,
            },

            {
                name: 'myac',
                index: '',
                width: 80,
                fixed: true,
                sortable: false,
                resize: false,
                formatter: 'actions',
                formatoptions: {
                    keys: true,
                    editbutton: false,
                    delOptions: {
                        recreateForm: true,
                        beforeShowForm: beforeDeleteCallback
                    },
                    editformbutton: false, editOptions: {recreateForm: true, beforeShowForm: beforeEditCallback}
                }
            }],
        prmNames: {

            page: "page", // 表示请求页码的参数名称

            rows: "rows", // 表示请求行数的参数名称

            sort: "sidx", // 表示用于排序的列名的参数名称

            order: "sord", // 表示采用的排序方式的参数名称

            search: "_search", // 表示是否是搜索请求的参数名称

            nd: "nd", // 表示已经发送请求的次数的参数名称

            id: "id", // 表示当在编辑数据模块中发送数据时，使用的id的名称

            npage: null,

            totalrows: "totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal

        },
        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pager_selector,
        altRows: true,
        //toppager: true,

        multiselect: false,
        //multikey: "ctrlKey",
        multiboxonly: false,

        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);

                updateActionIcons(table);
                updatePagerIcons(table);
                enableTooltips(table);
            }, 0);
        },

        editurl: "/hcDep/delDep.action",


        autowidth: true

    });

    //enable search/filter toolbar
    //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

    //switch element when editing inline
    function aceSwitch(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=checkbox]')
                .wrap('<label class="inline" />')
                .addClass('ace ace-switch ace-switch-5')
                .after('<span class="lbl"></span>');
        }, 0);
    }

    //enable datepicker
    function pickDate(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=text]')
                .datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true
                });
        }, 0);
    }


    $("#subsearch").click(
        function () {
            var depNamevalue = encodeURIComponent($("#hec-dep").val());
            var postJson = {depName: depNamevalue};
            //传入查询条件参数
            $("#grid-table").jqGrid("setGridParam", {postData: postJson});
            //每次提出新的查询都转到第一页
            $("#grid-table").jqGrid("setGridParam", {page: 1});
            //提交post并刷新表格
            $("#grid-table").jqGrid("setGridParam", {url: "/hcDep/queryDep.action"}).trigger("reloadGrid");
        }
    );


    //navButtons
    jQuery(grid_selector).jqGrid('navGrid', pager_selector,
        { 	//navbar options
            edit: false,
            editicon: 'icon-pencil blue',
            add: false,
            addicon: 'icon-plus-sign purple',
            del: false,
            delicon: 'icon-trash red',

            search: false,
            searchicon: 'icon-search orange',
            refresh: false,
            refreshicon: 'icon-refresh green',
            view: false,
            viewicon: 'icon-zoom-in grey',
        },
        {
            //edit record form
            //closeAfterEdit: true,
            recreateForm: true,
            beforeShowForm: function (e) {

                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //new record form
            closeAfterAdd: true,
            recreateForm: true,
            viewPagerButtons: false,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //delete record form
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                if (form.data('styled')) return false;

                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);

                form.data('styled', true);
            },
            onClick: function (e) {
                alert(1);
            }
        }, {
            //search form
            recreateForm: true,
            afterShowSearch: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                style_search_form(form);
            },
            afterRedraw: function () {
                style_search_filters($(this));
            },
            multipleSearch: true,
            /**
             multipleGroup:true,
             showQuery: true
             */
        }, {
            //view record form
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
            }
        }).jqGrid('navButtonAdd', pager_selector,
        {
            title: "编辑保健单位", buttonicon: "icon-pencil blue", caption: "编辑",
                    reloadAfterSubmit: true,
                    onClickButton: function () {

                    var grid = $("#grid-table");
                    var rowKey = grid.jqGrid('getGridParam', "selrow");

                if (rowKey) {
                    $("#myModal").modal("show");//开启模态框

                    $("#myModalLabel").html("修改");
                    var rowData = $("#grid-table").jqGrid("getRowData", rowKey);//通过行的编号拿到对象
                    //  alert(rowData.id+"----"+rowData.admin);
                    $("#deptname").val(rowData.deptName);
                    var id2 = rowData.id;
                    $("#address").val(rowData.address);

                    $("#admin").val(rowData.admin);
                    $("#adminpsw").val(rowData.password);
                    $("#contactphone").val(rowData.contactTel);

                    oper="edit"
                    selId=rowKey;
                } else {
                    alert("请选择一个保健单位");
                }
            }
        }
    )
    //自定义的增加
        .jqGrid('navButtonAdd', pager_selector,
            {
                title: "新增", buttonicon: "icon-plus-sign purple", caption: "增加",
                reloadAfterSubmit: true,
                onClickButton: function () {
                    oper="add";
                    $("#myModalLabel").html("新增");
                    $("#myModal").modal('show');//开启模态框

                    $("#deptname").val("");
                    $("#address").val("");
                    $("#admin").val("");
                    $("#adminpsw").val("");
                    $("#contactphone").val("");
                }

                ,
                //   id: "addNewsButton", position: "last", addtitle: "增加宣教详情", cursor: "pointer"
            }
        );
    //
    function Z_AfterSubmit_Edit(response, postdata) {
        var DialogVars = $.parseJSON(response.responseText);//响应信息

        if (DialogVars.status) {
            alert("成功");
            return [true, myInfo, ""];
        } else {
            alert("失败");
            return [false, myInfo, ""];
        }
    }

    //


    function style_edit_form(form) {
        //enable datepicker on "sdate" field and switches for "stock" field
        form.find('input[name=sdate]').datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true
        })
            .end().find('input[name=stock]')
            .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove(); //ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').remove();
        buttons.eq(0).append('<i class="icon-chevron-left"></i>');
        buttons.eq(1).append('<i class="icon-chevron-right"></i>');
    }

    function style_delete_form(form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove(); //ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')
    }

    function style_search_filters(form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    }

    function style_search_form(form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable')
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
    }

    function beforeDeleteCallback(e) {
        var form = $(e[0]);
        if (form.data('styled')) return false;

        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_delete_form(form);

        form.data('styled', true);
    }

    function beforeEditCallback(e) {
        var form = $(e[0]);
        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_edit_form(form);
    }


    //it causes some flicker when reloading or navigating grid
    //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
    //or go back to default browser checkbox styles for the grid
    function styleCheckbox(table) {
        /**
         $(table).find('input:checkbox').addClass('ace')
         .wrap('<label />')
         .after('<span class="lbl align-top" />')


         $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
         .find('input.cbox[type=checkbox]').addClass('ace')
         .wrap('<label />').after('<span class="lbl align-top" />');
         */
    }


    //unlike navButtons icons, action icons in rows seem to be hard-coded
    //you can change them like this in here if you want
    function updateActionIcons(table) {
        /**
         var replacement =
         {
             'ui-icon-pencil' : 'icon-pencil blue',
             'ui-icon-trash' : 'icon-trash red',
             'ui-icon-disk' : 'icon-ok green',
             'ui-icon-cancel' : 'icon-remove red'
         };
         $(table).find('.ui-pg-div span.ui-icon').each(function(){
			var icon = $(this);
			var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
			if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
		})
         */
    }

    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement = {
            'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
            'ui-icon-seek-prev': 'icon-angle-left bigger-140',
            'ui-icon-seek-next': 'icon-angle-right bigger-140',
            'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
        };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        })
    }

    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({
            container: 'body'
        });
        $(table).find('.ui-pg-div').tooltip({
            container: 'body'
        });
    }

    //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');


});

function saveOrUpdate()
{
    var deptname = $("#deptname").val();
    var address = $("#address").val();
    var admin = $("#admin").val();
    var adminpsw = $("#adminpsw").val();
    var contactphone = $("#contactphone").val();

    if(oper=='edit'){
        $.ajax({
            type: "post",
            url: "/hcDep/updateDep.action",
            data: {
                "id": selId,
                "deptname": deptname,
                "time": new Date().getTime(),
                "address": address,
                "admin": admin,
                "adminpsw": adminpsw,
                "contactphone": contactphone,
            },
            dataType: "json",
            success: function (data) {

                if (data.status == 1) {
                    $('#myModal').modal("hide");
                    $("#grid-table").trigger("reloadGrid");//从新加载页面
                    //  alert(data.message);
                } else {
                    $("#grid-table").trigger("reloadGrid");
                    alert(data.message);
                }
            }
        });
    }
    else if(oper=='add'){
        $.ajax({
            type: "post",
            url: "/hcDep/addDep.action",
            data: {
                "deptname": deptname,
                "time": new Date().getTime(),
                "address": address,

                "admin": admin,
                "adminpsw": adminpsw,
                "contactphone": contactphone,
            },
            dataType: "json",
            success: function (data) {
                // alert("成功与否"+data.status);
                if (data.status == 1) {
                    $('#myModal').modal("hide");
                    $("#grid-table").trigger("reloadGrid");//从新加载页面

                } else {
                    $("#grid-table").trigger("reloadGrid");
                    alert(data.message);
                }
            }
        });
    }
}
