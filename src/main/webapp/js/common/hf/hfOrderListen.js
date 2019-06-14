$(document).ready(function() {

//*****************************试听课程下拉框begin*****************************///
    $('#hflistenSubject').combobox({
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

    //*****************************试听课程下拉框end*****************************///

    //*****************************试听课程下拉框begin*****************************///
    $('#hflistennj').combobox({
        valueField : 'value',
        textField : 'text',
        editable : false,
        data:[{
            value: '0',
            text: '小学一年级'
        },{
            value: '1',
            text: '小学二年级'
        },{
            value: '2',
            text: '小学三年级'
        },{
            value: '3',
            text: '小学四年级'
        },{
            value: '4',
            text: '小学五年级'
        },{
            value: '5',
            text: '小学六年级'
        },{
            value: '6',
            text: '初中一年级'
        },{
            value: '7',
            text: '初中二年级'
        },{
            value: '8',
            text: '初中三年级'
        },{
            value: '9',
            text: '高中一年级'
        },{
            value: '10',
            text: '高中二年级'
        },{
            value: '11',
            text: '高中三年级'
        }]
    });

    //*****************************试听课程下拉框end*****************************///

    if(listener=='save'){
        //学生年级
        $('#hflistennj').combobox("setValue",nj);
        //试听课程
        $('#hflistenSubject').combobox("setValue",listenSubject);

        //试听时间
        setTimeout(function(){
            $('#hflistenTime').datetimebox("setValue",listenTime);
        }, 100)
        //授课老师详情
        $("#hfteacherInfo").val(teacherInfo);

    }
});
