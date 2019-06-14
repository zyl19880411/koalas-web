$(document).ready(function() {

//*****************************意向课程下拉框begin*****************************///
    $('#hflovesubject').combobox({
        valueField : 'value',
        textField : 'text',
        editable : false,
        data:[{
            value: '0',
            text: '语文'
        },{
            value: '1',
            text: '数学'
        },{
            value: '2',
            text: '外语'
        },{
            value: '3',
            text: '物理'
        },{
            value: '4',
            text: '化学'
        },{
            value: '5',
            text: '生物'
        },{
            value: '6',
            text: '历史'
        },{
            value: '7',
            text: '地理'
        },{
            value: '8',
            text: '政治'
        },{
            value: '9',
            text: '其他'
        }]
    });

    //*****************************意向课程下拉框end*****************************///

    var currTime=new Date();
    var strDate=currTime.getFullYear()+"-"+(currTime.getMonth()+1)+"-01";
    $('#hfgaokaoYear').datebox({formatter:function(date){
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            m = m < 10 ? '0' + m : m;
            return y.toString() + '-' + m.toString();
        },parser:function(date){
            if (date) {
                return new Date(String(date).substring(0, 4) + '-'
                    + String(date).substring(5,7));
            } else {
                return new Date();
            }
        }});

    if(orderAddOrSave=='save'){
        //意向课程
        $('#hflovesubject').combobox("setValue",loveSubject);
        //高考年份
        //$('#hfgaokaoYear').datebox("setValue",gaokaoYear);
        setTimeout(function(){
            $('#hfgaokaoYear').datebox("setValue",gaokaoYear);
        }, 100)
        //说明
        $("#hftype_Remark").val(backup);
    }

    Date.prototype.Format = function(fmt)
    { //author: meizz
        var o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "h+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }

});
