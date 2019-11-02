var topMenusUrl = "menu/getHeosMenus";
var centerMenusUrl ;
var userType;
var supplierId;
var hotelId;
//获取导航菜单
function getUserInfo(user) {
    userType = user.userType;
    supplierId = user.supplierId;
    hotelId = user.hotelId;
    if(userType == 1){
        topMenusUrl = "menu/getPlatformMenus";
        centerMenusUrl = "menu/getPlatformWorkBenchMenus";
    }
    if(userType == 2){
        topMenusUrl = "menu/getHeosMenus";
        centerMenusUrl = "menu/getHeosWorkBenchMenus";
    }
    if(userType == 3){
        topMenusUrl = "menu/getSupplierMenus";
        centerMenusUrl = "menu/getSupplierWorkBenchMenus";
    }
}
//初始化center中心
function getMenus() {
    $.ajax({

        url :centerMenusUrl ,
        type : 'get',
        data : {},
        dataType:"json",
        cache : false,
        success:function(result){
            if(result.status=1) {

                var sidebarVue=new Vue({
                    el: '#sidebar-menu-1',
                    data: {
                        sidebarMenus: result.data,
                    },

                    methods:{
                        navTo:function(ele) {
                            if($(ele.target).find(".c-arrow").length==0 || $(ele.target).parents(".c-dropdown-menu").length>0) {
                                $('#sidebar-menu-1').find(".c-active").removeClass("c-active");
                                $(ele.target).parents("li").addClass("c-active");
                                $(ele.target).parents(".c-dropdown").addClass("c-active");

                                $("#breadcrumb").html( $(ele.target).html());
                                $("#pageContent").load($(ele.target).attr("link"),function () {
                                    $('.singleSelect').select2();
                                });
                            }
                        },

                    }
                });
                LayoutSidebarMenu.init();
            }else {
                alertError("获取菜单失败，请稍后重试");
            }
        },
        error:function() {
            alertError("获取菜单失败，请稍后重试");
        }
    });
}
//会员中心- Vip
//网上展馆- onLine
//首页- firstPage
//虚拟酒店- falseHEOS
//供方资源- applyResource
var initNavigation = function (navigation){
    // 头部
    $('header').load($("header").attr("include-html"),function(){


        //登录和注销
        var loginOrCancel = new Vue({
            el: "#loginOrCancel",
            data(){
                return{
                    loginOrCancelUser: []
                }
            },
            created: function(){
                this.getLoginInfo();
            },
            computed: {
                nowDate: function(){
                    var dateHello = "你好！";
                    now = new Date();
                    hour = now.getHours();
                    if(hour < 6){
                        dateHello ="凌晨好！";
                    }
                    else if (hour < 9){
                        dateHello = "早上好！";
                    }
                    else if (hour < 12){
                        dateHello = "上午好！";
                    }
                    else if (hour < 14){
                        dateHello = "中午好！";
                    }
                    else if (hour < 17){
                        dateHello = "下午好！";
                    }
                    else if (hour < 19){
                        dateHello = "傍晚好！"
                    }
                    else if (hour < 22){
                        dateHello = "晚上好！";
                    }
                    else {
                        dateHello = "夜里好！";
                    }
                    return dateHello;
                }
            },
            methods: {
                //注销当前用户
                cancel: function(){
                    var data = {};
                    $.ajax({
                        type:"Post",
                        url:"user/cancel",
                        dataType:"json",
                        data:data,
                        success:function(result){
                            if(result.status == 1 && result.data.loginStatus == 0) {
                                loginOrCancel.loginOrCancelUser = null;
                                $("#onLogin").toggle();
                                $("#goLogin").toggle();

                            }


                        },
                        error:function () {

                        }
                    });
                },
                //加载页面是验证是否由用户已经登录
                getLoginInfo: function(){
                    var data = {};
                    $.ajax({
                        type:"Post",
                        url:"user/cheackLoginStatus",
                        dataType:"json",
                        data:data,
                        success:function(result){
                            if(result.status == 1 && result.data.loginStatus == 1) {

                                getUserInfo(result.data);
                                loginOrCancel.loginOrCancelUser = result.data;
                                $("#onLogin").toggle();
                                $("#goLogin").toggle();
                                //初始化导航菜单


                            }

                            var nav = new Vue({
                                el: "#nav",
                                data(){
                                    return{
                                        allMenus: []
                                    }
                                },
                                created: function(){
                                    this.getAllMenus();
                                    //渲染结束后点亮抬头导航图标

                                },

                                methods: {
                                    getAllMenus: function(){
                                        var data = {};
                                        _this = this;
                                        $.ajax({
                                            type:"POST",
                                            url:topMenusUrl,
                                            dataType:"json",
                                            data:data,
                                            async:false,
                                            success:function(result){
                                                _this.allMenus = result.data;
                                                _this.$nextTick(function () {
                                                    //页面抬头导航标签图案点亮
                                                    $(navigation).addClass("c-active");
                                                });
                                            },
                                            error:function () {

                                            }
                                        });
                                    }
                                }
                            });
                            //初始化center中心
                            if(navigation == "#Vip"){
                                getMenus();
                            }
                        },
                        error:function () {

                        }
                    });
                }
            }
        });
    });


    //弹窗
    //弹窗加载后初始化Vue
    $('#form').load($("#form").attr("include-html"),function () {

        //手机号检查
        function isPoneAvailable(poneInput) {
            var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
            if (!myreg.test(poneInput)) {
                return false;
            } else {
                return true;
            }
        }

        //邮箱检查
        var cheackEmail = function(email){


                var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                var isEmail = reg.test(email);
                return isEmail;

        }

        //登录
        var login = new Vue({
            el: "#login-form",
            data(){
                return{
                    loginUser: [null],
                    message: "",
                    tick: false
                }
            },
            created: function(){
                //加载页面是验证是否由用户已经登录

                this.getTickInfo();
            },
            computed: {
                nowDate: function(){
                    var dateHello = "你好！";
                    now = new Date();
                    hour = now.getHours();
                    if(hour < 6){
                        dateHello ="凌晨好！";
                    }
                    else if (hour < 9){
                        dateHello = "早上好！";
                    }
                    else if (hour < 12){
                        dateHello = "上午好！";
                    }
                    else if (hour < 14){
                        dateHello = "中午好！";
                    }
                    else if (hour < 17){
                        dateHello = "下午好！";
                    }
                    else if (hour < 19){
                        dateHello = "傍晚好！"
                    }
                    else if (hour < 22){
                        dateHello = "晚上好！";
                    }
                    else {
                        dateHello = "夜里好！";
                    }
                    return dateHello;
                }
            },
            methods: {
                //加载页面是验证是否由用户已经登录
                getTickInfo: function(){

                    var data = {};
                    $.ajax({

                        type:"POST",
                        url:"user/cheackLoginStatus",
                        dataType:"json",
                        data:data,
                        success:function(result){
                            if(result.status == 1) {

                                if(result.data.tick == true){
                                    login.loginUser = result.data;
                                    login.tick = result.data.tick;
                                }

                            }


                        },
                        error:function () {

                        }
                    });
                },
                //打钩记住
                tickTheRemember: function(){
                    var data = {};
                    data.tick = this.tick;
                    $.ajax({
                        type: "POST",
                        url: "user/tickRemember",
                        dataType: "json",
                        data: data,
                        success: function (result) {
                            if(result.status == 1){

                            }

                        },
                        error: function () {

                        }
                    });
                },
                //登录提交
                login: function(){

                    if(this.loginUser.password == undefined  ){
                        alert("请输入密码");
                        return;
                    }
                    if(this.loginUser.password != undefined && this.loginUser.phone != undefined) {
                        var data = {};
                        data.phone = this.loginUser.phone;
                        data.password = this.loginUser.password;
                        $.ajax({
                            type: "POST",
                            async:false,
                            url: "user/login",
                            dataType: "json",
                            data: data,
                            success: function (result) {
                                if(result.status == 1){
                                    loginOrCancel.loginOrCancelUser = result.data;
                                    $("#onLogin").toggle();
                                    $("#goLogin").toggle();

                                }

                            },
                            error: function () {
                                alert("登录失败");
                            }
                        });



                    }
                },
                //验证邮箱
                mouseMoveOut: function(){
                    if(this.loginUser.phone == ""){

                        this.message = "请输入手机号";
                        $("p").css('color','red');
                        return;
                    }
                    var isEmail = isPoneAvailable(this.loginUser.phone);
                    if(!isEmail){

                        this.message = "请输入正确的手机号";

                        $("p").css('color','red');
                        return ;
                    }
                    this.message = "";
                    $("p").css('color',"");

                }
            }
        });


        //忘记密码
        var forgetPassword = new Vue({
            el: "#forget-password-form",
            data(){
                return{
                    forgetPasswordUser: [null],
                    message: "请输入您的账户邮箱地址",
                }
            },
            methods: {

                forgetPassword: function(){
                    alert("forgetPassword");
                },
                mouseMoveOut: function(){

                    if(this.forgetPasswordUser.email == ""){
                        this.message = "请输入邮箱";

                        return;
                    }
                    var isEmail = cheackEmail(this.forgetPasswordUser.email);
                    if(!isEmail){

                        this.message = "请输入正确邮箱";

                        $("p").css('color','red');
                        return ;
                    }
                    this.message = "";
                    $("p").css('color',"");

                }
            }
        });
        //注册
        var sign = new Vue({
            el: "#signup-form",
            data(){
                return{
                    signUser: [null],
                    phoneMessage: "",
                    emailMessage: ""
                }
            },
            methods: {
                mouseMoveOutPhone: function(){
                    if(this.signUser.phone == ""){
                        this.phoneMessage = "请输入手机号";

                        return;
                    }
                    var isEmail = isPoneAvailable(this.signUser.phone);
                    if(!isEmail){

                        this.phoneMessage = "请输入正确的手机号";

                        $("p").css('color','red');
                        return ;
                    }
                    this.phoneMessage = "";
                    $("p").css('color',"");
                },
                sign: function(){


                    if(this.signUser.password != undefined && this.signUser.phone != undefined&& this.signUser.email != undefined && this.signUser.realName != undefined && this.signUser.userName != undefined) {
                        var data = {};
                        data.phone = this.signUser.phone;
                        data.password = this.signUser.password;
                        data.username = this.signUser.userName;
                        data.realName = this.signUser.realName;
                        data.email = this.signUser.email;
                        data.sex = this.signUser.sex;
                        $.ajax({
                            type: "POST",
                            url: "user/register",
                            dataType: "json",
                            data: data,
                            success: function (result) {
                            },
                            error: function () {
                            }
                        });
                    }},
                mouseMoveOut: function(){

                    if(this.signUser.email == ""){
                        this.emailMessage = "请输入邮箱";

                        return;
                    }
                    var isEmail = cheackEmail(this.signUser.email);
                    if(!isEmail){

                        this.emailMessage = "请输入正确邮箱";

                        $("p").css('color','red');
                        return ;
                    }
                    this.emailMessage = "";
                    $("p").css('color',"");

                }
            }
        });

    });

    //底部
    $('footer').load($("footer").attr("include-html"));



    $(document).on({
        ajaxStart: function() { $('body').addClass("loading");    },
        ajaxStop: function() { $('body').removeClass("loading"); }
    });

    $(document).ready(function() {
        $(window).keydown(function(event){
            if(event.keyCode == 13) {
                event.preventDefault();
                return false;
            }
        });
    });

    initMenus();
    $("#menuInd").parent().hide();
    $("#subMenuInd").hide();
}



function initMenus()
{
    $.ajax({
        url : "user/getMenus",
        type : 'POST',
        data : {},
        dataType:"json",
        cache : false,
        success:function(data){
            if(data.status=1) {
                var menus='';
                for (var i = 0; i < data.data.length; i++){
                    var menu=('<a href="#URL#" class="dropdown-toggle">'+
                        '<i class="menu-icon fa #ICON#"></i>'+
                        '<span class="menu-text">#NAME#</span>'+
                        '<b class="arrow fa fa-angle-down"></b>'+
                        '</a>').replace("#NAME#",data.data[i].name)
                        .replace("#URL#",data.data[i].url)
                        .replace("#ICON#",data.data[i].icon);
                    var subMenus='';
                    if(data.data[i].subMenus!=null)
                    {
                        for(var j=0;j<data.data[i].subMenus.length;j++)
                        {
                            subMenus+=('<li class="">'+
                                '	<a onclick="toPage(\'#URL#\',this)">'+
                                '		<i class="menu-icon fa fa-caret-right"></i>'+
                                '<span>#NAME#</span>'+
                                '	</a>'+
                                '	<b class="arrow"></b>'+
                                '</li>').replace("#NAME#",data.data[i].subMenus[j].name)
                                .replace("#URL#",data.data[i].subMenus[j].url);
                        }
                        if(data.data[i].subMenus.length>0)
                        {
                            subMenus='<ul class="submenu">'+subMenus+'</ul>'
                        }
                    }
                    menus+='<li class="">'+menu+subMenus+'</li>';
                }
                $('.nav-list').html(menus);
            }else
            {
                alertError("获取菜单失败，请稍后重试");
            }
        },
        error:function()
        {
            alertError("获取菜单失败，请稍后重试");
        }
    });
}

//validate required,maxLen,int,decimal,maxVal,minVal
function validate(validationRules)
{
    result=true;

    for(var i=0;i<validationRules.length;i++)
    {
        var rule=validationRules[i];
        var fieldName='#'+rule.fieldName;
        var errorMsgs=new Array();
        var value=$(fieldName).val();
        //required
        if(rule.required!=undefined) {
            if (rule.required && value.length == 0) {
                errorMsgs.push("此为必填项");
            }
        }

        //maxLen
        if(rule.maxLen !=undefined)
        {
            if(value.length>rule.maxLen)
            {
                errorMsgs.push("长度超出范围");
            }
        }

        if(rule.type!=undefined)
        {
            if(rule.type=="int")
            {
                if(isNaN(parseInt(value)))
                {
                    errorMsgs.push("数值应为整数");
                    isNumber=false;
                }
            }else if(rule.type=="decimal")
            {
                if(isNaN(parseFloat(decimal)))
                {
                    errorMsgs.push("数值应为浮点数");
                }
            }

            if((rule.type=="int" || rule.type=="decimal") && $.isNumeric(value))
            {
                if(rule.maxVal != undefined)
                {
                    if(parseFloat(value)>rule.maxVal)
                    {
                        errorMsgs.push("应小于"+rule.maxVal);
                    }
                    if(parseFloat(value)<rule.minVal)
                    {
                        errorMsgs.push("应大于"+rule.minVal);
                    }
                }
            }
        }
        if(errorMsgs.length>0)
        {
            result = result && false;
            addErrorTip(fieldName,errorMsgs.join(","));
        }else
        {
            removeErrorTip(fieldName);
        }
    }

    return result;
}

function addErrorTip(selector, errorTip)
{
    $(selector).parents(".form-group").addClass("has-error");
    $(selector).parents(".form-group").find('.help-block').html(errorTip);
}

function removeErrorTip(selector)
{
    $(selector).parents(".form-group").removeClass("has-error");
    $(selector).parents(".form-group").find('.help-block').html("");
}

function alertInfo(info)
{
    $('#infoMsg').html(info);
    $('#infoMsg').parent().fadeIn();
    setTimeout(function(){
        $('#infoMsg').parent().fadeOut();
    },3000);
}

function alertError(err)
{
    $('#errorMsg').html(err);
    $('#errorMsg').parent().fadeIn();
    setTimeout(function(){
        $('#errorMsg').parent().fadeOut();
    },5000);
}

function toPage(url,ele){
    $('#pageContent').load(url);

    $('.nav-list').find("li").removeClass("active");
    $('.nav-list').find("li").removeClass("open");
    $(ele).parents("ul").parents('li').addClass("active");
    $(ele).parents("ul").parents('li').addClass("open")
    $(ele).parent().addClass('active');

    $("#menuInd").parent().show();
    $("#subMenuInd").show();
    $("#menuInd").html($(ele).parents("ul").parents('li').find('a > span')[0].innerHTML);
    $("#subMenuInd").html($(ele).find(':last-child').html());
}
