


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
            console.info("prop: " + i + " value: " + data[i])
            var d = data[i];
            html += '<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i><div class="layui-timeline-content layui-text"><h3 class="layui-timeline-title">';
            html += i;
            html += '</h3><table class="layui-table" lay-skin="line"><colgroup><col width="80"><col width="150"><col width="100"><col width="80"><col width="5"><col width="80"><col width="100"><col></colgroup><tbody>';
            var dat = data[i];
            for (var j in dat) {
                var da = dat[j];
                html += '<tr>';
                html += '<td>11：30</td>';
                html += '<td>NBA常规赛</td>';
                html += '<td>掘金</td>';
                html += '<td><img src="http://duihui.qiumibao.com/zuqiu/chaoxian.png"></td>';
                html += '<td>-</td>';
                html += '<td><img src="http://duihui.qiumibao.com/zuqiu/zhongguo.png"></td>';
                html += '<td>雷霆</td>';
                html += '<td>互动直播 文字 手机看直播 比分 NBA游戏46</td>';
                html += '</tr>';
            }
            html += '</tbody></table></div></li>';
        }
    $('#matchId').html(html);

}
