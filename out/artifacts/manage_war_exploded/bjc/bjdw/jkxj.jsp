<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
    </script>
    <ul class="breadcrumb">
        <li> <i class="icon-home home-icon"></i> <a href="#">首页</a> </li>
        <li> <a href="#">健康宣教</a> </li>
        <li class="active">健康宣教管理</li>
    </ul>
    <!-- .breadcrumb -->

    <div class="nav-search" id="nav-search">
        <form class="form-search">
    <span class="input-icon">
      <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
      <i class="icon-search nav-search-icon"></i> </span>
        </form>
    </div>
    <!-- #nav-search -->
</div>
<div class="page-content">
    <div class="page-header">
        <h1> 健康宣教<small> <i class="icon-double-angle-right"></i> 健康宣教管理 </small> </h1>
    </div>
    <!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="col-xs-12 col-sm-12">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4>搜索</h4>

                        <div class="widget-toolbar">
                        </div>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main container">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">


                                    <label class="col-sm-1 control-label no-padding-right" > 类型</label>
                                    <div class="col-sm-1">
                                        <select class="form-control" id="form-field-select-1">

                                            <option value="AZ">癌症</option>
                                            <option value="JJ">急救</option>
                                            <option value="MXB">慢性病</option>
                                            <option value="ZNGF">指南规范</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                                <div class="form-group text-right">
                                    <button class="btn btn-success">
                                        <span class="icon-filter" aria-hidden="true"></span>
                                        搜索
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div><!-- /span -->

                <table id="grid-table">
                </table>
                <div id="grid-pager">
                    <!-- 按钮触发模态框 -->
                    <button class="btn btn-primary btn-lg"  id="showModel" STYLE="display:none;width:100px;height:20px; position: relative;left: 100px" data-toggle="modal" data-target="#myModal">
                        添加
                    </button>
                </div>
                <script type="text/javascript">
                    var $path_base = "/";//this will be used in gritter alerts containing images
                </script>

                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.page-content -->

    <!-- 增加的模态框-->

    <!-- 按钮触发模态框 -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                       宣教信息添加
                    </h4>
                </div>
                <div class="modal-body">
                    <!--fomr 样式-->
                   <%-- <form class="form-inline" role="form" style="margin-top:30px;margin-bottom:200px;border-top:2px solid #555" id="alertNameForm"
                          action="news/updateNews.action?oper=add" method="post" onsubmit="">--%>

                        <hr>
                        <div class="form-group">
                            <label for="title">标题：</label>
                            <input type="text" class="form-control" id="title" placeholder="请输入" name="title">
                        </div>
                        <div class="form-group">
                            <label for="content">内容：</label>
                            <input type="number" class="form-control" id="content" placeholder="请输入" name="content">
                        </div>
                        <div class="form-group">
                            <label for="author">作者：</label>
                            <input type="text" class="form-control" id="author" placeholder="请输入" name="author">
                        </div>
                        <div class="form-group">
                            <label for="type">类型：</label>
                            <select class="form-control" id="type" name="type">

                                <option value="AZ">癌症</option>
                                <option value="JJ">急救</option>
                                <option value="MXB">慢性病</option>
                                <option value="ZNGF">指南规范</option>
                            </select>
                        </div>


                  <%--  </form>--%>
                    <!---->

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="closeSubAdd">关闭
                    </button>
                    <button type="button" class="btn btn-primary" id="subAdd">确认添加
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- end-->

    <!-- page specific plugin scripts -->
    <script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>

    <script src="assets/js/jqGrid/i18n/grid.locale-cn.js"></script>

   <%-- <script src="assets/js/bjdw/bjdw/bjdx.js"></script>--%>


    <script type="text/javascript">




        jQuery(function ($) {
            var grid_selector = "#grid-table";
            var pager_selector = "#grid-pager";

            jQuery(grid_selector).jqGrid({


                url: "news/queryNews.action",//组件创建完成之后请求数据的url
                datatype: "json",//请求数据返回的类型。可选json,xml,txt
                mtype: "post",//向后台请求数据的ajax的类型。可选post,get
                height: 250,
                colNames: [ '编号', '标题','内容','作者','类型','发布时间','操作'],
                colModel: [


                    {
                        name: 'id', index: 'id', width: 60, sorttype: "int", editable: false, hidden: false
                    },
                    {name: 'title', index: 'title', width: 90, editable: true, sorttype: "String"
                    },
                    {name: 'content', index: 'content', width: 90, editable: true, sorttype: "String"
                    },
                    {
                        name: 'author', index: 'author', width: 60, sorttype: "String", editable: true,
                    },
                    {name: 'type', index: 'type', width: 90, editable: true, sorttype: "String",edittype:"select",editoptions:
                        {value:"AZ:癌症;JJ:急救;指南规范:ZNGF;MXB:慢性病;"}
 },

                    {
                        name: 'publishDate', index: 'publishDate', width: 60, sorttype: "Date", editable: true,
                        editrules:{date:true},formatter:'date', datefmt:'Y-m-d',


                    },

                    {
                        name: 'myac', index: '', width: 80, fixed: true, sortable: false, resize: false,
                        formatter: 'actions',
                        formatoptions: {
                            keys: true,
                            delOptions: {recreateForm: true, beforeShowForm: beforeDeleteCallback,},
                           // editformbutton:true,
                            editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback ,afterSubmit:function(){ alert("修改")}},
                        }
                    },

                ],
               /* jsonReader: {
                    root:"data",

                    repeatitems: false,
                },*/
                prmNames : {

                    page:"page", // 表示请求页码的参数名称

                    rows:"rows", // 表示请求行数的参数名称

                    sort: "sidx", // 表示用于排序的列名的参数名称

                    order: "sord", // 表示采用的排序方式的参数名称

                    search:"_search", // 表示是否是搜索请求的参数名称

                    nd:"nd", // 表示已经发送请求的次数的参数名称

                    id:"id", // 表示当在编辑数据模块中发送数据时，使用的id的名称

                  npage: null,

                    totalrows:"totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal

                },
                viewrecords: true,
                rowNum: 5,
                rowList: [5, 10, 15],
                pager: pager_selector,
                altRows: true,
                //toppager: true,

              //  treeGrid: true,//数行增加
                multiselect: true,

                multiboxonly: true,

                loadComplete: function () {
                    var table = this;


                    setTimeout(function () {
                          styleCheckbox(table);

                         updateActionIcons(table);
                         updatePagerIcons(table);
                          enableTooltips(table);
                    }, 0);
                },
                afterComplete:function(data){
                    alert(data)
                    alert(data.message);
                },


                editurl: "/news/updateNews.action",//nothing is saved


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
                        .datepicker({format: 'yyyy-mm-dd', autoclose: true});
                }, 0);
            }


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
                },
                {
                    //search form
                    recreateForm: true,
                    afterShowSearch: function (e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                        style_search_form(form);
                    },
                    afterRedraw: function () {
                        style_search_filters($(this));
                    }
                    ,
                    multipleSearch: true,
                    /**
                     multipleGroup:true,
                     showQuery: true
                     */
                },
                {
                    //view record form
                    recreateForm: true,
                    beforeShowForm: function (e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                    }
                }
            )
            //自定义的增加
            .jqGrid('navButtonAdd', pager_selector,
                {
                    title: "添加宣教信息", buttonicon: "icon-plus-sign purple", caption: "增加",
                    reloadAfterSubmit: true,
                    onClickButton: function () {

                        $("#showModel").click();//开启模态框

                        $("#subAdd").unbind("click")  //清除绑定事件
                        $("#subAdd").click(function(){

                            var title=$("#title").val();
                            var content=$("#content").val();
                            var author=$("#author").val();
                            var type=$("#type").val();


                            $("#closeSubAdd").click();//关闭模态框



                            $.ajax({
                                type: "post",
                                url: "/news/updateNews.action?oper=add",
                                data: {"title": title, "publishDate": new Date().getTime(),"content": content,"author": author,"type": type,  },

                                dataType: "json",
                                success: function (data) {
                                    // alert("成功与否"+data.status);
                                    if (data.status == 1) {
                                        $("#grid-table").trigger("reloadGrid");//从新加载页面
                                        //  $("#grid-table").trigger("reloadGrid", { fromServer: true, page: 1 });
                                        /*for (var i = 0; i < selectedRowIds.length; i++) {
                                         $("#grid-table").jqGrid("addRowData", selectedRowIds[i]);
                                         }*/
                                    } else {
                                        $("#grid-table").trigger("reloadGrid");
                                        alert("增加失败");
                                    }
                                }
                            });



                        });


                    }

                    ,
                    id: "addNewsButton", position: "last", addtitle: "增加宣教详情", cursor: "pointer"
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
                form.find('input[name=sdate]').datepicker({format: 'yyyy-mm-dd', autoclose: true})
                    .end().find('input[name=stock]')
                    .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

                //update buttons classes
                var buttons = form.next().find('.EditButton .fm-button');
                buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
                buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
                buttons.eq(1).prepend('<i class="icon-remove"></i>')

                buttons = form.next().find('.navButton a');
                buttons.find('.ui-icon').remove();
                buttons.eq(0).append('<i class="icon-chevron-left"></i>');
                buttons.eq(1).append('<i class="icon-chevron-right"></i>');
            }

            function style_delete_form(form) {
                var buttons = form.next().find('.EditButton .fm-button');
                buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
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
                var replacement =
                    {
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
                $('.navtable .ui-pg-button').tooltip({container: 'body'});
                $(table).find('.ui-pg-div').tooltip({container: 'body'});
            }

            //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');


        });
    </script>