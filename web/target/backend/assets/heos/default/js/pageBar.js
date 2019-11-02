
    //公共变量
    //链接
    var url;
    //数据
    var datas;
var postPageInfo = function (pageData,pageUrl) {
    datas = pageData;
    url = pageUrl;

    // 全局注册Parent组件

    // return pageInfoList;
}

var initPageBar = function () {
    // function sortNumber(a,b) {
    //     return a-b
    // }
    var pageBar = {
        name: "pageBar",
        template:
        '<div  id = \'bar\' style="text-align:center ">' +
        '<ul class=\'c-content-pagination c-theme\'>' +
        '<li>共</li>' +
        '<li>{{pageTotal}}</li>' +
        '<li>条</li>' +
        '<li>/每页</li>' +
        '<li>' +
        '<select v-model="pageSize" v-on:change="change()">' +
        '<option v-for="value in  pageSizeArray">{{value}}</option>' +
        '</select>' +
        '</li>' +
        '<li>条</li>' +
        '<li class=\'c-first\'><a v-on:click="jumpFirstPage()"><i class=\'fa fa-angle-double-left\'></i></a></li>&nbsp;' +
        '<li class=\'c-prev \'><a v-on:click = "prePage()"><i class=\'fa fa-angle-left \'></i></a></li>&nbsp;' +
        '<li v-for = "page in indexList" v-bind:class="{\'c-active\':pageIndex == page}" >' +
        '<a v-on:click="jumpPage(page)">{{page}}</a>' +
        '</li>&nbsp;' +
        '<li class=\'c-next\'><a v-on:click = "nextPage()"><i class=\'fa fa-angle-right\'></i></a></li>&nbsp;' +
        '<li class=\'c-last\'><a v-on:click="jumpEndPage()"><i class=\'fa fa-angle-double-right\'></i></a></li>' +
        '<li class=\'c-content-pagination c-theme\'>共</li>' +
        '<li>{{pageNum}}</li>' +
        '<li class=\'c-content-pagination c-theme\'>页</li>' +
        '</ul>' +
        '</div>',

        data:function() {
            return {
                select :store.state.select,
                pageSignSize : 9,
                //记录条数
                pageTotal: 0,
                pageIndex: 1,
                //指针

                firstPage: 1,
                pageSize: 5,
                pageSizeArray: [5,10,20],

            }
        },
        created: function(){
            //展示表格共用数据

            this.getPageInfo();
        },
        computed:{

            pageNum: function(){
                var num;
                if(this.pageTotal<=this.pageSize&& this.pageTotal>0){
                    num = 1;
                }
                if(this.pageTotal <= 0){
                    num = 0;
                }
                if(this.pageTotal>this.pageSize){
                    var page = parseInt(this.pageTotal/this.pageSize);
                    var reslut = this.pageTotal%this.pageSize ;
                    num =  (reslut == 0? page:page+1);
                }

                return num;
            },
            //以当前指针为起点,向两边发散分布
            indexList: function () {
                //分页数
                //以最后一个为起点即pageIndex+(this.pageSignSize-1)/2
                //下限
                //如果pageIndex-(this.pageSignSize-1)/2<1即已1为起点
                //如果不是的话pageIndex-(this.pageSignSize-1)/2为起点
                //上限
                // pageIndex+(this.pageSignSize-1)/2>pageTotal
                //则以pageTotal-（pageSi-1）为起点
                //不是的话则以pageIndex-(this.pageSignSize-1)/2起点
                var indexArray = [];
                if(this.pageSignSize>=this.pageNum){
                    for(var i = 1; i <= this.pageNum;i++){
                        indexArray.push(i);
                    }
                }else{
                    //下限
                    if(this.pageIndex-(this.pageSignSize-1)/2<1){
                        //以1为起点
                        for(var i = 1;i<=this.pageSignSize;i++){
                            indexArray.push(i);
                        }
                    }
                    //上限
                    else if(this.pageIndex+(this.pageSignSize-1)/2>this.pageNum){
                        //以顶为上限
                        for(var i = this.pageNum-(this.pageSignSize-1);i<=this.pageNum;i++){
                            indexArray.push(i);
                        }
                    }else {
                        //富裕空间
                        for(var i = this.pageIndex-(this.pageSignSize-1)/2;i<=this.pageIndex+(this.pageSignSize-1)/2;i++){
                            indexArray.push(i);
                        }

                    }
                }
                return indexArray ;
            }
        },
        methods:{
            jumpPage: function(index){

                this.pageIndex = index;
                this.getPageInfo();

            },
            nextPage: function(){

                this.pageIndex = this.pageIndex + 1;
                this.getPageInfo();
            },
            prePage: function(){
                this.pageIndex = this.pageIndex - 1;
                this.getPageInfo();

            },
            jumpEndPage: function () {
                this.pageIndex = this.pageNum;
                this.getPageInfo();
            },
            jumpFirstPage: function () {

                this.pageIndex = this.firstPage;
                this.getPageInfo();
            },


            change: function () {
                this.getPageInfo();
            },
            getPageInfo: function(){
                var _this = this;
                var data = datas;
                data.pageIndex = this.pageIndex;
                data.pageSize = this.pageSize;

                $.ajax({
                    type: "POST",
                    url: url,
                    dataType: "json",
                    data: data,
                    async:false,
                    success: function (result) {
                        store.state.listShare= result.data.rows;
                        console.log(result.data.rows)
                        _this.pageTotal = result.data.total;
                        var dnum=result.data.total;
                        if (dnum!=5&&dnum!=10&&dnum!=20&&_this.pageSizeArray.length==3)
                            _this.pageSizeArray.push(dnum);
                    },
                    error: function () {
                        alert("error");
                    }

                });


            }
        },
        
    }
    new Vue({
        el: '#bar',
        components: {
            App: pageBar
        },
        render: function render(h) {
            return h(pageBar);
        }
    });
}

