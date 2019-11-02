

$(document).ready(function() {

    $('#editGoods').load($("#editGoods").attr("include-html"), function () {
        $("#editGood").hide();

        // 编辑商品
        var editGood = new Vue({
            el: "#editGood",
            data() {
                return{
                    //商品

                    // good: {foodFlag : 1,goodTypeId : -1, brandId : 2,minOrderCnt : 0,
                    // pMemPrice : 0, price : 0,discountPrice : 0,dMemPrice : 0,taxRate : 1,prjPrice :0},
                    shareEditGood: store.state,
                    //分类的数组
                    bigType: [],
                    midType: [],
                    minType: [],
                    //品牌
                    brands: [],
                    //分类的初始指针

                    brandIndex: -1,
                    bigTypeIndex: -1,
                    midTypeIndex: -1,
                    minTypeIndex: -1,
                    //图片文件
                    fileList: store.state,
                    detailImgList: store.state,
                    showImgList: store.state,
                    firstShowImgList: [],
                    //要删除的图片Id
                    detailImgDeList: [],
                    showImgDeList: [],
                    upFileDeList: [],
                }
            },
            created: function () {
                this.getAllBigType();
                this.getAllBrand();
                this.initIsFood();
            },
            computed: {
                good: function(){
                    return this.shareEditGood.oneGood;
                },
                goodCode: function () {
                    var goodCode = "0000";

                    if (this.minType.length > 0 && this.minTypeIndex >= 0) {
                        goodCode = this.bigType[this.bigTypeIndex].code + "" + this.midType[this.midTypeIndex].code + "" + this.minType[this.minTypeIndex].code;
                    }

                    return goodCode;
                },
            },
            methods: {
                //删除展示存在的照片
                deleteExitedImg: function (imgId, event) {

                    console.log(event.currentTarget);
                    $(event.currentTarget).parent().remove();
                    this.showImgDeList.push(imgId);
                    console.log(this.showImgDeList);
                },
                //删除细节存在的照片
                deleteDetailExitedImg: function (imgId, event) {
                    console.log(event.currentTarget);
                    $(event.currentTarget).parent().remove();
                    this.detailImgDeList.push(imgId);
                    console.log(this.detailImgDeList);
                },
                //删除证书存在的照片
                deleteDocExitedImg: function (imgId, event) {
                    console.log(event.currentTarget);
                    $(event.currentTarget).parent().remove();
                    this.upFileDeList.push(imgId);
                    console.log(this.upFileDeList);
                },
                //初始化是否为food菜单
                initIsFood: function () {
                    if (this.good.foodFlag == 1) {
                        $("#isFood").show();
                    }
                    if (this.good.foodFlag == 0) {
                        $("#isNoFood").show();
                    }
                },
                //保存商品
                saveGood: function () {

                    var formData = new FormData();
                    //保存照片
                    this.showImgList.editShowImgList.forEach(function (val) {
                        if (val != null) {
                            formData.append("showfile", val);
                        }
                    });
                    this.detailImgList.editDetailImgList.forEach(function (val) {
                        if (val != null) {
                            formData.append("detailfile", val);
                        }
                    });
                    this.fileList.editFileList.forEach(function (val) {
                        if (val != null) {
                            formData.append("docfile", val);
                        }
                    });
                    //删除存在的图片
                    editGood.detailImgDeList.forEach(function (val) {
                        if (val != null) {
                            formData.append("deletedetailImgList", val);
                        }
                    });
                    editGood.showImgDeList.forEach(function (val) {
                        if (val != null) {
                            formData.append("deleteShowImgList", val);
                        }
                    });
                    editGood.upFileDeList.forEach(function (val) {
                        if (val != null) {
                            formData.append("deletedocList", val);
                        }
                    });

                    formData.append("firstfile", editGood.firstShowImgList);
                    //保存商品
                    formData.append("id", editGood.good.id);
                    formData.append("goodName", EliminateUndefined(editGood.good.goodName));
                    formData.append("englishName", EliminateUndefined(editGood.good.englishName));
                    formData.append("goodTypeId", EliminateUndefined(editGood.good.goodTypeId));
                    formData.append("foodFlag", EliminateUndefined(editGood.good.foodFlag));
                    formData.append("par", EliminateUndefined(editGood.good.par));
                    formData.append("reserveCnt", EliminateUndefined(editGood.good.reserveCnt));
                    formData.append("producer", EliminateUndefined(editGood.good.producer));
                    formData.append("brandId", EliminateUndefined(editGood.good.brandId));
                    formData.append("series", EliminateUndefined(editGood.good.series));
                    formData.append("type", EliminateUndefined(editGood.good.type));
                    formData.append("location", EliminateUndefined(editGood.good.location));
                    formData.append("minUnit", EliminateUndefined(editGood.good.minUnit));
                    formData.append("salePkgUnit", EliminateUndefined(editGood.good.salePkgUnit));
                    formData.append("unitConvRate", EliminateUndefined(editGood.good.unitConvRate));
                    formData.append("size", EliminateUndefined(editGood.good.size));
                    formData.append("pkgSize", EliminateUndefined(editGood.good.pkgSize));
                    formData.append("material", EliminateUndefined(editGood.good.material));
                    formData.append("netWeight", EliminateUndefined(editGood.good.netWeight));
                    formData.append("grossWeight", EliminateUndefined(editGood.good.grossWeight));
                    formData.append("vol", EliminateUndefined(editGood.good.vol));
                    formData.append("shelfLife", EliminateUndefined(editGood.good.shelfLife));
                    formData.append("color", EliminateUndefined(editGood.good.color));
                    formData.append("tech", EliminateUndefined(editGood.good.tech));
                    formData.append("otherSpec", EliminateUndefined(editGood.good.otherSpec));
                    formData.append("minOrderCnt", EliminateUndefined(editGood.good.minOrderCnt));
                    formData.append("recDays", EliminateUndefined(editGood.good.recDays));
                    formData.append("prodNo", EliminateUndefined(editGood.good.prodNo));
                    formData.append("foodAdd", EliminateUndefined(editGood.good.foodAdd));
                    formData.append("alcohol", EliminateUndefined(editGood.good.alcohol));
                    formData.append("winType", EliminateUndefined(editGood.good.winType));
                    formData.append("winLevel", EliminateUndefined(editGood.good.winLevel));
                    formData.append("franceLocation", EliminateUndefined(editGood.good.franceLocation));
                    formData.append("grapeType", EliminateUndefined(editGood.good.grapeType));
                    formData.append("sugar", EliminateUndefined(editGood.good.sugar));
                    formData.append("level", EliminateUndefined(editGood.good.level));
                    formData.append("soberTime", EliminateUndefined(editGood.good.soberTime));
                    formData.append("pickYear", EliminateUndefined(editGood.good.pickYear));
                    formData.append("scent", EliminateUndefined(editGood.good.scent));
                    formData.append("style", EliminateUndefined(editGood.good.style));
                    formData.append("filler", EliminateUndefined(editGood.good.filler));
                    formData.append("fabric", EliminateUndefined(editGood.good.fabric));
                    formData.append("yarnCount", EliminateUndefined(editGood.good.yarnCount));
                    formData.append("density", EliminateUndefined(editGood.good.density));
                    formData.append("pic", EliminateUndefined(editGood.good.pic));
                    formData.append("voltage", EliminateUndefined(editGood.good.voltage));
                    formData.append("power", EliminateUndefined(editGood.good.power));
                    formData.append("installMethod", EliminateUndefined(editGood.good.installMethod));
                    formData.append("afterService", EliminateUndefined(editGood.good.afterService));
                    formData.append("brandId", EliminateUndefined(editGood.good.brandId));
                    formData.append("brandName", EliminateUndefined(editGood.good.brandName));
                    formData.append("description", EliminateUndefined(editGood.good.description));
                    formData.append("salePrice", EliminateUndefined(editGood.good.salePrice));
                    formData.append("pMemPrice", EliminateUndefined(editGood.good.pMemPrice));
                    formData.append("dMemPrice", EliminateUndefined(editGood.good.dMemPrice));
                    formData.append("prjPrice", EliminateUndefined(editGood.good.prjPrice));
                    formData.append("discountPrice", EliminateUndefined(editGood.good.discountPrice));
                    formData.append("price", EliminateUndefined(editGood.good.price));
                    formData.append("price", EliminateUndefined(editGood.good.taxRate));


                    $.ajax({
                        url: "good/updateGood",
                        type: 'POST',
                        data: formData,
                        enctype: 'multipart/form-data',
                        cache: false,
                        traditional: true,
                        contentType: false,
                        processData: false,
                        success: function (data) {
                            if (data.status == 1) {
                                //save success
                                giveMessage("保存成功");


                            } else {
                                giveMessage("保存失败，请稍后重试")

                            }
                        },
                        error: function () {
                            alert("保存失败，请稍后重试");
                        }
                    });


                },
                //切换食品菜单
                cheackFood: function () {
                    $("#isFood").show();
                    $("#isNoFood").hide();
                },
                //切换非食品菜单
                cheackNoFood: function () {
                    $("#isFood").hide();
                    $("#isNoFood").show();
                },
                //封面图
                firstShowImg: function (event) {
                    this.tirggerFile(event);
                    var fristShowImg = event.target.files[0];
                    this.firstShowImgList = fristShowImg;

                },
                //展示图
                showImg: function (event) {

                    var showImg = event.target.files[0];
                    var listIndex = this.showImgList.editShowImgList.push(showImg) - 1;
                    this.tirggerShowFile(showImg, listIndex);
                },
                //详细图
                detailImg: function (event) {
                    var detailImg = event.target.files[0];
                    var listIndex = this.detailImgList.editDetailImgList.push(detailImg) - 1;
                    this.tirggerDetailFile(detailImg, listIndex);

                },
                //文件上传
                upFile: function (event) {
                    var file = event.target.files[0];
                    var fileIndex = this.fileList.editFileList.push(file) - 1;
                    this.tirggeruploadFile(file, fileIndex);

                },
                //上传文件预览
                tirggeruploadFile: function (event, fileIndex) {
                    var imgurl;
                    // var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(event);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;


                        $("#upfile").append("<div class='col-md-2' style='width: 12%;height: 100px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a id = 'upfile' href='javascript:;' onclick='deleteEditupFile(" + fileIndex + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");
                        var upfileList = new Array();
                        upfileList.push(imgurl);
                        console.log("shide");
                        console.log(upfileList[0]);
                    }


                },
                //上传图片预览
                tirggerFile: function (event) {

                    var imgurl;
                    var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(file);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;
                        console.log($(event.target).prev());
                        $(event.target).prev().attr("src", imgurl);


                    }

                },
                //上传图片预览
                tirggerShowFile: function (file, index) {

                    var imgurl;
                    // var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(file);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;

                        $("#showImage").append("<div class='col-md-2' style='width: 12%;height: 100px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteEditShowImage(" + index + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");
                        // $("#showImage").append("<div class='col-md-2' style='width: 12%;'><div class='inputbg' style='background: url("+imgurl+");background-size: cover '></div></div>");


                    }

                },
                //上传图片预览
                tirggerDetailFile: function (file, index) {

                    var imgurl;
                    // var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(file);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;

                        $("#detailImage").append("<div class='col-md-2' style='width: 12%;height: 100px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteEditDetailImage(" + index + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");

                    }

                },

                preShow: function () {
                    $("#isNoFood").hide();
                    $("#isFood").hide();
                    $("#goodShow").toggle();
                    $("#editGood").toggle();
                },
                //获取所有的大类
                getAllBigType: function () {
                    var data = {};
                    _this = this;
                    $.ajax({
                        type: "POST",
                        url: "goodType/getAllBigType",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            _this.bigType = result.data;
                            _this.$nextTick(function () {
                                $('#bigType').select2();
                                $('#midType').select2();
                                $('#minType').select2();
                            })
                        },
                        error: function () {

                        }
                    });
                },
                //获取商品的所有品牌
                getAllBrand: function () {
                    var data = {};
                    _this = this;
                    $.ajax({
                        type: "POST",
                        url: "brand/getAllBrand",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            _this.brands = result.data;
                            _this.$nextTick(function () {
                                $('#brand').select2();
                            })
                        },
                        error: function () {

                        }
                    });
                },
            },
            watch: {
                good: function () {
                    //改变品牌
                    this.brands.forEach(function (value, index, array) {

                        if (editGood.good.brandId == value.id) {
                            $("#brand").val(index);
                            $('#brand').trigger('change');
                            return;
                        }

                    });
                    //切换菜单
                    this.initIsFood();
                }
            },

        });
        //大类的响应
        $('#bigType').change(function () {
            var bigIndex = $(this).children('option:selected').val();
            editGood.bigTypeIndex = bigIndex;

            editGood.minType = [];
            editGood.midType = [];

            editGood.midTypeIndex = -1;
            editGood.minTypeIndex = -1;


            var data = {};
            data.bigTypeId = editGood.bigType[bigIndex].id;
            $.ajax({
                type: "POST",
                url: "goodType/getAllMidType",
                dataType: "json",
                data: data,
                success: function (result) {
                    editGood.midType = result.data;
                    $('#midType').select2();
                },
                error: function () {

                }
            });

        });
        //中类的响应
        $('#midType').change(function () {
            var midIndex = $(this).children('option:selected').val();
            editGood.midTypeIndex = midIndex;

            editGood.minType = [];


            editGood.minTypeIndex = -1;


            var data = {};
            data.midTypeId = editGood.midType[midIndex].id;
            $.ajax({
                type: "POST",
                url: "goodType/getAllMinType",
                dataType: "json",
                data: data,
                success: function (result) {
                    editGood.minType = result.data;
                    $('#minType').select2();
                },
                error: function () {

                }
            });

        });
        //小类的响应
        $('#minType').change(function () {
            var minIndex = $(this).children('option:selected').val();
            editGood.minTypeIndex = minIndex;
            editGood.good.goodTypeId = editGood.minType[minIndex].id;

        });
        //品牌的响应
        $('#brand').change(function () {
            alert("ok")
            var index = $(this).children('option:selected').val();
            editGood.brandIndex = index;
            editGood.good.brandId = editGood.brands[index].id;
            editGood.good.brandName = editGood.brands[index].brandName;

        });


        //删除展示图片
        function deleteShowImage(index, event) {

            $(event).parent().remove();
            editGood.showImgList[index] = null;

        }

        //删除详情图片
        function deleteDetailImage(index, event) {

            $(event).parent().remove();
            editGood.detailImgList[index] = null;

        }

        //删除文件
        function deleteupFile(index, event) {
            $(event).parent().remove();
            editGood.fileList[index] = null;

        }
    });

    $('#addGoods').load($("#addGoods").attr("include-html"), function () {
        $("#isFood").show();
        $("#navHeader").hide();

        // 编辑商品
        var editGood = new Vue({
            el: "#editGood",
            data() {
                return{
                    //商品
                    good: {foodFlag : 1,goodTypeId : -1, brandId : 2,minOrderCnt : 0,
                        pMemPrice : 0, price : 0,discountPrice : 0,dMemPrice : 0,taxRate : 1,prjPrice :0,salePrice:0},

                    //分类的数组
                    bigType: [],
                    midType: [],
                    minType: [],
                    //品牌
                    brands: [],
                    //分类的初始指针

                    brandIndex: -1,
                    bigTypeIndex: -1,
                    midTypeIndex: -1,
                    minTypeIndex: -1,

                    //品牌
                    brand: [],

                    //图片文件
                    fileList: store.state,
                    detailImgList: store.state,
                    showImgList: store.state,
                    firstShowImgList: [],


                }
            },
            created: function () {
                this.getAllBigType();
                this.getAllBrand();
            },
            computed: {

                goodCode: function () {
                    var goodCode = "0000";

                    if (this.minType.length > 0 && this.minTypeIndex >= 0) {
                        goodCode = this.bigType[this.bigTypeIndex].code + "" + this.midType[this.midTypeIndex].code + "" + this.minType[this.minTypeIndex].code;
                    }

                    return goodCode;
                },
            },
            methods: {
                //删除展示存在的照片
                deleteExitedImg: function (imgId, event) {

                    console.log(event.currentTarget);
                    $(event.currentTarget).parent().remove();
                    this.showImgDeList.push(imgId);
                    console.log(this.showImgDeList);
                },
                //删除细节存在的照片
                deleteDetailExitedImg: function (imgId, event) {
                    console.log(event.currentTarget);
                    $(event.currentTarget).parent().remove();
                    this.detailImgDeList.push(imgId);
                    console.log(this.detailImgDeList);
                },
                //删除证书存在的照片
                deleteDocExitedImg: function (imgId, event) {
                    console.log(event.currentTarget);
                    $(event.currentTarget).parent().remove();
                    this.upFileDeList.push(imgId);
                    console.log(this.upFileDeList);
                },
                //初始化是否为food菜单
                initIsFood: function (good) {
                    if (good.foodFlag == 1) {
                        $("#isFood").show();
                    }
                    if (good.foodFlag == 0) {
                        $("#isNoFood").show();
                    }
                },
             
                //保存商品
                saveGood: function(){
                    //
                    var formData = new FormData();
                    //保存照片
                    this.showImgList.showImgList.forEach(function (val){
                        if(val != null) {
                            formData.append("showfile",val);
                        }
                    });
                    this.detailImgList.detailImgList.forEach(function (val) {
                        if(val != null){
                            formData.append("detailfile",val);
                        }
                    });

                    this.fileList.fileList.forEach(function (val) {
                        if(val != null){
                            formData.append("docfile",val);
                        }
                    });

                    this.detailImgList.detailImgList = null;
                    this.showImgList.showImgList = null;
                    this.fileList.fileList = null;
                    formData.append("firstfile",this.firstShowImgList);
                    // 保存商品
                    formData.append("goodName", EliminateUndefined(editGood.good.goodName));
                    formData.append("englishName", EliminateUndefined(editGood.good.englishName));
                    formData.append("goodTypeId", EliminateUndefined(editGood.good.goodTypeId));
                    formData.append("foodFlag", EliminateUndefined(editGood.good.foodFlag));
                    formData.append("par", EliminateUndefined(editGood.good.par));
                    formData.append("reserveCnt", EliminateUndefined(editGood.good.reserveCnt));
                    formData.append("producer", EliminateUndefined(editGood.good.producer));
                    formData.append("brandId", EliminateUndefined(editGood.good.brandId));
                    formData.append("series", EliminateUndefined(editGood.good.series));
                    formData.append("type", EliminateUndefined(editGood.good.type));
                    formData.append("location", EliminateUndefined(editGood.good.location));
                    formData.append("minUnit", EliminateUndefined(editGood.good.minUnit));
                    formData.append("salePkgUnit", EliminateUndefined(editGood.good.salePkgUnit));
                    formData.append("unitConvRate", EliminateUndefined(editGood.good.unitConvRate));
                    formData.append("size", EliminateUndefined(editGood.good.size));
                    formData.append("pkgSize", EliminateUndefined(editGood.good.pkgSize));
                    formData.append("material", EliminateUndefined(editGood.good.material));
                    formData.append("netWeight", EliminateUndefined(editGood.good.netWeight));
                    formData.append("grossWeight", EliminateUndefined(editGood.good.grossWeight));
                    formData.append("vol", EliminateUndefined(editGood.good.vol));
                    formData.append("shelfLife", EliminateUndefined(editGood.good.shelfLife));
                    formData.append("color", EliminateUndefined(editGood.good.color));
                    formData.append("tech", EliminateUndefined(editGood.good.tech));
                    formData.append("otherSpec", EliminateUndefined(editGood.good.otherSpec));
                    formData.append("minOrderCnt", EliminateUndefined(editGood.good.minOrderCnt));
                    formData.append("recDays", EliminateUndefined(editGood.good.recDays));
                    formData.append("prodNo", EliminateUndefined(editGood.good.prodNo));
                    formData.append("foodAdd", EliminateUndefined(editGood.good.foodAdd));
                    formData.append("alcohol", EliminateUndefined(editGood.good.alcohol));
                    formData.append("winType", EliminateUndefined(editGood.good.winType));
                    formData.append("winLevel", EliminateUndefined(editGood.good.winLevel));
                    formData.append("franceLocation", EliminateUndefined(editGood.good.franceLocation));
                    formData.append("grapeType", EliminateUndefined(editGood.good.grapeType));
                    formData.append("sugar", EliminateUndefined(editGood.good.sugar));
                    formData.append("level", EliminateUndefined(editGood.good.level));
                    formData.append("soberTime", EliminateUndefined(editGood.good.soberTime));
                    formData.append("pickYear", EliminateUndefined(editGood.good.pickYear));
                    formData.append("scent", EliminateUndefined(editGood.good.scent));
                    formData.append("style", EliminateUndefined(editGood.good.style));
                    formData.append("filler", EliminateUndefined(editGood.good.filler));
                    formData.append("fabric", EliminateUndefined(editGood.good.fabric));
                    formData.append("yarnCount", EliminateUndefined(editGood.good.yarnCount));
                    formData.append("density", EliminateUndefined(editGood.good.density));
                    formData.append("pic", EliminateUndefined(editGood.good.pic));
                    formData.append("voltage", EliminateUndefined(editGood.good.voltage));
                    formData.append("power", EliminateUndefined(editGood.good.power));
                    formData.append("installMethod", EliminateUndefined(editGood.good.installMethod));
                    formData.append("afterService", EliminateUndefined(editGood.good.afterService));
                    formData.append("brandId", EliminateUndefined(editGood.good.brandId));
                    formData.append("brandName", EliminateUndefined(editGood.good.brandName));
                    formData.append("description", EliminateUndefined(editGood.good.description));
                    formData.append("salePrice", EliminateUndefined(editGood.good.salePrice));
                    formData.append("pMemPrice", EliminateUndefined(editGood.good.pMemPrice));
                    formData.append("dMemPrice", EliminateUndefined(editGood.good.dMemPrice));
                    formData.append("prjPrice", EliminateUndefined(editGood.good.prjPrice));
                    formData.append("discountPrice", EliminateUndefined(editGood.good.discountPrice));
                    formData.append("price", EliminateUndefined(editGood.good.price));
                    formData.append("taxRate",editGood.good.taxRate);
                    formData.append("supplierId",supplierId);

                    $.ajax({
                        url : "good/saveGood",
                        type : 'POST',
                        data : formData,
                        enctype: 'multipart/form-data',
                        cache : false,
                        traditional:true,
                        contentType : false,
                        processData : false,
                        success:function(data){
                            if(data.status==1)
                            {
                                //save success
                                $.Hmodal({
                                    height:"200px",
                                    width:"200px",
                                    body:"<div><form>" +
                                    "<div>'保存成功'</div>" +
                                    "<div class='h-modal-footer'>" +
                                    "<button  <button type=\"button\" class= 'btn c-theme-btn c-btn-border-2x c-btn-square c-btn-bold c-btn-uppercase cancel'>关闭</button>" +
                                    " <button type=\"button\" class='btn c-theme-btn c-btn-border-2x c-btn-square c-btn-bold c-btn-uppercase   submit'>提交</button></div>" +
                                    "</form></div>",

                                });


                            }else
                            {
                                alert("保存失败，请稍后重试");
                            }
                        },
                        error:function()
                        {
                            alert("保存失败，请稍后重试");
                        }
                    });


                },
                //切换食品菜单
                cheackFood: function () {
                    $("#isFood").show();
                    $("#isNoFood").hide();
                },
                cheackNoFood: function(){
                    $("#isNoFood").show();
                    $("#isFood").hide();
                },
                //封面图
                firstShowImg: function (event) {
                    this.tirggerFile(event);
                    var fristShowImg = event.target.files[0];
                    this.firstShowImgList = fristShowImg;

                },
                //展示图
                showImg: function (event) {

                    var showImg = event.target.files[0];

                    var listIndex = this.showImgList.showImgList.push(showImg) - 1;
                    this.tirggerShowFile(showImg, listIndex);
                },
                //详细图
                detailImg: function (event) {
                    var detailImg = event.target.files[0];
                    var listIndex = this.detailImgList.detailImgList.push(detailImg) - 1;
                    this.tirggerDetailFile(detailImg, listIndex);

                },
                //文件上传
                upFile: function (event) {

                    var file = event.target.files[0];

                    var fileIndex = this.fileList.fileList.push(file) - 1;
                    this.tirggeruploadFile(file, fileIndex);

                },
                //上传文件预览
                tirggeruploadFile: function (event, fileIndex) {
                    var imgurl;
                    // var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(event);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;


                        $("#upfile").append("<div class='col-md-2' style='width: 12%;height: 100px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteupFile(" + fileIndex + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");

                    }


                },
                //上传图片预览
                tirggerFile: function (event) {

                    var imgurl;
                    var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(file);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;
                        console.log($(event.target).prev());
                        $(event.target).prev().attr("src", imgurl);


                    }

                },
                //上传图片预览
                tirggerShowFile: function (file, index) {

                    var imgurl;
                    // var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(file);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;

                        $("#showImage").append("<div class='col-md-2' style='width: 12%;height: 100px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteShowImage(" + index + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");
                        // $("#showImage").append("<div class='col-md-2' style='width: 12%;'><div class='inputbg' style='background: url("+imgurl+");background-size: cover '></div></div>");


                    }

                },
                //上传图片预览
                tirggerDetailFile: function (file, index) {

                    var imgurl;
                    // var file = event.target.files[0];

                    //建一条文件流来读取图片
                    var reader = new FileReader();
                    //根据url将文件添加的流中
                    reader.readAsDataURL(file);
                    //实现onload接口
                    reader.onload = function (e) {
                        //获取文件在流中url
                        imgurl = reader.result;

                        $("#detailImage").append("<div class='col-md-2' style='width: 12%;height: 100px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteDetailImage(" + index + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");

                    }

                },

                preShow: function () {
                    $("#isNoFood").hide();
                    $("#isFood").hide();
                    $("#goodShow").toggle();
                    $("#editGood").toggle();
                },
                getAllBigType: function () {
                    var data = {};
                    _this = this;
                    $.ajax({
                        type: "POST",
                        url: "goodType/getAllBigType",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            _this.bigType = result.data;
                            _this.$nextTick(function () {
                                $('#bigType').select2();
                                $('#midType').select2();
                                $('#minType').select2();
                            })
                        },
                        error: function () {

                        }
                    });
                },
                //获取商品的所有品牌
                getAllBrand: function () {
                    var data = {};
                    _this = this;
                    $.ajax({
                        type: "POST",
                        url: "brand/getAllBrand",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            _this.brands = result.data;
                            _this.$nextTick(function () {
                                $('#brand').select2();
                            })
                        },
                        error: function () {

                        }
                    });
                },
            },
            watch: {

                good: function () {

                    this.brands.forEach(function (value, index, array) {

                        if (editGood.good.brandId == value.id) {
                            $("#brand").val(index);
                            $('#brand').trigger('change');
                            return;
                        }

                    });

                }
            },

        });
        //大类的响应
        $('#bigType').change(function () {
            var bigIndex = $(this).children('option:selected').val();
            editGood.bigTypeIndex = bigIndex;

            editGood.minType = [];
            editGood.midType = [];

            editGood.midTypeIndex = -1;
            editGood.minTypeIndex = -1;


            var data = {};
            data.bigTypeId = editGood.bigType[bigIndex].id;
            $.ajax({
                type: "POST",
                url: "goodType/getAllMidType",
                dataType: "json",
                data: data,
                success: function (result) {
                    editGood.midType = result.data;
                    $('#midType').select2();
                },
                error: function () {

                }
            });

        });
        //中类的响应
        $('#midType').change(function () {
            var midIndex = $(this).children('option:selected').val();
            editGood.midTypeIndex = midIndex;

            editGood.minType = [];


            editGood.minTypeIndex = -1;


            var data = {};
            data.midTypeId = editGood.midType[midIndex].id;
            $.ajax({
                type: "POST",
                url: "goodType/getAllMinType",
                dataType: "json",
                data: data,
                success: function (result) {
                    editGood.minType = result.data;
                    $('#minType').select2();
                },
                error: function () {

                }
            });

        });
        //小类的响应
        $('#minType').change(function () {
            var minIndex = $(this).children('option:selected').val();
            editGood.minTypeIndex = minIndex;
            editGood.good.goodTypeId = editGood.minType[minIndex].id;

        });
        //品牌的响应
        $('#brand').change(function () {
            var index = $(this).children('option:selected').val();
            editGood.brandIndex = index;
            editGood.good.brandId = editGood.brands[index].id;
            editGood.good.brandName = editGood.brands[index].brandName;

        });

        //删除展示图片
        function deleteShowImage(index, event) {

            $(event).parent().remove();
            editGood.showImgList[index] = null;

        }

        //删除详情图片
        function deleteDetailImage(index, event) {

            $(event).parent().remove();
            editGood.detailImgList[index] = null;

        }

        //删除文件
        function deleteupFile(index, event) {
            $(event).parent().remove();
            editGood.fileList[index] = null;

        }
    });
});
