$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#hflistenTable').datagrid({
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
        toolbar:'#hflistenTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#hflistenTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#hflistenTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");

        setTimeout(function(){
            var currWidth = 0;
            $("[for='lisname']").each(function(index,element){
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

     $('#hflistenTable').datagrid({
        url:'listener/getListen.do',
        queryParams: {
            'studentId':'',
            'studentName': '',
            'studentPhone':'',
            'docName':'',
            'orgName':'',
            'ctime_from':'',
            'ctime_to':'',
            'hforderisme':'n'
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
    $("#ZyEDEqyYF50ppc8bE3F30V8sXzg0hylj").click(function(){

        var options = $('#hflistenTable').datagrid('options');
        options.url='listener/getListen.do';

        var hforderisme;
        if($("#hflistenhforderisme").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        $('#hflistenTable').datagrid('load',{
            'studentId': $("#hflistenstudentId").val(),
            'studentName': $("#hflistenstudentName").val(),
            'studentPhone': $("#hflistenstudentPhone").val(),
            'docName': $("#hflistendocName").val(),
            'orgName': $("#hflistenorgName").val(),
            'ctime_from':$('#hflistenOrderctime_from').datebox('getValue'),
            'ctime_to':$('#hflistenOrderctime_to').datebox('getValue'),
            'listentime_from':$('#hflistenctime_from').datebox('getValue'),
            'listentime_to':$('#hflistenctime_to').datebox('getValue'),
            'hforderisme':hforderisme
        });

    })
    //********************查询end************************************************

    //********************修改begin************************************************
    $("#Ga6cspiuBovzfabHgk17x8gAQdA0ZnEm").click(function(){

        //重新生成div元素，方便生成dilog画面
        if($("#hfLisUpdatedialog").length == 0){
            $("#hfLisUpdatediv").html("<div id='hfLisUpdatedialog' name='hfLisUpdatedialog'></div>");
        }

        showupdatedialog();
    });
    //********************修改end************************************************


    //********************导入表格begin************************************************
    $("#NVw1Q5r0d0YVNAwmTTlOAz3cnvPDW6Wk").click(function(){

        var hforderisme;
        if($("#hflistenhforderisme").prop("checked")){
            hforderisme = 'y'
        } else{
            hforderisme = 'n'
        }

        var url = $("#basePath").val();
        url = url + "listener/export.do?" +
            "studentId=" + $("#hflistenstudentId").val() + "&"+
            "studentName=" + $("#hflistenstudentName").val() + "&"+
            "studentPhone=" + $("#hflistenstudentPhone").val() + "&"+
            "docName=" + $("#hflistendocName").val() + "&"+
            "orgName=" + $("#hflistenorgName").val() + "&"+
            "ctime_from=" + $('#hflistenOrderctime_from').datebox('getValue') + "&"+
            "ctime_to=" + $('#hflistenOrderctime_to').datebox('getValue') + "&"+
            "listentime_from=" + $('#hflistenctime_from').datebox('getValue') + "&"+
            "listentime_to=" + $('#hflistenctime_to').datebox('getValue') + "&"+
            "hforderisme=" + hforderisme + "&" +
            "v="+ Math.random();
        location.href =url;

    })
    //********************导入表格end************************************************

    function showupdatedialog(){

        var row= $('#hflistenTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        var id = row!=null?row.id:'';
        var area = row!=null?row.area:'';
        var nj = row!=null?row.nj:'';
        var listenSubject = row!=null?row.listenSubject:'';

        var listenTime;
        if(row.listenTime != null && row.listenTime !=''){
            listenTime = new Date(row.listenTime.time).Format("yyyy-MM-dd hh:mm:ss")
        } else{
            listenTime= '';
        }
        var teacher = row!=null?row.teacher:'';
        var teacherPhone = row!=null?row.teacherPhone:'';
        var teacherInfo = row!=null?row.teacherInfo:'';

        var href = encodeURI(encodeURI('listener/update.do?'
            +"id=" + id + "&"
            +"area=" + area + "&"
            +"nj=" + nj + "&"
            +"listenSubject=" + listenSubject + "&"
            +"listenTime=" + listenTime + "&"
            +"teacher=" + teacher + "&"
            +"teacherPhone=" + teacherPhone + "&"
            +"teacherInfo=" + teacherInfo
        ));

        //显示dilog
        $('#hfLisUpdatedialog').dialog({
            title: "试听",
            width: 600,
            height: 385,
            closed: false,
            cache: false,
            href:href,
            iconCls: 'icon-save',
            //content: '123',
            toolbar: [{
                text:'取消',
                iconCls:'icon-remove',
                handler:function(){
                    $("#hfLisUpdatedialog").panel('refresh');
                }
            },'-',{
                text:'保存',
                iconCls:'icon-save',
                handler:function(){

                    $.messager.confirm('确认',"确认修改吗",function(r){
                        if (r){
                            updateListen();
                        }else{
                            $.messager.alert('取消修改','您已经取消修改!','warning');
                        }
                    });

                }
            }],
            buttons: [{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#hfLisUpdatedialog').dialog('close')
                }
            }],
            modal: true,
            onClose:function(){
                $('#hfLisUpdatedialog').dialog('destroy', true)
            }
        });
    }

    function updateListen(){
        if(checkupdateListen()){
            $.ajax({
                type:'post',
                url:'listener/updateListen.do',
                data:decodeURIComponent($("#hforderListenFrom").serialize(),true),
                cache:false,
                success:function(data,textStatus,XMLHttpRequest){
                    if(data=='updateSuccess'){
                        $.messager.alert('修改成功','客户试听修改成功!','info',function(){
                            $('#hfLisUpdatedialog').dialog('close');
                            $("#ZyEDEqyYF50ppc8bE3F30V8sXzg0hylj").click();
                        });
                    } else{
                        $.messager.alert('修改失败','修改错误!','error')
                    }

                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $.messager.alert('修改失败','修改错误!','error')
                }
            });
        }

    }
    function checkupdateListen(){
        //试听课程
        var hflistenSubject = $("#hflistenSubject").combobox("getValue");

        if(hflistenSubject == null || hflistenSubject ==''){
            $.messager.alert('提示消息','试听课程不能为空!','warning');
            return false;
        }

        //试听时间
        var hflistenTime = $("#hflistenTime").datebox('getValue');
        if(hflistenTime == null || hflistenTime ==''){
            $.messager.alert('提示消息','试听时间不能为空!','warning');
            return false;
        }

        //判断教师姓名是否正确
        var hfteacherName = $("#hfteacherName").val();
        if(hfteacherName =="" || hfteacherName ==null){
            $.messager.alert('提示消息','教师姓名不能为空!','warning');
            return false;
        }

        //判断教师电话是否正确
        var hfteacherPhone = $("#hfteacherPhone").val();
        var reg=/^[0-9]{11}$/;
        if(!reg.test(hfteacherPhone)){
            $.messager.alert('提示消息','教师电话号格式不正确!','warning');
            return false;
        }
        return true;
    }

    //********************取消试听begin************************************************
    $("#WHMPjQxwPWlSoprWaotzszPkjScqLult").click(function(){
        var row=$('#hflistenTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        $.messager.confirm('确认',"确认取消吗",function(r){
            if (r){

                $.ajax({
                    type:'post',
                    url:'listener/del.do',
                    data:{'id':row.orderId},
                    cache:false,
                    success:function(data,textStatus,XMLHttpRequest){

                        if(data == "delsuccess"){
                            $.messager.alert('删除成功','订单试听删除成功!','info',function(){
                                $("#ZyEDEqyYF50ppc8bE3F30V8sXzg0hylj").click();
                            });
                        }else{
                            if(data=='delerror'){
                                $.messager.alert('删除失败','删除失败请联系管理员!','warning');
                            };
                        }
                    },
                    error:function(XMLHttpRequest, textStatus, errorThrown){
                        $.messager.alert('取消失败','取消错误!','error')
                    }
                });

            }else{
                $.messager.alert('取消','您已经取消!','warning');
            }
        });


    });
    //********************取消试听end************************************************


    //********************跳票begin************************************************
    $("#WyG30SMv3p8FnnC6RHoHQkAh45EZXAnS").click(function(){
        var row=$('#hflistenTable').datagrid('getSelected');
        if(row==null){
            $.messager.alert('提示消息','请选择!','warning');
            return false;
        }

        $.messager.confirm('确认',"确认跳票吗",function(r){
            if (r){

                $.ajax({
                    type:'post',
                    url:'listener/bounced.do',
                    data:{'id':row.id},
                    cache:false,
                    success:function(data,textStatus,XMLHttpRequest){
                         if(data == "bouncedsuccess"){
                            $.messager.alert('删除成功','跳票成功!','info',function(){
                                $("#ZyEDEqyYF50ppc8bE3F30V8sXzg0hylj").click();
                            });
                        }else{
                            if(data=='bouncederror'){
                                $.messager.alert('删除失败','跳票失败请联系管理员!','warning');
                            };
                        }
                    },
                    error:function(XMLHttpRequest, textStatus, errorThrown){
                         $.messager.alert('取消失败','跳票错误-没有权限!','error')
                    }
                });

            }else{
                $.messager.alert('取消','您已经取消!','warning');
            }
        });


    });
    //********************跳票试听end************************************************


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
    $("#hflistenOrderctime_from").datebox({
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
    $("#hflistenOrderctime_to").datebox({
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
    $("#hflistenctime_from").datebox({
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
    $("#hflistenctime_to").datebox({
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