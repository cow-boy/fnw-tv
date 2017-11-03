//初始化
//var first = eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('"\\8\\0\\0\\c\\b\\2\\2\\a\\d\\6\\4\\0\\5\\g\\6\\3\\3\\4\\1\\3\\5\\2\\1\\1\\0\\7\\9\\2\\1\\1\\0\\7\\9\\e\\4\\8\\0\\5\\f";',17,17,'x74|x63|x2f|x6f|x2e|x6d|x61|x76|x68|x35|x6e|x3a|x70|x62|x2b|x6c|x69'.split('|'),0,{}))
//$("#jiekouId").attr("src", first);

//切换视频源
var i = -1;
$("#searchVideo").click(function(){
    var bfUrl = $("#searchtext").val();
    if (bfUrl == "") {
        layer.msg('请您输入VIP视频的地址!',{icon: 2});
        return;
    }
    if(bfUrl.indexOf("://") <= 0 ){
        layer.msg('您输入VIP视频格式错误!',{icon: 2});
        return;
    }
    i++;
    if (i > 4) {
        i = 0;
    }
    if (i < 4) {
        layer.msg('如果播放失败了，重新点击播放按钮',{icon: 5});
    }
    if (i == 4) {
        layer.msg('全部播放失败了，重新更换播放地址',{icon: 5});
    }
    var url = vipData[i] + bfUrl;
    $("#jiekouId").attr('src', url);
});

//切换CCTV
var parentCc;
function subgo(obj) {
    var thisObj=$(obj);
    var cc = thisObj.attr("name");
    $("#jiekouId").attr('src', 'cctv.html');
    parentCc = cctvData.data[cc];
}

