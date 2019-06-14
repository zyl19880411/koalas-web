$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#taskTable').datagrid({
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
        pageSize:20,
        pageList:[10,20,30,40,50,100],
        method:'post',
        columns:[[
                {field:'check',align:'center',checkbox:true,width:15},  
          		{field:'task_id',title:'任务编号',align:'center',width:100,hidden:true},
          		{field:'task_name',title:'任务名称',align:'center',width:100},
          		{field:'task_url',title:'任务路径',align:'center',width:100},
          		{field:'task_expression',title:'任务执行时间表达式',align:'center',width:100,editor: "text"},
          		{field:'task_state',title:'任务执行状态',align:'center',width:100}
              ]],
        toolbar:'#taskTableTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() + "login/userLogin.do";
	    }
    });

  //********************表格自适应start************************************************
    var header =$("#taskTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });

	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   
		   $('#taskTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   
	   $('#taskTable').datagrid({
		   url:'TaskController/getTasks.do',
	   });
	   
	 //********************表格自适应end************************************************
    //*****************************主页面表格加载结束*****************************

	   
	 //*****************************主页面表格查询begin*****************************
	   $("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click(function(){
		   $('#taskTable').datagrid("load");
	   })
	 //*****************************主页面表格查询begin*****************************

	   //*****************************主页面表格暂停begin*****************************
	   $("#Mt5A1KRKTgty31DtJ3ik8boG5tFbJvHQ").click(function(){
		   var row = $('#taskTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   $.messager.confirm('确认暂停', '确认暂停这个任务吗?', function(r){
				 
				 if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'TaskController/pause.do?',
		 		        data:{"task_id":row.task_id},
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('暂停成功','暂停成功!','info',function(){
		 		        			$("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click();
		 		        		});
                             }
		 		         },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('暂停失败','任务暂停失败!','error');
		 		        }
		 		    });
		    	}

			 });
		   
	   })
	 //*****************************主页面表格暂停end*****************************
	   
	   //*****************************主页面表格恢复begin*****************************
	   $("#XMHiJy4XnXj0o6NpYcAE5iFDwfC0DyFz").click(function(){
		   var row = $('#taskTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		   $.messager.confirm('确认恢复', '确认恢复这个任务吗?', function(r){
				 
				 if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'TaskController/resume.do?',
		 		        data:{"task_id":row.task_id},
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('恢复成功','恢复成功!','info',function(){
		 		        			$("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click();
		 		        		});
                           }
		 		         },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('恢复失败','恢复暂停失败!','error');
		 		        }
		 		    });
		    	}

			 });
	   })
	 //*****************************主页面表格恢复end*****************************
	   
	  //*****************************主页面表格删除begin*****************************
	   $("#UjEm2w4sYVx1XVNxQ0DCbmf1ANbjB5fe").click(function(){
		   var row = $('#taskTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		   $.messager.confirm('确认删除', '确认删除这个任务吗?', function(r){
				 
				 if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'TaskController/del.do?',
		 		        data:{"task_id":row.task_id},
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('删除成功','删除成功!','info',function(){
		 		        			$("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click();
		 		        		});
                           }
		 		         },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('删除失败','删除失败!','error');
		 		        }
		 		    });
		    	}

			 });
	   })
	 //*****************************主页面表格删除end***************************** 
	 
	 //*****************************主页面表格立即执行一次begin*****************************
	   $("#NzXxLGTjO8xGBWYLw0ywlMZneSr0oLOP").click(function(){
		   var row = $('#taskTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		   $.messager.confirm('确认执行', '确认执行这个任务吗?', function(r){
				 
				 if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'TaskController/startOne.do?',
		 		        data:{"task_id":row.task_id},
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('执行成功','执行成功!','info',function(){
		 		        			$("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click();
		 		        		});
                           }
		 		         },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('执行失败','执行失败!','error');
		 		        }
		 		    });
		    	}

			 });
	   })
	 //*****************************主页面表格立即执行一次end***************************** 

	 //*****************************主页面表格修改begin*****************************
	   $("#hB760SmtOVsb6VMTMP5GS1aSgIgBW1Vb").click(function(){
		   var row = $('#taskTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   //重新生成div元素，方便生成dilog画面
		    if($("#taskUpddialog").length == 0){
			    $("#taskUpddiv").html("<div id='taskUpddialog' name='taskUpddialog'></div>");
		    }
		    
		    $('#taskUpddialog').dialog({
			    title: "修改任务",
			    width: 300,
			    height: 150,
			    closed: false,
			    cache: false,
			    //href:"TaskController/addReturn.do",
			    iconCls: 'icon-save',
			    content: "修改任务表达式:<input type='text' id = 'taskUpd' value ='"+row.task_expression+"'/>",
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$("#taskUpd").val(row.task_expression);
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
					   updateTask(row.task_id,$("#taskUpd").val());
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#taskUpddialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#taskUpddialog').dialog('destroy', true)
			    } 
			});

	   });
	   
	   function updateTask(task_id,cronExpression){
		   $.messager.confirm('确认添加', '确认添加这个任务吗?', function(r){
				 
				 if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'TaskController/upd.do?',
		 		        data:{"task_id":task_id,
		 		        	  "cronExpression":cronExpression},
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('修改成功','修改成功!','info',function(){
		 		        			$('#taskUpddialog').dialog('close');
		 		        			$("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click();
		 		        		});
                            } else if(data=='error'){
                            	 $.messager.alert('表达式不正确','表达式不正确!','error')
                            }
		 		          else{
		 		        	 $.messager.alert('表达式不正确','表达式不正确!','error')
		 		           }
		 		         },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('修改失败','任务修改失败!','error');
		 		        }
		 		    });
		    	}

			 });
		   
	   }

	 //*****************************主页面表格修改end*****************************

	   
	   
	//*****************************主页面表格添加begin*****************************
	 $("#JzDypWYwaXUBL2A0HZpTqjl2sOkqd6lX").click(function(){
		   
		//重新生成div元素，方便生成dilog画面
	    if($("#taskAdddialog").length == 0){
		    $("#taskAdddiv").html("<div id='taskAdddialog' name='taskAdddialog'></div>");
	    }
	    
	  //显示dilog
		   $('#taskAdddialog').dialog({
			    title: "添加任务",
			    width: 600,
			    height: 400,
			    closed: false,
			    cache: false,
			    href:"TaskController/addReturn.do",
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$("#taskADDFrom")[0].reset();
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						taskSave();
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#taskAdddialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#taskAdddialog').dialog('destroy', true)
			    } 
			});
	 });
	//*****************************主页面表格添加end*****************************

	//*****************************添加保存begin*****************************
	 function taskSave(){
		 if(checkTaskAddInfo()){
			 $.messager.confirm('确认添加', '确认添加这个任务吗?', function(r){
				 
				 if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'TaskController/add.do?'+$("#taskADDFrom").serialize(),
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('添加成功','添加成功!','info',function(){
		 		        			$('#taskAdddialog').dialog('close');
		 		        			$("#37pyRui4B2WAP6E2mzDdFG2MnjYGYD1Z").click();
		 		        		});
                            } else if(data =='notexists'){
                            	$.messager.alert('添加失败','当前类不存在!','error');
                            } else if(data =='typeError'){
	 		        			$.messager.alert('添加失败','类型错误!','error');
	 		        		} else if(data =='Jobexists'){
	 		        			$.messager.alert('添加失败','任务已经存在!','error');
	 		        		} else if(data =='Triggerexists'){
	 		        			$.messager.alert('添加失败','定时器已经存在!','error');
	 		        		} else{
		 		        		location.href = $("#basePath").val() +"login/userLogin.do";
		 		        	}
		 		        },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('添加失败','任务添加失败!','error');
		 		        }
		 		    });
		    	}

			 });
		 }
	 }
	//*****************************添加保存end*****************************
	 
	//*****************************添加保存验证begin*****************************
	 function checkTaskAddInfo(){
		 var isTrue =true;
		 
		//判断任务名称
		 var taskName = $("#taskName").val();
		 reg= /^[\u4e00-\u9fa50-9\.A-Za-z]{2,30}$/;
		 if(!reg.test(taskName)){
			   $("#errorLabeltaskName").css("display","inline");
			   $("#errorLabeltaskName").html("*请输入任务名称");
			   isTrue=false;
		  } else{
			   $("#errorLabeltaskName").css("display","none");
			   $("#errorLabeltaskName").html("");
		  }
		 
		 //判断任务路径
		 var taskUrl = $("#taskUrl").val();
		 reg= /^[0-9\.A-Za-z]{2,50}$/;
		  if(!reg.test(taskUrl)){
			   $("#errorLabeltaskUrl").css("display","inline");
			   $("#errorLabeltaskUrl").html("*请输入任务路径");
			   isTrue=false;
		  } else {
			   $("#errorLabeltaskUrl").css("display","none");
			   $("#errorLabeltaskUrl").html("");
		  }
		  
		//判断表达式
		 var taskExpression = $("#taskExpression").val();
		
		 if(!cronValidate(taskExpression)){
			  $("#errorLabeltaskExpression").css("display","inline");
			  $("#errorLabeltaskExpression").html("*请输入正确的表达式");
			  isTrue=false;
		  } else {
			  $("#errorLabeltaskExpression").css("display","none");
			  $("#errorLabeltaskExpression").html("");
		  }

		 return isTrue;
	 }
	//*****************************添加保存验证end*****************************
})

    function cronValidate(cronExpression ){   
        //alert("校验函数的开始！");   
        var cronParams = cronExpression.split(" ");   
  
        if (cronParams.length < 6 || cronParams.length > 7) {   
            return false;   
        }   
  
        //CronTrigger cronTrigger = new CronTrigger();   
        //cronTrigger.setCronExpression( cronExpression );   
  
        if (cronParams[3] == "?" || cronParams[5]=="?") {   
            //Check seconds param   
            if (!checkSecondsField(cronParams[0])) {   
                return false;   
            }   
  
            //Check minutes param   
            if (!checkMinutesField(cronParams[1])) {   
                return false;   
            }   
  
            //Check hours param   
            if (!checkHoursField(cronParams[2])) {   
                return false;   
            }   
  
            //Check day-of-month param   
            if (!checkDayOfMonthField(cronParams[3])) {   
                return false;   
            }   
  
            //Check months param   
            if (!checkMonthsField(cronParams[4])) {   
                return false;   
            }   
  
            //Check day-of-week param   
            if (!checkDayOfWeekField(cronParams[5])) {   
                return false;   
            }   
  
            //Check year param   
            if (cronParams.length == 7) {   
                if (!checkYearField(cronParams[6])) {   
                    return false;   
                }   
            }   
  
            return true;   
        } else {   
            return false;   
        }   
    }   
  
    function checkSecondsField(secondsField) {   
        return checkField(secondsField, 0, 59);   
    }   

    function checkField(secondsField, minimal, maximal) {   
        if (secondsField.indexOf("-") > -1 ) {   
            var startValue = secondsField.substring(0, secondsField.indexOf( "-" ));   
            var endValue = secondsField.substring(secondsField.indexOf( "-" ) + 1);   
  
            if (!(checkIntValue(startValue, minimal, maximal, true) && checkIntValue(endValue, minimal, maximal, true))) {   
                return false;   
            }   
            try {   
                var startVal = parseInt(startValue, 10);   
                var endVal = parseInt(endValue, 10);   
  
                return endVal > startVal;   
            } catch (e) {   
                return false;   
            }   
        } else if (secondsField.indexOf(",") > -1) {   
            return checkListField(secondsField, minimal, maximal);   
        } else if (secondsField.indexOf( "/" ) > -1) {   
            return checkIncrementField( secondsField, minimal, maximal );   
        } else if (secondsField.indexOf( "*" ) != -1) {   
            return true;   
        } else {   
            return checkIntValue(secondsField, minimal, maximal);   
        }   
    }   
  
    function checkIntValue(value, minimal, maximal, checkExtremity) {   
        try {   
            var val = parseInt(value, 10);   
            //判断是否为整数   
            if (value == val) {   
                if (checkExtremity) {   
                    if (val < minimal || val > maximal) {   
                        return false;   
                    }   
                }   
  
                return true;   
            }   
  
            return false;   
        } catch (e) {   
            return false;   
        }   
    }   
  
    function checkMinutesField(minutesField) {   
        return checkField(minutesField, 0, 59);   
    }   
  
    function checkHoursField(hoursField) {   
        return checkField(hoursField, 0, 23);   
    }   
  
    function checkDayOfMonthField(dayOfMonthField) {   
        if (dayOfMonthField == "?") {   
            return true;   
        }   
  
        if (dayOfMonthField.indexOf("L") >= 0) {   
            return checkFieldWithLetter(dayOfMonthField, "L", 1, 7, -1, -1);   
        } else if ( dayOfMonthField.indexOf("W") >= 0) {   
            return checkFieldWithLetter(dayOfMonthField, "W", 1, 31, -1, -1);   
        } else if (dayOfMonthField.indexOf("C") >= 0) {   
            return checkFieldWithLetter(dayOfMonthField, "C", 1, 31, -1, -1);   
        } else {   
            return checkField( dayOfMonthField, 1, 31 );   
        }   
    }   
  
    function checkMonthsField(monthsField) {   
/*        monthsField = StringUtils.replace( monthsField, "JAN", "1" );  
        monthsField = StringUtils.replace( monthsField, "FEB", "2" );  
        monthsField = StringUtils.replace( monthsField, "MAR", "3" );  
        monthsField = StringUtils.replace( monthsField, "APR", "4" );  
        monthsField = StringUtils.replace( monthsField, "MAY", "5" );  
        monthsField = StringUtils.replace( monthsField, "JUN", "6" );  
        monthsField = StringUtils.replace( monthsField, "JUL", "7" );  
        monthsField = StringUtils.replace( monthsField, "AUG", "8" );  
        monthsField = StringUtils.replace( monthsField, "SEP", "9" );  
        monthsField = StringUtils.replace( monthsField, "OCT", "10" );  
        monthsField = StringUtils.replace( monthsField, "NOV", "11" );  
        monthsField = StringUtils.replace( monthsField, "DEC", "12" );*/  
  
        monthsField.replace("JAN", "1");   
        monthsField.replace("FEB", "2");   
        monthsField.replace("MAR", "3");   
        monthsField.replace("APR", "4");   
        monthsField.replace("MAY", "5");   
        monthsField.replace("JUN", "6");   
        monthsField.replace("JUL", "7");   
        monthsField.replace("AUG", "8");   
        monthsField.replace("SEP", "9");   
        monthsField.replace("OCT", "10");   
        monthsField.replace("NOV", "11");   
        monthsField.replace("DEC", "12");   
  
        return checkField(monthsField, 1, 31);   
    }   
  
    function checkDayOfWeekField(dayOfWeekField) {   
/*        dayOfWeekField = StringUtils.replace( dayOfWeekField, "SUN", "1" );  
        dayOfWeekField = StringUtils.replace( dayOfWeekField, "MON", "2" );  
        dayOfWeekField = StringUtils.replace( dayOfWeekField, "TUE", "3" );  
        dayOfWeekField = StringUtils.replace( dayOfWeekField, "WED", "4" );  
        dayOfWeekField = StringUtils.replace( dayOfWeekField, "THU", "5" );  
        dayOfWeekField = StringUtils.replace( dayOfWeekField, "FRI", "6" );  
        dayOfWeekField = StringUtils.replace( dayOfWeekField, "SAT", "7" );*/  
  
        dayOfWeekField.replace("SUN", "1" );   
        dayOfWeekField.replace("MON", "2" );   
        dayOfWeekField.replace("TUE", "3" );   
        dayOfWeekField.replace("WED", "4" );   
        dayOfWeekField.replace("THU", "5" );   
        dayOfWeekField.replace("FRI", "6" );   
        dayOfWeekField.replace("SAT", "7" );           
  
        if (dayOfWeekField == "?") {   
            return true;   
        }   
  
        if (dayOfWeekField.indexOf("L") >= 0) {   
            return checkFieldWithLetter(dayOfWeekField, "L", 1, 7, -1, -1);   
        } else if (dayOfWeekField.indexOf("C") >= 0) {   
            return checkFieldWithLetter(dayOfWeekField, "C", 1, 7, -1, -1);   
        } else if (dayOfWeekField.indexOf("#") >= 0) {   
            return checkFieldWithLetter(dayOfWeekField, "#", 1, 7, 1, 5);   
        } else {   
            return checkField(dayOfWeekField, 1, 7);   
        }   
    }   
  
    function checkYearField(yearField) {   
        return checkField(yearField, 1970, 2099);   
    }   
  
    function checkFieldWithLetter(value, letter, minimalBefore, maximalBefore,   
                                          minimalAfter, maximalAfter) {   
        var canBeAlone = false;   
        var canHaveIntBefore = false;   
        var canHaveIntAfter = false;   
        var mustHaveIntBefore = false;   
        var mustHaveIntAfter = false;   
  
        if (letter == "L") {   
            canBeAlone = true;   
            canHaveIntBefore = true;   
            canHaveIntAfter = false;   
            mustHaveIntBefore = false;   
            mustHaveIntAfter = false;   
        }   
        if (letter == "W" || letter == "C") {   
            canBeAlone = false;   
            canHaveIntBefore = true;   
            canHaveIntAfter = false;   
            mustHaveIntBefore = true;   
            mustHaveIntAfter = false;   
        }   
        if (letter == "#") {   
            canBeAlone = false;   
            canHaveIntBefore = true;   
            canHaveIntAfter = true;   
            mustHaveIntBefore = true;   
            mustHaveIntAfter = true;   
        }   
  
        var beforeLetter = "";   
        var afterLetter = "";   
  
        if (value.indexOf(letter) >= 0 ) {   
            beforeLetter = value.substring( 0, value.indexOf(letter));   
        }   
  
        if (!value.endsWith(letter)) {   
            afterLetter = value.substring( value.indexOf( letter ) + 1 );   
        }   
  
        if (value.indexOf(letter) >= 0) {   
            if (letter == value) {   
                return canBeAlone;   
            }   
  
            if (canHaveIntBefore) {   
                if (mustHaveIntBefore && beforeLetter.length == 0) {   
                    return false;   
                }   
  
                if (!checkIntValue(beforeLetter, minimalBefore, maximalBefore, true)){   
                    return false;   
                }   
            } else {   
                if (beforeLetter.length > 0 ) {   
                    return false;   
                }   
            }   
  
            if (canHaveIntAfter) {   
                if ( mustHaveIntAfter && afterLetter.length == 0 ) {   
                    return false;   
                }   
  
                if (!checkIntValue(afterLetter, minimalAfter, maximalAfter, true)) {   
                    return false;   
                }   
            } else {   
                if (afterLetter.length > 0) {   
                    return false;   
                }   
            }   
        }   
  
        return true;   
    }   
  
/*    function checkIntValue(value, minimal, maximal) {  
        return checkIntValue(value, minimal, maximal, true);  
    } */  
  
    function checkIncrementField(value, minimal, maximal) {   
        var start = value.substring(0, value.indexOf("/"));   
  
        var increment = value.substring(value.indexOf("/") + 1);   
  
        if (!("*" == start)) {   
            return checkIntValue(start, minimal, maximal, true) && checkIntValue(increment, minimal, maximal, false);   
        } else {   
            return checkIntValue(increment, minimal, maximal, true);   
        }   
    }   
  
    function checkListField(value, minimal, maximal ) {   
        var st = value.split(",");   
  
        var values = new Array(st.length);   
  
        for(var j = 0; j < st.length; j++) {   
            values[j] = st[j];   
        }   
  
        var previousValue = -1;   
  
        for (var i= 0; i < values.length; i++) {   
            var currentValue = values[i];   
  
            if (!checkIntValue(currentValue, minimal, maximal, true)) {   
                return false;   
            }   
  
            try {   
                var val = parseInt(currentValue, 10);   
  
                if (val <= previousValue) {   
                    return false;   
                } else {   
                    previousValue = val;   
                }   
            } catch (e) {   
                // we have always an int   
            }   
        }   
  
        return true;   
    }  