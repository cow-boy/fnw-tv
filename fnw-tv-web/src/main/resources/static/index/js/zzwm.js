layui.use('layer', function(){
    var $ = layui.jquery, layer = layui.layer;
    var active = {
        notice: function(){
            layer.open({
                type: 1
                ,anim: 1
                ,offset: '200px'
                ,title: false
                ,closeBtn: false
                ,area: '440px;'
                ,shade: 0.5
                ,id: 'LAY_layuipro'
                ,btn: ['我已赞助', '残忍拒绝']
                ,btnAlign: 'c'
                ,moveType: 1
                ,content: '<div style="padding: 16px;">' +
                '<img src="video/pic/wxpay.jpg" style="float: left"><img src="video/pic/zfbpay.jpg"></div>'
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        href: 'javascript:void(0)',
                        target: '_blank'
                    });
                }
            });
        }
    };
    $('#layerDemo .layui-btn').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
});