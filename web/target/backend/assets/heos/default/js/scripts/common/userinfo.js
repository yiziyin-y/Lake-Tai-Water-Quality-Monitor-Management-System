$(document).ready(function() {

    $('#register').load($("#register").attr("include-html"), function () {


        //注册
        var register = new Vue({
            el: "#register",
            data() {
                return {
                    //用户
                    user:{userType: 3,},
                    //供应商
                    supplier: [],
                    //酒店
                    hotel: [],
                    imgList: store.state,
                    hotelList: [],
                    hotelIndex: -1,

                }
            },
            created: function(){
                this.getAllHotel();

            },


            methods: {
                //登录
                register: function(){
                    if(this.user.userType == 3){
                        this.supplierRegister();
                    }
                    if(this.user.userType == 2){
                        this.hotelRegister();
                    }

                },
                //切换酒店名字
                trickHoes: function(){
                    $("#noHaveName").toggle();
                    $("#haveName").toggle();
                },
                //拉取酒店
                getAllHotel: function(){
                    //获取所有的大类

                    var data = {};
                    _this = this;
                    $.ajax({
                        type: "POST",
                        url: "hotel/getAllHotels",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            _this.hotelList = result.data;

                            _this.$nextTick(function () {
                                console.log( _this.hotelList);
                                $('#hotel').select2();

                            });
                        },
                        error: function () {

                        }
                    });

                },
                //上传图片预览
                tirggerFile: function (file, index) {

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

                        $("#image").append("<div class='col-md-2' style='width: 120px;height: 120px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteRegisterImage(" + index + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");

                    }

                },
                //详细图
                upImg: function (event) {
                    var Img = event.target.files[0];
                    var listIndex = this.imgList.cretList.push(Img) - 1;
                    this.tirggerFile(Img, listIndex);

                },
                supplierRegister: function(){
                    var formData = new FormData();
                    register.imgList.forEach(function (val) {
                        if (val != null) {
                            formData.append("imgList", val);
                        }
                    });

                    //用户属性
                    formData.append("username", EliminateUndefined(this.user.username));
                    formData.append("password ", EliminateUndefined(this.user.password));
                    formData.append("phone", EliminateUndefined(this.user.phone));
                    formData.append("userType", EliminateUndefined(this.user.userType));
                    formData.append("sex", EliminateUndefined(this.user.sex));

                    // 供应商属性
                    formData.append("supplierName ", EliminateUndefined(this.supplier.supplierName));
                    formData.append("suppType", EliminateUndefined( this.supplier.suppType));
                    formData.append("taxNo", EliminateUndefined(this.supplier.taxNo));
                    formData.append("bank", EliminateUndefined(this.supplier.bank));
                    formData.append("bankAccount", EliminateUndefined(this.supplier.bankAccount));
                    formData.append("regAddress", EliminateUndefined(this.supplier.regAddress));
                    formData.append("suppLevel", EliminateUndefined(this.supplier.suppLevel));
                    formData.append("contactAddress", EliminateUndefined(this.supplier.contactAddress));
                    formData.append("regCapital", EliminateUndefined(this.supplier.regCapital));
                    formData.append("empCnt", EliminateUndefined(this.supplier.empCnt));
                    formData.append("legalRep", EliminateUndefined(this.supplier.legalRep));
                    formData.append("legalRepPhone", EliminateUndefined(this.supplier.legalRepPhone));

                    formData.append("legalRepEmail", EliminateUndefined(this.supplier.legalRepEmail));
                    formData.append("contact2", EliminateUndefined(this.supplier.contact2));
                    formData.append("contant2Position", EliminateUndefined(this.supplier.contact2Position));
                    formData.append("contact2Email", EliminateUndefined(this.supplier.contact2Email));
                    formData.append("contact2Mobile", EliminateUndefined( this.supplier.contact2Mobile));
                    formData.append("contact2Phone", EliminateUndefined(this.supplier.contact2Phone));

                    formData.append("contact", EliminateUndefined(this.supplier.contact));
                    formData.append("contactPosition", EliminateUndefined(this.supplier.contactPosition));
                    formData.append("contactEmail", EliminateUndefined(this.supplier.contactEmail));
                    formData.append("contactMobile", EliminateUndefined( this.supplier.contactMobile));
                    formData.append("contactPhone", EliminateUndefined(this.supplier.contactPhone));

                    formData.append("qualification", EliminateUndefined(this.supplier.qualification));
                    formData.append("busLicEffFromTime", EliminateUndefined(this.supplier.busLicEffFromTime));
                    formData.append("busLicEffToTime ", EliminateUndefined(this.supplier.busLicEffToTime));

                    formData.append("performance", EliminateUndefined(this.supplier.performance));
                    formData.append("serviceCity", EliminateUndefined(this.supplier.serviceCity));
                    formData.append("contact2Phone", EliminateUndefined(this.supplier.contact2Phone));

                    formData.append("bankAddress", EliminateUndefined(this.supplier.bankProvince+"" + this.supplier.bankCity + "" + this.supplier.bankDistrict));

                    formData.append("province", EliminateUndefined(this.supplier.province));
                    formData.append("city", EliminateUndefined(this.supplier.city));
                    formData.append("district", EliminateUndefined(this.supplier.district));

                    // data.suppCode  = this.supplier.suppCode ;

                    $.ajax({
                        type:"POST",
                        url:"user/supplierRegister",
                        data: formData,
                        enctype: 'multipart/form-data',
                        cache: false,
                        traditional: true,
                        contentType: false,
                        processData: false,
                        success:function(result){

                        },
                        error:function () {

                        }
                    });
                },
                hotelRegister: function () {

                    var data = {};
                    //用户属性
                    data.username = this.user.username;
                    data.password = this.user.password;
                    data.phone = this.user.phone;
                    data.userType = this.user.userType;
                    data.sex = this.user.sex;
                    data.realName = this.user.realName;
                    data.hotelName = this.hotel.hotelName;
                    data.hotelProvince = this.user.hotelProvince;
                    data.hotelCity = this.user.hotelCity;
                    data.hotelDistrict = this.user.hotelDistrict;
                    data.hotelAddress = this.user.hotelAddress;
                    data.hotelId = this.user.hotelId;
                    data.hotelName = this.user.hotelName;
                    //酒店属性
                    // data.hotelName = this.hotel.hotelName;
                    // data.hotelProvince = this.hotel.hotelProvince;
                    // data.hotelCity = this.hotel.hotelCity;
                    // data.hotelDistrict = this.hotel.hotelDistrict;
                    // data.hotelPhone = this.hotel.hotelPhone;
                    // data.hotelAddess = this.hotel.hotelAddess;
                    // data.remak = this.hotel.;
                    //供应商属性

                    $.ajax({
                        type:"POST",
                        url:"user/hotelRegister",
                        dataType:"json",
                        data:data,
                        success:function(result){

                        },
                        error:function () {

                        }
                    });
                },

                //切换供应商
                cheackSupplier: function () {
                    $("#supplier").show();
                    $("#heos").hide();
                },
                //切换酒店
                cheackHotel: function () {
                    $("#supplier").hide();
                    $("#heos").show();
                }
            }
        });
        //删除图片
        function deleteImage(index, event) {

            $(event).parent().remove();
            register.imgList[index] = null;

        }
        //酒店的响应
        $('#hotel').change(function () {
            var index = $(this).children('option:selected').val();
            register.hotelIndex = index;
            register.user.hotelId = register.hotelList[index].id;
            register.user.hotelName = register.hotelList[index].hotelName;

        });
        //初始化地址栏
        $("#supplierDistpicker").distpicker({
            province: '--所在省--',
            city: '--所在市--',
            district: '--所在区--'
        });
        $("#heosDistpicker").distpicker({
            province: '--所在省--',
            city: '--所在市--',
            district: '--所在区--'
        });
        $("#accountDistpicker").distpicker({
            province: '--所在省--',
            city: '--所在市--',
            district: '--所在区--'
        });

    });
    $('#supplierInfo').load($("#supplierInfo").attr("include-html"), function () {
        //初始化地址栏
        $("#heos").hide();
        $("#userCommond").hide();
        $("#button").hide();
        $("#userType").hide();

        //注册
        var register = new Vue({
            el: "#register",
            data() {
                return {
                    //用户
                    user:{userType: 3,},
                    //供应商
                    supplier: store.state,
                    //酒店
                    hotel: [],
                    imgList: [],
                    hotelList: [],
                    hotelIndex: -1,

                }
            },
            created: function(){
                this.getAllHotel();
            },

            methods: {
                //登录
                register: function(){
                    if(this.user.userType == 3){
                        this.supplierRegister();
                    }
                    if(this.user.userType == 2){
                        this.hotelRegister();
                    }

                },
                //切换酒店名字
                trickHoes: function(){
                    $("#noHaveName").toggle();
                    $("#haveName").toggle();
                },
                //拉取酒店
                getAllHotel: function(){
                    //获取所有的大类

                    var data = {};
                    _this = this;
                    $.ajax({
                        type: "POST",
                        url: "hotel/getAllHotel",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            _this.hotelList = result.data;
                            _this.$nextTick(function () {
                                $('#hotel').select2();

                            })
                        },
                        error: function () {

                        }
                    });

                },
                //上传图片预览
                tirggerFile: function (file, index) {

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

                        $("#image").append("<div class='col-md-2' style='width: 120px;height: 120px;'> <img width='100%' height='100%' src= '" + imgurl + "' /><a href='javascript:;' onclick='deleteRegisterImage(" + index + ",this)'><img class=\"img_close\" src=\"assets/base/img/cancel.png\"/></a></div>");

                    }

                },
                //详细图
                upImg: function (event) {
                    var Img = event.target.files[0];
                    var listIndex = this.imgList.push(Img) - 1;
                    this.tirggerFile(Img, listIndex);

                },
                supplierRegister: function(){
                    var formData = new FormData();
                    this.imgList.cretList.forEach(function (val) {
                        if (val != null) {
                            formData.append("imgList", val);
                        }
                    });

                    //用户属性
                    formData.append("username", EliminateUndefined(this.user.username));
                    formData.append("password ", EliminateUndefined(this.user.password));
                    formData.append("phone", EliminateUndefined(this.user.phone));
                    formData.append("userType", EliminateUndefined(this.user.userType));
                    formData.append("sex", EliminateUndefined(this.user.sex));

                    // 供应商属性
                    formData.append("supplierName ", EliminateUndefined(this.supplier.supplierName));
                    formData.append("suppType", EliminateUndefined( this.supplier.suppType));
                    formData.append("taxNo", EliminateUndefined(this.supplier.taxNo));
                    formData.append("bank", EliminateUndefined(this.supplier.bank));
                    formData.append("bankAccount", EliminateUndefined(this.supplier.bankAccount));
                    formData.append("regAddress", EliminateUndefined(this.supplier.regAddress));
                    formData.append("suppLevel", EliminateUndefined(this.supplier.suppLevel));
                    formData.append("contactAddress", EliminateUndefined(this.supplier.contactAddress));
                    formData.append("regCapital", EliminateUndefined(this.supplier.regCapital));
                    formData.append("empCnt", EliminateUndefined(this.supplier.empCnt));
                    formData.append("legalRep", EliminateUndefined(this.supplier.legalRep));
                    formData.append("legalRepPhone", EliminateUndefined(this.supplier.legalRepPhone));

                    formData.append("legalRepEmail", EliminateUndefined(this.supplier.legalRepEmail));
                    formData.append("contact2", EliminateUndefined(this.supplier.contact2));
                    formData.append("contant2Position", EliminateUndefined(this.supplier.contact2Position));
                    formData.append("contact2Email", EliminateUndefined(this.supplier.contact2Email));
                    formData.append("contact2Mobile", EliminateUndefined( this.supplier.contact2Mobile));
                    formData.append("contact2Phone", EliminateUndefined(this.supplier.contact2Phone));

                    formData.append("contact", EliminateUndefined(this.supplier.contact));
                    formData.append("contactPosition", EliminateUndefined(this.supplier.contactPosition));
                    formData.append("contactEmail", EliminateUndefined(this.supplier.contactEmail));
                    formData.append("contactMobile", EliminateUndefined( this.supplier.contactMobile));
                    formData.append("contactPhone", EliminateUndefined(this.supplier.contactPhone));

                    formData.append("qualification", EliminateUndefined(this.supplier.qualification));
                    formData.append("busLicEffFromTime", EliminateUndefined(this.supplier.busLicEffFromTime));
                    formData.append("busLicEffToTime ", EliminateUndefined(this.supplier.busLicEffToTime));

                    formData.append("performance", EliminateUndefined(this.supplier.performance));
                    formData.append("serviceCity", EliminateUndefined(this.supplier.serviceCity));
                    formData.append("contact2Phone", EliminateUndefined(this.supplier.contact2Phone));

                    formData.append("bankAddress", EliminateUndefined(this.supplier.bankProvince+"" + this.supplier.bankCity + "" + this.supplier.bankDistrict));

                    formData.append("province", EliminateUndefined(this.supplier.province));
                    formData.append("city", EliminateUndefined(this.supplier.city));
                    formData.append("district", EliminateUndefined(this.supplier.district));

                    // data.suppCode  = this.supplier.suppCode ;

                    $.ajax({
                        type:"POST",
                        url:"user/supplierRegister",
                        data: formData,
                        enctype: 'multipart/form-data',
                        cache: false,
                        traditional: true,
                        contentType: false,
                        processData: false,
                        success:function(result){

                        },
                        error:function () {

                        }
                    });
                },
                hotelRegister: function () {

                    var data = {};
                    //用户属性
                    data.username = this.user.username;
                    data.password = this.user.password;
                    data.phone = this.user.phone;
                    data.userType = this.user.userType;
                    data.sex = this.user.sex;
                    data.realName = this.user.realName;
                    data.hotelName = this.hotel.hotelName;
                    data.hotelProvince = this.user.hotelProvince;
                    data.hotelCity = this.user.hotelCity;
                    data.hotelDistrict = this.user.hotelDistrict;
                    data.hotelAddress = this.user.hotelAddress;
                    data.hotelId = this.user.hotelId;
                    data.hotelName = this.user.hotelName;
                    //酒店属性
                    // data.hotelName = this.hotel.hotelName;
                    // data.hotelProvince = this.hotel.hotelProvince;
                    // data.hotelCity = this.hotel.hotelCity;
                    // data.hotelDistrict = this.hotel.hotelDistrict;
                    // data.hotelPhone = this.hotel.hotelPhone;
                    // data.hotelAddess = this.hotel.hotelAddess;
                    // data.remak = this.hotel.;
                    //供应商属性

                    $.ajax({
                        type:"POST",
                        url:"user/hotelRegister",
                        dataType:"json",
                        data:data,
                        success:function(result){

                        },
                        error:function () {

                        }
                    });
                },

                //切换供应商
                cheackSupplier: function () {
                    $("#supplier").show();
                    $("#heos").hide();
                },
                //切换酒店
                cheackHotel: function () {
                    $("#supplier").hide();
                    $("#heos").show();
                }
            }
        });


        //删除图片
        function deleteRegisterImage(index, event) {

            $(event).parent().remove();
            register .imgList.cretList[index] = null;

        }
        //酒店的响应
        $('#hotel').change(function () {
            var index = $(this).children('option:selected').val();
            register.hotelIndex = index;
            register.user.hotelId = register.hotelList[index].id;
            register.user.hotelName = register.hotelList[index].hotelName;

        });
        //地址初始化
        // $("#supplierDistpicker").distpicker({
        //     province: '--'+register.supplier.province + "--",
        //     city: '--' + register.supplier.city + '--',
        //     district: '--' + register.supplier.district + '--',
        // });
        $("#supplierDistpicker").distpicker({
            province: '--所在省--',
            city: '--所在市--',
            district: '--所在区--'
        });
        $("#heosDistpicker").distpicker({
            province: '--所在省--',
            city: '--所在市--',
            district: '--所在区--'
        });
        $("#accountDistpicker").distpicker({
            province: '--所在省--',
            city: '--所在市--',
            district: '--所在区--'
        });

    });
});