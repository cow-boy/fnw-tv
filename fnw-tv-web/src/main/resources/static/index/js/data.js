//var vipdata=["https://api.47ks.com/webcloud/?v=","http://vip.crj100.com/index.php?url=","http://p2.api.47ks.com/webcloud/?v=","http://vip.jlsprh.com/index.php?url=","http://www.wmxz.wang/video.php?url="],cctvdata={cctv1:"http://202.107.188.232:5002/cctv1_hdcq-1.m3u8?token=radio366",cctv2:"http://202.107.188.232:5002/cctv2_hdcq-1.m3u8?token=radio366",cctv3:"http://202.107.188.232:5002/cctv3_hdcq-1.m3u8?token=radio366",cctv4y:"http://202.107.188.246:5002/cctv4_hdcq-1.m3u8?token=radio366",cctv4o:"http://202.107.188.246:5002/cctv4_hdcq-1.m3u8?token=radio366",cctv5:"http://111.13.42.8/PLTV/88888888/224/3221225937/index.m3u8",cctv5j:"http://111.13.42.8/PLTV/88888888/224/3221225938/index.m3u8",cctv6:"http://202.107.188.246:5002/cctv6_hdcq-1.m3u8?token=radio366",cctv7:"http://202.107.188.246:5002/cctv7_hdcq-1.m3u8?token=radio366",cctv8:"http://111.13.42.8/PLTV/88888888/224/3221225864/index.m3u8",cctv9:"http://111.13.42.8/PLTV/88888888/224/3221226045/index.m3u8",cctv10:"http://183.252.176.13//PLTV/88888888/224/3221225931/2.m3u8",cctv11:"http://202.107.188.232:5002/cctv11_hdcq-1.m3u8?token=radio366",cctv12:"http://183.252.176.48//PLTV/88888888/224/3221225932/2.m3u8",cctv13:"http://202.107.188.246:5002/cctvnews_hdcq-1.m3u8?token=radio366",cctv14:"http://183.252.176.22//PLTV/88888888/224/3221225933/2.m3u8",cctv15:"http://221.179.217.94/PLTV/88888888/224/3221226050/index.m3u8",hunanws:"http://111.13.42.8/PLTV/88888888/224/3221225885/index.m3u8",zhejiangws:"http://183.251.61.207/PLTV/88888888/224/3221225825/index.m3u8",bingjingws:"http://183.251.61.207/PLTV/88888888/224/3221225937/index.m3u8",fengfangws:"http://183.251.61.207/PLTV/88888888/224/3221225900/index.m3u8",xianggangws:"http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8",aomenws:"http://live.mastvnet.com/n1rtlHG/500/live.m3u8",gaoqingyy:"http://news.live.wscdns.com/live/lunbobjjt/playlist.m3u8",dongzuody:"http://news.live.wscdns.com/live/lunbohysj/playlist.m3u8",hkc:"http://61.18.0.107:8114/LIVES/Fsv_otype=1&FvSeid=&Fsv_filetype=1&Fsv_chan_hls_se_idx=17&Provider_id=&Pcontent_id=index.m3u8"};

var cctvData;
var vipData;

var fdata = {
    init:function () {
        fdata.getCctv();
        fdata.getVip();
    },
    getCctv:function () {
        $.ajax({
            type:"post",
            url:"/tv/liveCctv",
            async:true,
            dataType:"json",
            success:function(data){
                if (data != null || data != '') {
                    var di = new Dictionary();
                    for (var i in data) {
                        var d = data[i];
                        di.put(d.code, d.name);
                    }
                    cctvData = di;
                }
            },
            error:function(err){
                console.log(err);
            }
        });
    },
    getVip:function () {
        $.ajax({
            type:"post",
            url:"/tv/liveVip",
            async:true,
            dataType:"json",
            success:function(data){
                if (data != null || data != '') {
                    var di = new Array();
                    for (var i in data) {
                        di.push(data[i].vipUrl);
                    }
                    vipData = di;
                    begin();
                }
            },
            error:function(err){
                console.log(err);
            }
        });
    }
}

$(function(){
    fdata.init();
})

var begin = function () {
    var initUrl = 'http://www.iqiyi.com/v_19rre19on4.html';
    $("#jiekouId").attr('src', vipData[0]+initUrl);
}