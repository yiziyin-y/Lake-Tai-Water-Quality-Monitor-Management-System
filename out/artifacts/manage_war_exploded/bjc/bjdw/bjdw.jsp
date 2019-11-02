<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="breadcrumbs" id="breadcrumbs">
  <script type="text/javascript">
   try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
 </script>

     <script src="assets/js/jquery.validate.js"></script>


 <ul class="breadcrumb">
  <li> <i class="icon-home home-icon"></i> <a href="#">首页</a> </li>
  <li> <a href="#">保健单位</a> </li>
  <li class="active">保健单位</li>
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
    <h1> 保健单位 <small> <i class="icon-double-angle-right"></i> 保健单位管理 </small> </h1>
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

                <div class="form-group">
                 <label class="col-sm-1 control-label no-padding-right" for="hec-dep"> 保健单位 </label>

                 <div class="col-sm-3">
                  <input type="text" id="hec-dep" placeholder=""
                         class="{required:true,required:email,messages:{required:'请输入内容'}}"  />
                </div>

                    <%--class="col-xs-10 col-sm-10"--%>
              </div>
              <div class="space-4"></div>
              <div class="form-group text-right" id="search">
                <button class="btn btn-success" id="subsearch">
                  <span class="icon-filter" aria-hidden="true"></span>                        
                  搜索
                </button>
              </div>

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

          <!-- 按钮触发模态框 -->

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
        </div>


 <!-- 模态框（Modal） -->
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog" style="width:600px">
         <div class="modal-content">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="closeSub" onclick="closeButton()">
                     &times;
                 </button>
                 <h4 class="modal-title" id="myModalLabel">
                    <!-- 保健单位信息添加-->
                 </h4>
             </div>
             <div class="modal-body" >
                 <!--fomr 样式-->



                 <div class="form-group">
                     <div style=" float: left ; height:30px ; width:150px; text-align:center; line-height:30px">
                         <label style="float:right" for="deptname">保健单位名称：</label></div>
                     <div>  <input type="text"  style=" width:350px " class="form-control" id="deptname" placeholder="" name="deptname">
                     </div>
                 </div>
                 <!---->
                 <div class="form-group">
                     <div style=" float: left ;width:150px; height:30px ; text-align:center; line-height:30px">
                         <label  style="float:right" for="address">地址：</label></div>
                     <div>  <input type="text"  style=" width:350px "class="form-control" id="address" placeholder="" name="address"></div>
                 </div>

                 <div class="form-group">
                     <div style=" float: left ; height:30px ; width:150px; text-align:center; line-height:30px">
                         <label style="float:right" for="admin">管理员账号：</label></div>
                     <div>  <input type="number"  style=" width:350px " class="form-control" id="admin" placeholder="" name="admin">
                     </div>
                 </div>
                 <!---->
                 <div class="form-group">
                     <div style=" float: left ; height:30px ; width:150px; text-align:center; line-height:30px">
                         <label style="float:right" for="adminpsw">管理员密码：</label></div>
                     <div>  <input type="text"  style=" width:350px " class="form-control" id="adminpsw" placeholder="" name="adminpsw">
                     </div>
                 </div>
                 <!---->
                 <div class="form-group">
                     <div style=" float: left ; height:30px ; width:150px; text-align:center; line-height:30px">
                         <label style="float:right" for="contactphone">管理员电话：</label></div>
                     <div>  <input type="text"  style=" width:350px " class="form-control" id="contactphone" placeholder="" name="contactphone">
                     </div>
                 </div>
                 <!---->

                 <!---->

                </div>
             <div class="modal-footer">
                 <div style=" position:relative; float: right; width:200px">
                     <table width="150" border="0"  >
                         <tr>
                             <td>
                                 <button type="button" class="btn btn-primary"  style="display:none" id="subEdit">修改
                                 </button>
                                <button type="button"  style="display:none" class="btn btn-primary" id="subAdd">保存
                                 </button>
                             </td>
                             <td> <button type="button" class="btn btn-default" data-dismiss="modal" id="closeSubAdd" onclick="closeButton()">关闭
                             </button></td>
                         </tr>
                     </table>

                 <!-- <button type="button" class="btn btn-primary " style="display:none" id="subEdit">修改
                 </button>
                 <button type="button" class="btn btn-primary" style="display:none" id="subAdd">保存
                 </button>
                 <button type="button" class="btn btn-default" data-dismiss="modal" id="closeSubAdd" onclick="closeButton()">关闭
                 </button>-->
                 </div>
             </div>
         </div><!-- /.modal-content -->
     </div><!-- /.modal -->
 </div>

 <!-- end   MODEL-->



 <!-- end-->
         <script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>


         <script src="assets/js/jqGrid/i18n/grid.locale-cn.js"></script> 
     <%--   <script src="assets/js/bjc/bjdw/bjdw.js"></script>--%>
 <script type="text/javascript">
     function closeButton(){

         $("#subEdit").css("display","none");
         $("#subAdd").css("display","none");
     }






     jQuery(function ($) {
         var grid_selector = "#grid-table";
         var pager_selector = "#grid-pager";
 var subsearch= "#subsearch";
         jQuery(grid_selector).jqGrid({


             url: "hcDep/queryDep.action",//组件创建完成之后请求数据的url
             datatype: "json",//请求数据返回的类型。可选json,xml,txt
             mtype: "post",//向后台请求数据的ajax的类型。可选post,get
             height: 250,
             colNames: [ '编号', '保健单位名称','地址','管理员账号','密码','电话','操作'],
             colModel: [


                 {
                     name: 'id', index: 'id', width: 60, sorttype: "int", editable: true, hidden:true,key:true
                 },
                 {name: 'deptName', index: 'deptName', width: 90, editable: true, sorttype: "String"
                 },
                 {name: 'address', index: 'address', width: 90, editable: true, sorttype: "String"
                 },
                 {
                     name: 'admin', index: 'admin', width: 60, sorttype: "String", editable: true,
                 },
                 {name: 'password', index: 'password', width: 90, editable: true, sorttype: "String",

                 },

                 {
                     name: 'contactTel', index: 'contactTel', width: 60, sorttype: "Date", editable: true,sortable: false,
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
                       editbutton:false,
                       delOptions: {
                           recreateForm: true,
                           beforeShowForm: beforeDeleteCallback
                       },
                       editformbutton:false, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
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
             multiselect: false,

             multiboxonly: true,

            /* gridComplete: function() {
                 /!*var rowIds = jQuery("#grid-table").jqGrid('getDataIDs');
                 for(var k=0; k<rowIds.length; k++) {
                     var curRowData = jQuery("#listTable").jqGrid('getRowData', rowIds[k]);
                     var curChk = $("#"+rowIds[k]+"").find(":checkbox");
                     alert("---"+curChk.hide());
                     curChk.hide();
                     curChk.attr('display','block');   //给每一个checkbox赋名字*!/

                 }

             },*/


             loadComplete:function (data) {
                 var table = this;

                 if(data.records==0){ //如果没有记录返回，追加提示信息，删除按钮不可用
                   //  $("p").appendTo($("#grid-table")).addClass("nodata").html('找不到相关数据！');
                     alert("找不到相关数据！");
                     $("#grid-table").html("找不到相关数据！");
                 }

                /* setTimeout(function () {
                   styleCheckbox(table);

                     updateActionIcons(table);
                     updatePagerIcons(table);
                     enableTooltips(table);
                 }, 0);*/
             },
             afterComplete:function(data){
                 alert(data)
                 alert(data.message);
             },


             editurl: "/hcDep/delDep.action",//nothing is saved


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

         $()

         $("#subsearch").click(
function () {


         var depNamevalue = encodeURIComponent($("#hec-dep").val());

         var postJson = {depName:depNamevalue};

         //传入查询条件参数
         $("#grid-table").jqGrid("setGridParam",{postData:postJson});
         //每次提出新的查询都转到第一页
         $("#grid-table").jqGrid("setGridParam",{page:1});
         //提交post并刷新表格
         $("#grid-table").jqGrid("setGridParam",{url:"/hcDep/queryDep.action"}).trigger("reloadGrid");
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
         ) //自定义搜索 grid_selector  pager_selector

             .jqGrid('navButtonAdd',pager_selector ,
                 {
                     title: "编辑保健单位", buttonicon: "icon-pencil blue", caption: "编辑",
                     reloadAfterSubmit: true,
                     onClickButton:function()
                     {

                         var grid = $("#grid-table");
                         var rowKey = grid.jqGrid('getGridParam',"selrow");

                         if(rowKey)
                         {
                             $("#showModel").click();//开启模态框
                             $("#subEdit").css("display","block");

                             $("#myModalLabel").html("保健单位修改");
                                 var rowData = $("#grid-table").jqGrid("getRowData", rowKey);//通过行的编号拿到对象
                               //  alert(rowData.id+"----"+rowData.admin);
                             $("#deptname").val(rowData.deptName);
                                var id2=rowData.id;
                           $("#address").val(rowData.address);

                             $("#admin").val(rowData.admin);
                            $("#adminpsw").val(rowData.password);
                             $("#contactphone").val(rowData.contactTel);
                             $("#subEdit").unbind("click")  //清除绑定事件


                             $("#subEdit").click(function(){
                                 closeButton();
                                 $("#closeSubAdd").click(

                                 );//关闭模态框

                                 var deptname2=   $("#deptname").val();

                                 var address2=$("#address").val();

                                 var admin2=$("#admin").val();
                                 var adminpsw2=$("#adminpsw").val();
                                 var contactphone2=$("#contactphone").val();
                                 //ajax start

                                 $.ajax({
                                     type: "post",
                                     url: "/hcDep/updateDep.action",
                                     data: {
                                         "id":id2,
                                         "deptname": deptname2,
                                         "time": new Date().getTime(),
                                         "address": address2,
                                         "admin": admin2,
                                         "adminpsw":adminpsw2,
                                         "contactphone":contactphone2,
                                     },

                                     dataType: "json",
                                     success: function (data) {

                                         if (data.status == 1) {
                                             $("#grid-table").trigger("reloadGrid");//从新加载页面
                                           //  alert(data.message);
                                         } else {
                                             $("#grid-table").trigger("reloadGrid");
                                             alert(data.message);
                                         }
                                     }
                                 });



                             });
                                 // jaax end

                         }else{
                             alert("No rows are selected");
                         }
                     }
                 }

             )
         //自定义的增加
             .jqGrid('navButtonAdd', pager_selector,
                 {
                     title: "添加保健单位", buttonicon: "icon-plus-sign purple", caption: "增加",
                     reloadAfterSubmit: true,
                     onClickButton: function () {
                    $("#myModalLabel").html("保健单位添加");
                         $("#subAdd").css("display","block");

                         $("#showModel").click();//开启模态框

                         $("#deptname").val("");
                         $("#address").val("");
                         $("#admin").val("");
                         $("#adminpsw").val("");
                         $("#contactphone").val("");

                         $("#subAdd").unbind("click")  //清除绑定事件
                         $("#subAdd").click(function(){

                             var deptname=$("#deptname").val();
                             var address=$("#address").val();
                             var admin=$("#admin").val();
                             var adminpsw=$("#adminpsw").val();
                             var contactphone=$("#contactphone").val();


                             $("#closeSubAdd").click(

                             );//关闭模态框
                             closeButton();



                             $.ajax({
                                 type: "post",
                                 url: "/hcDep/addDep.action",
                                 data: {
                                     "deptname": deptname,
                                     "time": new Date().getTime(),
                                     "address": address,

                                     "admin": admin,
                                     "adminpsw":adminpsw,
                                     "contactphone":contactphone,
                                 },

                                 dataType: "json",
                                 success: function (data) {
                                     // alert("成功与否"+data.status);
                                     if (data.status == 1) {
                                         $("#grid-table").trigger("reloadGrid");//从新加载页面

                                     } else {
                                         $("#grid-table").trigger("reloadGrid");
                                         alert(data.message);
                                     }
                                 }
                             });



                         });


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