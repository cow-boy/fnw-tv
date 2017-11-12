layui.use(['carousel', 'form'], function(){
    var carousel = layui.carousel
        ,form = layui.form;

    //图片轮播
    carousel.render({
        elem: '#test10'
        ,width: '936px'
        ,height: '316px'
        ,interval: 5000
    });

});