$(document).ready(function () {
    $('#hfErrorType').slider({
        showTip: true,
        mode: 'h',
        max: 3,
        min: 0,
        step: 1,
        tipFormatter: function (value) {
            if (value == '1') {
                return "空错号";
            } else if (value == '2') {
                return "未试听失单";
            }else if (value == '3') {
                return "试听后失单号";
            } else {
                return value;
            }
        }
    });

    $(".slider-inner").css({"top": "15", "left": "5"});
});
