
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
            html += '<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i><div class="layui-timeline-content layui-text"><h3 class="layui-timeline-title">';
            html += i;
            html += '</h3><table class="layui-table" lay-skin="line"><colgroup><col width="60"><col width="150"><col width="100"><col width="80"><col width="1"><col width="80"><col width="100"><col></colgroup><tbody>';
            var dat = data[i];
            for (var j in dat) {
                var da = dat[j];
                var la = da.label;
                html += '<tr class="'+la+'">';
                html += '<td>'+da.title+'</td>';
                html += '<td>'+da.matchType+'</td>';
                html += '<td>'+da.homeTeam+'</td>';
                var homePic = da.homePic;
                if (homePic != null) {
                    html += '<td><img src="http:'+homePic+'"></td>';
                } else {
                    html += '<td></td>';
                }
                var guestTeam = da.guestTeam;
                if (guestTeam != null) {
                    html += '<td>-</td>';
                } else {
                    html += '<td></td>';
                }
                var guestPic = da.guestPic;
                if (guestPic != null) {
                    html += '<td><img src="http:'+guestPic+'"></td>';
                } else {
                    html += '<td></td>';
                }
                if (guestTeam != null) {
                    html += '<td>'+guestTeam+'</td>';
                } else {
                    html += '<td></td>';
                }
                var lines = da.lines;
                if (lines != null && lines.length > 0){
                    html += '<td>';
                    for (var x in lines) {
                        var k = lines[x];
                        html += '<a href="/spt/tv/'+k.id+'.html" target="_blank" style="padding-left: 20px;cursor:pointer;">'+k.lineName+'</a>';
                    }
                    html += '</td>';
                } else {
                    html += '<td></td>';
                }
                html += '</tr>';
            }
            html += '</tbody></table></div></li>';
        }
    $('#matchId').html(html);

}

$("#selMtId button").click(function(e){
    var id = $(this).attr('id');
    $('tbody tr').hide();
    switch(id) {
        case '1':
            $('tbody tr').show();
            break;
        case '2':
            getElementsByClassName("篮球","tr",true);
            getElementsByClassName("足球","tr",true);
            break;
        case '3':
            getElementsByClassName("篮球","tr",true);
            break;
        case '4':
            getElementsByClassName("足球","tr",true);
            break;
        case '5':
            getElementsByClassName("其他","tr",true);
            break;
        default:
            console.error();
    }
});
