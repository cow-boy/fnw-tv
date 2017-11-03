var pfhtml = "<div class=\'pfys\'><i class=\'fa fa-cog \' aria-hidden=\'true\'></i><a class=\'pfysA pfy1\' name=\'#222222\'></a><a class=\'pfysA pfy2\' name=\'#f4f4f4\'></a>";
$("#pfk").html(pfhtml);
$(document).ready(function () {
    if (typeof localStorage.bgColor == 'undefined') {
        $("body").css("background-color", "#f4f4f4")
    } else {
        $("body").css("background-color", localStorage.bgColor)
    }
});
$(".pfysA").click(function () {
    $("body").css("background-color", $(this).attr("name"));
    localStorage.bgColor = $(this).attr("name")
});