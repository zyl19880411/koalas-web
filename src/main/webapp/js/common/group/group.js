$(document).ready(function() {
	//*****************************主页面表格加载开始*****************************
    $('#groupTable').datagrid({
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
        columns:[[
                {field:'check',align:'center',checkbox:true,width:15},  
          		{field:'group_id',title:'团队ID',align:'center',width:100,hidden:true},
          		{field:'group_name',title:'团队名称',align:'center',width:100},
          		{field:'create_time',title:'创建时间',align:'center',width:100},
          		{field:'remark',title:'团队说明',align:'center',width:100},
          		{field:'org_id',title:'机构id',align:'center',width:100,hidden:true},
          		{field:'org_name',title:'所属机构',align:'center',width:100},
              ]],
        toolbar:'#groupTableTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#groupTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#groupTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   $('#groupTable').datagrid({
		   url:'GroupController/getGroups.do'
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
	 $("#oR1caw6H7nsApTD8THuqz0xAGX0IhMvG").click(function(){
		   var options = $('#groupTable').datagrid('options');
		   options.url='GroupController/getGroups.do';
		   $('#groupTable').datagrid('load');
	 })  
	//********************查询end************************************************
	 
	 //********************添加begin************************************************
	 $("#sXxSfrw0INe83QUH8H0nB7jpVhhXp0ZL").click(function(){
		 
		//重新生成div元素，方便生成dilog画面
	    if($("#groupdialog").length == 0){
		    $("#groupdiv").html("<div id='groupdialog' name='groupdialog'></div>");
	    }
	    showdialog("add");
	 })  
	//********************添加end************************************************
	 
	  //********************修改begin************************************************
	 $("#BW5tnNmuzsEW8kd7zqKHb1TFgOBD3vvu").click(function(){
		 
		//重新生成div元素，方便生成dilog画面
	    if($("#groupdialog").length == 0){
		    $("#groupdiv").html("<div id='groupdialog' name='groupdialog'></div>");
	    }
	    showdialog("save");
	 })  
	//********************修改end************************************************
	 
	 //*****************************主页面角色删除start*****************************///
     $("#BBwm4jY8hZGzhsrEgzW2oUVNCUIquyT7").click(function(){
    	 var row = $('#groupTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		    $.messager.confirm('确认删除', '确认删除这个团队吗?', function(r){
		    	if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'GroupController/del.do',    
		 		        data:{"group_id":row.group_id},    
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('删除确认','删除成功!','info',function(){
		 		        			$("#oR1caw6H7nsApTD8THuqz0xAGX0IhMvG").click();
		 		        		});
		 		        		 
		 		        	}else{
		 		        		location.href = $("#basePath").val() +"login/userLogin.do";
		 		        	}
		 		        },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('删除失败','团队删除错误!','error')
		 		        }
		 		    });
		    	}
		    });
    })
    //*****************************主页面角色删除end*****************************///
    
	 //*****************************添加修改弹出dialog start*****************************///
	 function showdialog(addOrSave){
		 
		 var title='团队添加';
         var row;
		   if('save'==addOrSave){
			   title = "团队修改",
			   row = $('#groupTable').datagrid('getSelected');
			   if(row==null){
				   $.messager.alert('提示消息','请选择!','warning');
				   return false;
			   }
		   }
		   
	     var group_id = row!=null?row.group_id:'';
	     var group_name = row!=null?row.group_name:'';
	     var remark = row!=null?row.remark:'';
	     var org_id = row!=null?row.org_id:''; 
	     var org_name = row!=null?row.org_name:'';

	     var href = encodeURI(encodeURI('GroupController/'+addOrSave + 
				   ".do?group_id=" + group_id+  
				   "&group_name=" + group_name+  
				   "&remark=" + remark+ 
				   "&org_id=" + org_id +
				   "&org_name=" + org_name
		   ));
	     
	   //显示dilog
		   $('#groupdialog').dialog({
			    title: title,
			    width: 700,
			    height: 400,
			    closed: false,
			    cache: false,
			    href:href,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$("#groupADDFrom")[0].reset();
						$("#permissiongroupOrg").combobox("setValue",'');
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						save(addOrSave);
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#groupdialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#groupdialog').dialog('destroy', true)
			    } 
			});
	 }

	 //*****************************添加修改弹出dialog end*****************************///
     
	//*****************************添加 begin*****************************///      
		function save(addOrsave){
			if(checkGroupInfo()){
				
				$.ajax({    
			        type:'post',        
			        url:'GroupController/addOrsave.do',    
			        data:decodeURIComponent($("#groupADDFrom").serialize() + '&addOrSave=' + addOrsave,true),    
			        cache:false,    
			        success:function(data,textStatus,XMLHttpRequest){
			        	if(data=='addSuccess'){
			        		$.messager.alert('添加成功',' 团队添加成功!','info',function(){
				        		$('#groupdialog').dialog('close');
				        		$("#oR1caw6H7nsApTD8THuqz0xAGX0IhMvG").click();
				        	});
			        	};
			        	if(data=='updateSuccess'){
			        		$.messager.alert('修改成功','团队修改成功!','info',function(){
				        		$('#groupdialog').dialog('close');
				        		$("#oR1caw6H7nsApTD8THuqz0xAGX0IhMvG").click();
				        	});
			        	};
			        	
			        },
			        error:function(XMLHttpRequest, textStatus, errorThrown){
			        	$.messager.alert('添加失败','团队添加错误!','error')
			        }
			    });
				
			}
		}
		   
		//*****************************添加修改弹出dialog end*****************************/// 
		
	
	 //*****************************添加修改check begin*****************************///
	  function checkGroupInfo(){
		 var isTrue =true;
		 
		 //判断组织机构是否选择
        
	   if($("#permissiongroupOrg").length>=1){
		   var org = $("#permissiongroupOrg").combobox("getValue");

		   if(org=='' || org==null){
			   $("#errorLabelgroupOrg").css("display","inline");
			   $("#errorLabelgroupOrg").html("*请选择组织机构");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelgroupOrg").css("display","none");
			   $("#errorLabelgroupOrg").html("");
		   }
	   }
		   
		 //判断团队名称
		 var groupName = $("#permissiongroupName").val();
		 reg= /^[\u4e00-\u9fa50-9]{2,30}$/;
		 if(!reg.test(groupName)){
			   $("#errorLabelgroupName").css("display","inline");
			   $("#errorLabelgroupName").html("*请输入团队名称");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelgroupName").css("display","none");
			   $("#errorLabelgroupName").html("");
		   }
		 
		//判断团队说明
		 var groupRemak = $("#permissiongroupremark").val();
		 reg= /^[\u4e00-\u9fa50-9]{2,30}$/;
		 if(!reg.test(groupRemak)){
			   $("#errorLabelgroupremark").css("display","inline");
			   $("#errorLabelgroupremark").html("*请输入团队说明");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelgroupremark").css("display","none");
			   $("#errorLabelgroupremark").html("");
		   }
		 return isTrue;
	  }
   //*****************************添加修改check end*****************************/// 
 
})