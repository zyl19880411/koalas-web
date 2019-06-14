$(document).ready(function() {


    //*****************************主页面表格加载开始*****************************
    $('#hfOrderSuccessDayTable').datagrid({
        fit:true,
        pagination:true,
        nowrap: false,
        striped:true,
        border:false,
        loadMsg:'查询中...................',
        rownumbers:true,
        collapsible:false,
        fitColumns:false,
        singleSelect:true,
        method:'post',
        frozenColumns:[[
            {field:'check',align:'center',checkbox:true,width:15},
            {field:'id',title:'id',align:'center',width:100,hidden:true},
            {field:'orderId',title:'order',align:'center',width:100,hidden:true},
            {field:'s0',title:'docId',align:'center',width:100,hidden:true,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.docId != null){
                            return row.hfOrder.docId;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }
            },
            {field:'s1',title:'学生姓名',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.studentName != null){
                            return row.hfOrder.studentName;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }
            },
            {field:'s2',title:'家长电话',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.studentPhone != null){
                            return row.hfOrder.studentPhone;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }
            },
        ]],
        columns:[[
            {field:'s3',title:'跟进人',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.docName != null){
                            return row.hfOrder.docName;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }},
            {field:'s4',title:'所属组别',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.orgName != null){
                            return row.hfOrder.orgName;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }},
            {field:'s5',title:'编号',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.studentId != null){
                            return row.hfOrder.studentId;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }},
            {field:'contractNumbe',title:'成单合同编号',align:'center',width:100},
            {field:'classHour',title:'课时',align:'center',width:100},
            {field:'orderMoney',title:'成单金额',align:'center',width:100},
            {field:'gift',title:'赠品',align:'center',width:100},
            {field:'payStatus',title:'支付方式',align:'center',width:100},
            {field:'cTime',title:'成单时间',align:'center',width:150,
                formatter: function(value,row,index){
                    if(value != null && value !=''){
                        return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                    } else{
                        return '';
                    }
                }},
            {field:'payTime',title:'支付时间',align:'center',width:150,
                formatter: function(value,row,index){
                    if(value != null && value !=''){
                        return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                    } else{
                        return '';
                    }
                }},
            {field:'closeVTime',title:'关单录音时间',align:'center',width:150,
                formatter: function(value,row,index){
                    if(value != null && value !=''){
                        return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                    } else{
                        return '';
                    }
                }},
            {field:'s7',title:'渠道',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.channel != null){
                            return row.hfOrder.channel;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }},
            {field:'s8',title:'是否已经成单',align:'center',width:100,
                formatter: function(value,row,index){
                    value = row.hfOrder.ifSuccess;
                    return getStateComment(value);
                }},
            {field:'s9',title:'是否是转介绍',align:'center',width:100,
                formatter: function(value,row,index){
                    value = row.hfOrder.ifIntroduction;
                    return getStateComment(value);
                }},
            {field:'s10',title:'转介绍类型',align:'center',width:100,
                formatter: function(value,row,index){
                    value = row.hfOrder.introductionType;
                    if(value == '1'){
                        return '公司员工转介绍';
                    } else if(value == '2'){
                        return '用户转介绍';
                    } else{
                        return '';
                    }
                }},
            {field:'s11',title:'转介绍人',align:'center',width:100,
                formatter: function(value,row,index){
                    if(row.hfOrder != null){
                        if(row.hfOrder.introductionId != null){
                            return row.hfOrder.introductionId;
                        } else{
                            return '';
                        }
                    } else{
                        return '';
                    }
                }}
        ]],
        toolbar:'#hfOrderSuccessDayTB',
        onLoadError:function(){
            location.href = $("#basePath").val() +"login/userLogin.do";
        }
    });

    //********************表格自适应start************************************************
    var header =$("#hfOrderSuccessDayTB").next("div").find("div .datagrid-header .datagrid-htable");

    var headerWidth=0;;
    $.each(header,function(index,value){
        headerWidth+=$(value).width();
    });

    if(headerWidth<=$(document).width()-$("#menuWidth").val()){
        $('#hfOrderSuccessDayTable').datagrid({
            fitColumns:true
        });
    }
    $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");

    setTimeout(function(){
        var currWidth = 0;
        $("[for='SuccessDayname']").each(function(index,element){
            currWidth += $(element).width();
            if(currWidth>= $(document).width()-$("#menuWidth").val()-300){
                if($(element).is("input")){
                    $("<br>").insertBefore($(element).prev());
                    currWidth = $(element).prev().width();
                }else{
                    $("<br>").insertBefore($(element));
                    currWidth = $(element).width();
                }
            }
        });
    },200)

    $('#hfOrderSuccessDayTable').datagrid({
        url:'success/getSuccessDay.do',
        queryParams: {
            'studentId':'',
            'studentName': '',
            'studentPhone':'',
            'docName':'',
            'orgName':'',
            'ctime_from':new Date().Format ("yyyy-MM-dd"),
            'ctime_to':new Date().Format ("yyyy-MM-dd"),
            'successPayTimeFrom':'',
            'successPayTimeto':'',
            'contractNumbe':'',
            'hforderisme':'n'
        }
    });

    //********************查询begin************************************************
    $("#rFEajOh6HnQoBBRV5rxJGJCOSSHpkknk").click(function(){

        var options = $('#hfOrderSuccessDayTable').datagrid('options');
        options.url='success/getSuccessDay.do';

        var hforderisme;
        if($("#hforderismeSuccessDay").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        $('#hfOrderSuccessDayTable').datagrid('load',{
                'studentId': $("#studentIdSuccessDay").val(),
                'studentName': $("#studentNameSuccessDay").val(),
                'studentPhone': $("#studentPhoneSuccessDay").val(),
                'docName': $("#docNameSuccessDay").val(),
                'orgName': $("#orgNameSuccessDay").val(),
                'ctime_from':new Date().Format ("yyyy-MM-dd"),
                'ctime_to':new Date().Format ("yyyy-MM-dd"),
                'successPayTimeFrom':$('#hfSuccessDayPaytime_from').datebox('getValue'),
                'successPayTimeto':$('#hfSuccessDayPaytime_to').datebox('getValue'),
                'contractNumbe': $("#contractNumbeSuccessDay").val(),
                'hforderisme':hforderisme
            }
        );

    })
    //********************查询end************************************************


    //********************导入表格begin************************************************
    $("#gKGSIkAJNt0v568ha8G6msCpZIh32OB2").click(function(){

        var hforderisme;
        if($("#hforderismeSuccessDay").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        var url = $("#basePath").val();
         url = url + "success/exportSuccessDay.do?" +
            "studentId=" + $("#studentIdSuccessDay").val() + "&"+
            "studentName=" + $("#studentNameSuccessDay").val() + "&"+
            "studentPhone=" + $("#studentPhoneSuccessDay").val() + "&"+
            "docName=" + $("#docNameSuccessDay").val() + "&"+
            "orgName=" + $("#orgNameSuccessDay").val() + "&"+
            "ctime_from=" + new Date().Format ("yyyy-MM-dd") + "&"+
            "ctime_to=" + new Date().Format ("yyyy-MM-dd") + "&"+
            "successPayTimeFrom=" + $('#hfSuccessDayPaytime_from').datebox('getValue') + "&"+
            "successPayTimeto=" + $('#hfSuccessDayPaytime_to').datebox('getValue') + "&"+
            "contractNumbe=" + $('#contractNumbeSuccessDay').val() + "&"+
            "hforderisme=" + hforderisme + "&" +
            "v="+ Math.random();
         location.href =url;

    })
    //********************导入表格end************************************************


    //********************将状态flag转换成说明 start******************************************
    function  getStateComment(flag){
        if(flag=='0'){
            return "<img title='否' style=\"height:30px;width:30px;\" src=\""+  $("#basePath").val() + "icons/common/hf/no.png\">";
        }
        else if(flag=='1'){
            return "<img title='是' style=\"height:30px;width:30px;\" src=\""+  $("#basePath").val() + "icons/common/hf/yes.png\">";
        }
    }
    //********************将状态flag转换成说明 end******************************************

    //*****************************生日格式begin*****************************///
    $("#hfSuccessDayPaytime_from").datebox({
        formatter : function(date) {
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
                + (d < 10 ? ('0' + d) : d);
        },
        parser:function(s){
            var t = Date.parse(s);
            if (!isNaN(t)){
                return new Date(t);
            } else {
                return new Date();
            }
        }
    });
    //*****************************生日格式end*****************************///
    //*****************************生日格式begin*****************************///
    $("#hfSuccessDayPaytime_to").datebox({
        formatter : function(date) {
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
                + (d < 10 ? ('0' + d) : d);
        },
        parser:function(s){
            var t = Date.parse(s);
            if (!isNaN(t)){
                return new Date(t);
            } else {
                return new Date();
            }
        }
    });
    //*****************************生日格式end*****************************///

})