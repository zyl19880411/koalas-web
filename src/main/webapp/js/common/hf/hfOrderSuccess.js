$(document).ready(function() {
    $('#hfclassHour').slider({
        showTip:true,
        mode: 'h',
        max:500,
        min:0,
        step:5
    });

    $(".slider-inner").css({"top":"15","left":"5"});

});
