$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#hflistenJumpTable').datagrid({
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
                {field:'area',title:'地区',align:'center',width:100},
                {field:'nj',title:'年级',align:'center',width:100,
                    formatter: function(value,row,index){
                          if(value != null && value !='' && value != 'undefind'){
                              if(value == 0){
                                  return "小学一年级";
                              } else if(value ==1){
                                  return "小学二年级";
                              }else if(value ==2){
                                  return "小学三年级";
                              }else if(value ==3){
                                  return "小学四年级";
                              }else if(value ==4){
                                  return "小学五年级";
                              }else if(value ==5){
                                  return "小学六年级";
                              }else if(value ==6){
                                  return "初中一年级";
                              }else if(value ==7){
                                  return "初中二年级";
                              }else if(value ==8){
                                  return "初中三年级";
                              }else if(value ==9){
                                  return "高中一年级";
                              }else if(value ==10){
                                  return "高中二年级";
                              }else if(value ==11){
                                  return "高中三年级";
                              }
                          }else{
                              return "";
                          }

                    }},
                {field:'listenSubject',title:'试听科目',align:'center',width:100,
                    formatter: function(value,row,index){
                            if(value != null && value !='' && value != 'undefind'){
                                if(value == 0){
                                    return '语文'
                                } else if(value ==1){
                                    return '数学'
                                }else if(value ==2){
                                    return '外语'
                                }else if(value ==3){
                                    return '物理'
                                }else if(value ==4){
                                    return '化学'
                                }else if(value ==5){
                                    return '生物'
                                }else if(value ==6){
                                    return '历史'
                                }else if(value ==7){
                                    return '地理'
                                }else if(value ==8){
                                    return '政治'
                                }else if(value ==9){
                                    return '其他'
                                }
                            } else{
                                return "";
                            }
                        }},
                {field:'listenTime',title:'试听时间',align:'center',width:150,
                    formatter: function(value,row,index){
                        if(value != null && value !=''){
                            return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                        } else{
                            return '';
                        }
                    }},
            {field:'teacher',title:'授课老师',align:'center',width:100},
            {field:'teacherPhone',title:'老师电话',align:'center',width:100},
            {field:'teacherInfo',title:'老师详情',align:'center',width:600,
                formatter: function(value,row,index){
                    return value.replace(/\r\n/g,'<br>')
                }},
            {field:'ifBounced',title:'跳票状态',align:'center',width:100,
                formatter: function(value,row,index){
                    return getStateComment(value);
                }},
            {field:'ifbouncedTime',title:'跳票时间',align:'center',width:150,
                formatter: function(value,row,index){
                    if(value != null && value !=''){
                        return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                    } else{

                        return '';
                    }
                }},
                {field:'cTime',title:'邀约时间',align:'center',width:150,
                    formatter: function(value,row,index){
                        if(value != null && value !=''){
                            return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")
                        } else{

                            return '';
                        }
                }},
                {field:'s6',title:'高考年份',align:'center',width:100,
                    formatter: function(value,row,index){

                        value = row.hfOrder.gaokaoYear;
                        if(value != null && value !=''){
                            return new Date(value.time).Format("yyyy-MM");
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
                    }},
                {field:'uTime',title:'更新时间',align:'center',width:150,
                    formatter: function(value,row,index){
                        if(value != null && value !=''){
                            return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss")

                        } else{
                            return '';
                        }
                    }}
        ]],
        toolbar:'#hflistenJumpTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#hflistenJumpTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#hflistenJumpTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");

        setTimeout(function(){
            var currWidth = 0;
            $("[for='lisJumpname']").each(function(index,element){
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

     $('#hflistenJumpTable').datagrid({
        url:'listener/getListenJump.do',
        queryParams: {
            'studentId':'',
            'studentName': '',
            'studentPhone':'',
            'docName':'',
            'orgName':'',
            'listentime_from':'',
            'listentime_to':'',
            'ctime_from':'',
            'ctime_to':'',
            'hforderisme':'n',
            'jump':0
        }
    });

	 //********************表格自适应end************************************************
	   
	   //$(window).height(); //浏览器当前窗口可视区域高度
	   //$(document).height(); //浏览器当前窗口文档的高度
	   //$(document.body).height();//浏览器当前窗口文档body的高度
	   //$(document.body).outerHeight(true);//浏览器当前窗口文档body的总高度 包括border padding margin
	   //$(window).width(); //浏览器当前窗口可视区域宽度
	   //$(document).width();//浏览器当前窗口文档对象宽度
	   //$(document.body).width();//浏览器当前窗口文档body的高度
	   //$(document.body).outerWidth(true);//浏览器当前窗口文档body的总宽度 包括border padding margin 
	   
    //*****************************主页面表格加载结束*****************************


    //********************查询begin************************************************
    $("#lwC4DgaeZTugCFVe0WKmLWQ5W3R0YcFw").click(function(){

        var options = $('#hflistenJumpTable').datagrid('options');
        options.url='listener/getListenJump.do';

        var hforderisme;
        if($("#hflistenhforderismeJump").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        $('#hflistenJumpTable').datagrid('load',{
            'studentId': $("#hflistenstudentIdJump").val(),
            'studentName': $("#hflistenstudentNameJump").val(),
            'studentPhone': $("#hflistenstudentPhoneJump").val(),
            'docName': $("#hflistendocNameJump").val(),
            'orgName': $("#hflistenorgNameJump").val(),
            'ctime_from':$('#hflistenOrderctime_fromJump').datebox('getValue'),
            'ctime_to':$('#hflistenOrderctime_toJump').datebox('getValue'),
            'listentime_from':$('#hflistenctime_fromJump').datebox('getValue'),
            'listentime_to':$('#hflistenctime_toJump').datebox('getValue'),
            'hforderisme':hforderisme,
            'jump':0
        });

    })
    //********************查询end************************************************


    //********************取消跳票begin************************************************
    $("#uLZ61Y8KIDfixruZIWcmMab4cmPGx5MP").click(function(){
        var row=$('#hflistenJumpTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        $.messager.confirm('确认',"确认取消跳票吗",function(r){
            if (r){

                $.ajax({
                    type:'post',
                    url:'listener/unbounced.do',
                    data:{'id':row.id},
                    cache:false,
                    success:function(data,textStatus,XMLHttpRequest){
                        if(data == "unbouncedsuccess"){
                            $.messager.alert('取消成功','取消跳票成功!','info',function(){
                                $("#lwC4DgaeZTugCFVe0WKmLWQ5W3R0YcFw").click();
                            });
                        }else{
                            if(data=='bouncederror'){
                                $.messager.alert('取消失败','取消跳票失败请联系管理员!','warning');
                            };
                        }
                    },
                    error:function(XMLHttpRequest, textStatus, errorThrown){
                        $.messager.alert('取消失败','取消跳票错误-没有权限!','error')
                    }
                });

            }else{
                $.messager.alert('取消','您已经取消!','warning');
            }
        });


    });
    //********************取消跳票试听end************************************************

    //********************导入表格begin************************************************
    $("#3pKQU5KavHA0r4STD3MScFPentPwyvyL").click(function(){

        var hforderisme;
        if($("#hflistenhforderismeJump").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        var url = $("#basePath").val();
        url = url + "listener/exportJump.do?" +
            "studentId=" + $("#hflistenstudentIdJump").val() + "&"+
            "studentName=" + $("#hflistenstudentNameJump").val() + "&"+
            "studentPhone=" + $("#hflistenstudentPhoneJump").val() + "&"+
            "docName=" + $("#hflistendocNameJump").val() + "&"+
            "orgName=" + $("#hflistenorgNameJump").val() + "&"+
            "ctime_from=" + $('#hflistenOrderctime_fromJump').datebox('getValue') + "&"+
            "ctime_to=" + $('#hflistenOrderctime_toJump').datebox('getValue') + "&"+
            "listentime_from=" + $('#hflistenctime_fromJump').datebox('getValue') + "&"+
            "listentime_to=" + $('#hflistenctime_toJump').datebox('getValue') + "&"+
            "hforderisme=" + hforderisme + "&" +
            'jump=0' + "&" +
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
    $("#hflistenOrderctime_fromJump").datebox({
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
    $("#hflistenOrderctime_toJump").datebox({
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
    $("#hflistenctime_fromJump").datebox({
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
    $("#hflistenctime_toJump").datebox({
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