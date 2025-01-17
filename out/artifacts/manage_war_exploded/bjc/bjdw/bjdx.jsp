 <div class="breadcrumbs" id="breadcrumbs"> 
  <script type="text/javascript">
   try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
 </script>
 <ul class="breadcrumb">
  <li> <i class="icon-home home-icon"></i> <a href="#">首页</a> </li>
  <li> <a href="#">保健对象</a> </li>
  <li class="active">保健对象</li>
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
    <h1> 保健单位 <small> <i class="icon-double-angle-right"></i> 保健对象管理 </small> </h1>
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
                <label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 姓名 </label>
                 <div class="col-sm-3">
                  <input type="text" id="form-field-1" placeholder="" class="col-xs-10 col-sm-10" />
                </div>

                 <label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 保健单位 </label>
                 <div class="col-sm-3">
                  <input type="text" id="form-field-1" placeholder="" class="col-xs-10 col-sm-10" />
                </div>

                <label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 状态</label>
                <div class="col-sm-1">
                  <select class="form-control" id="form-field-select-1">
                                <option value="">不限</option>
                                <option value="AR">启用</option>
                                <option value="CA">停用</option>
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
      <div id="grid-pager"></div>
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

         <!-- page specific plugin scripts --> 
         <script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script> 
         <script src="assets/js/jqGrid/i18n/grid.locale-cn.js"></script> 
         <script src="assets/js/bjdw/bjdw/bjdx.js"></script>