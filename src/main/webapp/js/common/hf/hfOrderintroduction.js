$(document).ready(function () {
    $('#hfintroductionType').slider({
        showTip: true,
        mode: 'h',
        max: 2,
        min: 0,
        step: 1,
        tipFormatter: function (value) {
            if (value == '1') {
                return "公司员工转介绍";
            } else if (value == '2') {
                return "用户转介绍";
            } else {
                return value;
            }
        }
    });

    $(".slider-inner").css({"top": "15", "left": "5"});
});
