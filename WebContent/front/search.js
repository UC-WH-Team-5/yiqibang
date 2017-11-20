/**
 * Created by Administrator on 2017/10/20.
 */
$(function () {
    $(".list .left button").mouseover(function () {

        $(this).css({"background":"#398fe6","display":"block"});
    });
    $(".list .left button").mouseout(function () {
        $(".list .left button").css("background","white");
    });
})

