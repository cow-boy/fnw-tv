


var sptdata = {
    init:function () {
        sptdata.getSpts();
    },
    getSpts:function () {
        $.ajax({
            type:"post",
            url:"/spt/spts",
            async:true,
            dataType:"json",
            success:function(data){
                if (data != null || data != '') {
                    clSptData(data);
                }
            },
            error:function(err){
                console.log(err);
            }
        });
    }
}

$(function(){
    sptdata.init();
})

var clSptData = function (data) {
    console.info(data);
    var html = '';
        for (var i in data) {
            var d = data[i];
            html += '<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i><div class="layui-timeline-content layui-text"><h3 class="layui-timeline-title">';
            html += d.hTime;
            html += '</h3>';
        }


}
