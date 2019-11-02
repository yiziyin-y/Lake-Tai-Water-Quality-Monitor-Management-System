<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>My First Grid</title>

    <link rel="stylesheet" href="../../jqgrid/css/ui.jqgrid.css" />

    <!-- jqGrid主题包-非必要 -->
    <!-- 在jqgrid/css/css这个目录下还有其他的主题包，可以尝试更换看效果 -->
    <link rel="stylesheet" href="../../jqgrid/css/css/redmond/jquery-ui-1.8.16.custom.css" />

    <!-- jquery插件包-必要 -->
    <!-- 这个是所有jquery插件的基础，首先第一个引入 -->
    <script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>

    <!-- jqGrid插件包-必要 -->
    <script type="text/javascript" src="../../jqgrid/js/jquery.jqGrid.src.js"></script>

    <!-- jqGrid插件的多语言包-非必要 -->
    <!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
    <script type="text/javascript" src="../../jqgrid/js/i18n/grid.locale-cn.js"></script>

    <style>

        html, body {
            margin: 0;

            padding: 0;

            font-size: 75%;

        }

    </style>


</head>

<body>

<table id="list2"></table>
<div id="pager2"></div>
<input id="test" value="2"/>
<br>



</body>

<script>
    $(function(){
        //页面加载完成之后执行
        pageInit();
    });
    alert($("#test").val());
    function pageInit(){
        //创建jqGrid组件
        jQuery("#list2").jqGrid(
            {
                url : "image/getHotImage?typeId=1",//组件创建完成之后请求数据的url
                datatype : "json",//请求数据返回的类型。可选json,xml,txt
                mtype : "post",//向后台请求数据的ajax的类型。可选post,get

                loadComplete: function (returndata) {
                  //  alert(returndata);
                    console.log(returndata);
                    console.log(returndata.data);//为所有数据行，具体取决于reader配置的root或者服务器返回的内容

                },
                colNames : [ 'imageId', '名字' ],//jqGrid的列显示名字

                colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
                    {name : 'imageId',index : 'imageId',width : 55},
                    {name : 'imagePath',index : 'imagePath',width : 90},

                ],
                jsonReader : {
                root:"data",

                 repeatitems: false,
                 },
                autowidth: true,
                rowNum : 10,//一页显示多少条
                rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
                pager : '#pager2',//表格页脚的占位符(一般是div)的id
                sortname : 'imageId',//初始化的时候排序的字段
                sortorder : "desc",//排序方式,可选desc,asc

                viewrecords : true,
                caption : "TEST"//表格的标题名字

            });
        /*创建jqGrid的操作按钮容器*/
        /*可以控制界面上增删改查的按钮是否显示*/
        jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : true,add : true,del : false})
            .jqGrid('navButtonAdd', pager_selector,
            {
                caption: "删除", buttonicon: "icon-trash red",
                onClickButton: function () {


                    var selectedRowIds = $("#list2").jqGrid("getGridParam", "selarrrow");//拿到某一行的数据 是表格的行
                    alert(selectedRowIds);
                    var resopnseImageid = null;
                    var imageIds = new Array();
                    for (var i = 0; i<selectedRowIds.length; i++) {
                        var rowData = $("#grid-table").jqGrid("getRowData", selectedRowIds[i]);//通过行的编号拿到对象

                        imageIds[i] = rowData.imageId;
                    }


                    if (selectedRowIds == "") {
                        alert("请选择删除的行")
                    } else {
                        if (confirm("确认删除么")) {
                            // alert("图片id"+selectedRowIds.imageId);
                            alert($("#grid-table").html())
                            $.ajax({
                                type: "post",
                                url: "/image/delete",
                                data: {"imageIds": imageIds, "time": new Date().getTime(), "id": 1},
                                dataType: "json",
                                success: function (data) {
                                    //判断后台是否删除成功
                                    //如果成功则调用jqGrid的delRowData方法逐个删除行id
                                    alert(data);
                                    if (data.status == 1) {
                                        for (var i = 0; i < selectedRowIds.length; i++) {
                                            $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
                                        }
                                    } else {
                                        alert("删除失败");
                                    }
                                }
                            });


                        }
                    }
                }

                ,
                position: "last", title: "", cursor: "pointer"
            }
        )

    }

</script>
</html>