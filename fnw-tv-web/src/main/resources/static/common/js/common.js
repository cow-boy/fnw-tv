//swiper
window.onload = function() {
    var mySwiper1 = new Swiper('#headerdh',{
        freeMode : true,
        slidesPerView : 'auto',
        freeModeSticky : true ,
    });
}

<!-- 底部悬浮 -->
$(function () {
    var e = $(".itop");
    $(window).scroll(function () {
        var t = $(document).scrollTop();
        if (t > 300) {
            e.fadeIn("slow")
        } else {
            e.fadeOut("slow")
        }
    });

});
$(".itop").click(function () {
    $("html,body").animate({scrollTop: 0}, 500)
})


layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;
    layer.msg('欢迎享受视频乐趣',{icon: 1});
});

//判断是PC还是手持
function IsPC(){
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = false; break; }
    }
    return flag;
}
if (IsPC()) {
    //显示效果
    window.onload = function() {
        var config = {
            vx: 4,
            vy: 4,
            height: 2,
            width: 2,
            count: 200,
            color: "121, 162, 185",
            stroke: "130,255,255",
            dist: 6000,
            e_dist: 20000,
            max_conn: 10
        }
        CanvasParticle(config);
    }
}

//自定义字典对象
function Dictionary(){
    this.data = new Array();

    this.put = function(key,value){
        this.data[key] = value;
    };

    this.get = function(key){
        return this.data[key];
    };

    this.remove = function(key){
        this.data[key] = null;
    };

    this.isEmpty = function(){
        return this.data.length == 0;
    };

    this.size = function(){
        return this.data.length;
    };
}

function getElementsByClassName(clsName, tagName,flag) {
    var selElements = document.getElementsByTagName(tagName);
    for (var i = 0; i < selElements.length; i++) {
        if (selElements[i].className.indexOf(clsName) != -1) {
            if(!flag){
                selElements[i].style.display='none';
            }else{
                selElements[i].style.display ='';
            }
        }
    }
}