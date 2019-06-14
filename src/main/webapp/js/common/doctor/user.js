$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#userTable').datagrid({
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
          		{field:'doc_id',title:'医生编号',align:'center',width:100,hidden:true},
          		{field:'login_name',title:'医生登录名',align:'center',width:100,hidden:true},
          		{field:'doc_name',title:'医生名称',align:'center',width:100},
          		{field:'gender',title:'性别',align:'center',width:40,
        			formatter: function(value,row,index){
        				if (value=='1'){
        					return '男';
        				} else {
        					return '女';
        				}
        			}	
          		},
          		{field:'cardid',title:'身份证号',align:'center',width:100},
          		{field:'birth_date',title:'生日',align:'center',width:100},
          		{field:'req_time',title:'注册时间',align:'center',width:100},
          		{field:'qq',title:'qq',align:'center',width:100},
          		{field:'tel',title:'座机号',align:'center',width:100},
          		{field:'phone',title:'手机号',align:'center',width:100},
          		{field:'org_name',title:'所属机构',align:'center',width:100}
              ]],
        toolbar:'#userTableTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() + "login/userLogin.do";
	    }
    });

  //********************表格自适应start************************************************
    var header =$("#userTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });

	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   
		   $('#userTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   
	   $('#userTable').datagrid({
		   url:'UserController/getUsers.do',
		   queryParams: {
			   'userName':'',
	    	   'tel': ''
			}
	   });
	   
	 //********************表格自适应end************************************************
  //*****************************主页面表格加载结束*****************************
    
   //*****************************主页面表格查询*****************************///
	   $("#D001").click(function(){
		   var options = $('#userTable').datagrid('options');
		   options.url='UserController/getUsers.do';
		    $('#userTable').datagrid('load',{
		    	'userName': $("#userName").val(),
	    		'tel': $("#tel").val()
		    });
	   })
  //*****************************主页面表格查询结束*****************************///
	   
  //*****************************主页面表格添加用户begin*****************************///
	   $("#D002").click(function(){
		   //重新生成div元素，方便生成dilog画面
		   if($("#userdialog").length == 0){
			   $("#userdiv").html("<div id='userdialog' name='userdialog'></div>");
		   }
		   showDialog('userAdd');
	   })
   //*****************************主页面表格添加用户end*****************************///	   

	   	   
   //*****************************主页面表格修改用户start*****************************///   
	   $("#D003").click(function(){
		 //重新生成div元素，方便生成dilog画面
		   if($("#userdialog").length == 0){
			   $("#userdiv").html("<div id='userdialog' name='userdialog'></div>");
		   }
		   showDialog('userUpd');
	   });
   //*****************************主页面表格修改用户end*****************************/// 
	   
	//*****************************主页面表格删除用户start*****************************///   
	   $("#D004").click(function(){
		   
		   var row = $('#userTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		    $.messager.confirm('确认删除', '确认删除这个医生吗?', function(r){
		    	if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'UserController/delUser.do',    
		 		        data:{"doc_id":row.doc_id},    
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('删除确认','删除成功!','info');
		 		        		$("#D001").click();
		 		        	}
		 		        	else{
		 		        		location.href = $("#basePath").val() +"login/userLogin.do";
		 		        	}
		 		        },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('删除失败','医生删除错误!','error')
		 		        }
		 		    });
		    	}
		    });
	   });
   //*****************************主页面表格删除用户end*****************************/// 	 
	   
   //*****************************主页面表格用户角色start*****************************/// 	   
	   $("#D005").click(function(){
		   if($("#userdialog").length == 0){
			   $("#userdiv").html("<div id='userdialog' name='userdialog'></div>");
		   }
		   
		   var row = $('#userTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   var doc_id = row!=null?row.doc_id:'';
		   //显示dilog
		   $('#userdialog').dialog({
			    title: "用户角色",
			    width: 700,
			    height: 600,
			    closed: false,
			    cache: false,
			    href:"UserController/userRole.do"  + '?doc_id=' + doc_id,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
					 userRolesDel();
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						userRolesSave();
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#userdialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#userdialog').dialog('destroy', true)
			    } 
			});
		   
	   });
   //*****************************主页面表格用户角色end*****************************/// 	
	   $("#D006").click(function(){
		   if($("#userdialog").length == 0){
			   $("#userdiv").html("<div id='userdialog' name='userdialog'></div>");
		   }
		   
		   var row = $('#userTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   var doc_id = row!=null?row.doc_id:'';
		   
		   //显示dilog
		   $('#userdialog').dialog({
			    title: "用户团队",
			    width: 700,
			    height: 600,
			    closed: false,
			    cache: false,
			    href:"UserController/userGroup.do"  + '?doc_id=' + doc_id,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						userGroupsDel();
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						saveUserGroups();
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#userdialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#userdialog').dialog('destroy', true)
			    } 
			});
		   
		   
	   });
	
 //*****************************用户团队取消begin*****************************///	
   function userGroupsDel(){
	   $('#user_Groups_table').datagrid('reload'); 
   }
	   
   //*****************************用户团队取消end*****************************///	
   
   //*****************************主页面表格用户团队start*****************************/// 
   function saveUserGroups(){

	   var rows = $('#user_Groups_table').datagrid('getChecked'); 
	   var all =  $('#user_Groups_table').datagrid('getRows');
	   var paramMap = {};
	   paramMap.rows=rows;
	   paramMap.all = all;
	   
	   $.ajax({    
	       type:'post',        
	       url:'UserController/saveUserGroups.do',    
	       data:JSON.stringify(paramMap),   
	       cache:false,
	       dataType : 'text',
	       contentType: 'application/json',
	       success:function(data,textStatus,XMLHttpRequest){
	    	   if(data=='saveUserGroupsSuccess'){
	        		$.messager.alert('添加确认','添加用户团队成功!','info');
	        		$('#userdialog').dialog('close')
	        	}
	       },
	       error:function(XMLHttpRequest, textStatus, errorThrown){
	         	$.messager.alert('添加失败','添加用户团队失败','error')
	       }
	   }); 
   }
   //*****************************主页面表格用户团队end*****************************/// 

   //*****************************用户角色取消begin*****************************///	
   function userRolesDel(){
	   $('#user_roles_table').datagrid('reload'); 
   }
	   
   //*****************************用户角色取消end*****************************///	
   
   //*****************************用户角色保存begin*****************************///	
   function userRolesSave(){
	   var rows =  $('#user_roles_table').datagrid('getChecked'); 
	   var all =  $('#user_roles_table').datagrid('getRows');
	   var paramMap = {};
	   paramMap.rows=rows;
	   paramMap.all = all;
	   $.ajax({    
	        type:'post',        
	        url:'UserController/saveUserRoles.do',    
	        data:JSON.stringify(paramMap),    
	        cache:false,
	        dataType : 'text',
	        contentType: 'application/json',
	        success:function(data,textStatus,XMLHttpRequest){
	        	if(data=='saveUserRolesSuccess'){
	        		$.messager.alert('添加确认','添加用户角色成功!','info');
	        		$('#userdialog').dialog('close')
	        	}
	        },
	        error:function(XMLHttpRequest, textStatus, errorThrown){
	        	$.messager.alert('添加失败','角色添加错误!','error')
	        }
	    });
	   
   }
	   
   //*****************************用户角色保存end*****************************///

   //*****************************添加或者修改用户begin*****************************///	

	   function showDialog(addOrSave){
		   var row=null;
		   var title='用户添加';
		   if('userUpd'==addOrSave){
			   title = "用户修改",
			   row = $('#userTable').datagrid('getSelected');
			   if(row==null){
				   $.messager.alert('提示消息','请选择!','warning');
				   return false;
			   }
		   }
		   var doc_id = row!=null?row.doc_id:'';
		   var login_name = row!=null?row.login_name:'';
		   var doc_name = row!=null?row.doc_name:'';
		   var gender = row!=null?row.gender:'';
		   var cardid = row!=null?row.cardid:'';
		   var birth_date = row!=null?row.birth_date:'';
		   var qq = row!=null?row.qq:'';
		   var org_name = row!=null?row.org_name:'';
		   var tel = row!=null?row.tel:'';
		   var phone = row!=null?row.phone:'';

		   var href = encodeURI(encodeURI('UserController/'+addOrSave 
				    + '.do?doc_id=' + doc_id
				    + '&login_name=' + login_name
				    + "&doc_name=" + doc_name 
				    + "&gender=" + gender 
				    + "&cardid=" + cardid 
				    + "&birth_date=" + birth_date 
				    + "&qq=" + qq 
				    + "&org_name=" + org_name 
				    + "&tel=" + tel 
				    + "&phone=" + phone));
		   
		   //显示dilog
		   $('#userdialog').dialog({
			    title: title,
			    width: 700,
			    height: 600,
			    closed: false,
			    cache: false,
			    href:href,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$("#UserADDFrom")[0].reset();
							$("#permissionUserOrg").combobox("setValue",'');
							$("#permissionQQ").numberbox("setValue",'');
							$("#permissionTel").numberbox("setValue",'');
							$("#permissionGender").combobox("setValue",'');
							$("#permissionPhone").numberbox("setValue",'');
							$("#permissionBrithday").datebox("setValue","");
							$("#permissionUserName").val("");
							$("#permissionCardid").val("");
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
						 $('#userdialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#userdialog').dialog('destroy', true)
			    } 
			});
	   }

	   function save(addOrSave){
		   if(checkUserInfo()){

			   $.ajax({    
			        type:'post',        
			        url:'UserController/addORSaveUser.do',    
			        data:decodeURIComponent($("#UserADDFrom").serialize() + '&addOrSave=' + addOrSave,true),    
			        cache:false,    
			        success:function(data,textStatus,XMLHttpRequest){
			        	if(data=='addContains'){
			        		$.messager.alert('添加确认','登录名重复，请换个试试!','info');
			        	};
			        	if(data=='addSuccess'){
			        		$.messager.alert('添加成功','医生添加成功!','info',function(){
				        		$('#userdialog').dialog('close');
				        		$("#D001").click();
				        	});
			        	};
			        	if(data=='updateSuccess'){
			        		$.messager.alert('修改成功','医生修改成功!','info',function(){
				        		$('#userdialog').dialog('close');
				        		$("#D001").click();
				        	});
			        	};
			        	
			        },
			        error:function(XMLHttpRequest, textStatus, errorThrown){
			        	$.messager.alert('添加失败','医生添加错误!','error')
			        }
			    });
		   }
	   }
	   
	   
	   function checkUserInfo(){
		   
		   var isTrue = true;
		   //判断组织机构是否选择
           
		   if($("#permissionUserOrg").length>=1){
			   var org = $("#permissionUserOrg").combobox("getValue");

			   if(org=='' || org==null){
				   $("#errorLabelOrg").css("display","inline");
				   $("#errorLabelOrg").html("*请选择组织机构");
				   isTrue=false;
			   }
			   else{
				   $("#errorLabelOrg").css("display","none");
				   $("#errorLabelOrg").html("");
			   }
		   }
		   
		   //判断用户姓名
		   var user = $("#permissionUserName").val();
		   var reg= /^[\u4e00-\u9fa5·]{2,}$/;
		   if(!reg.test(user)){
			   $("#errorLabelUserName").css("display","inline");
			   $("#errorLabelUserName").html("*请输入正确的姓名");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelUserName").css("display","none");
			   $("#errorLabelUserName").html("");
		   }

		   //判断登录名是否正确
		   var userName = $("#permissionLoginName").val();
		   reg=/^[a-zA-Z0-9]{5,10}$/;
		   if(!reg.test(userName)){
			   $("#errorLabelLoginName").css("display","inline");
			   $("#errorLabelLoginName").html("*请输入5-10位数字或者字母");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelLoginName").css("display","none");
			   $("#errorLabelLoginName").html("");
		   }
 
		   //判断密码
		   var pwd = $("#permissionPassword").val();
		   reg=/[0-9]+/;
		   var regA=/[a-zA-Z]+/;
		   var regB=/^.{5,10}$/;
		   if(!reg.test(pwd) || !regA.test(pwd) || !regB.test(pwd)){
			   $("#errorLabelpwd").css("display","inline");
			   $("#errorLabelpwd").html("*请输入5-10位数字字母组合");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelpwd").css("display","none");
			   $("#errorLabelpwd").html("");
		   }
		   
		   //验证密码
		   var checkpwd = $("#permissionCheckPassword").val();
		   if(pwd!=checkpwd){
			   $("#errorCheckpwd").css("display","inline");
			   $("#errorCheckpwd").html("*两次输入的密码不匹配");
			   isTrue=false;
		   }
		   else{
			   $("#errorCheckpwd").css("display","none");
			   $("#errorCheckpwd").html("");
		   }

		   //判断性别是否选择
		   var gender = $("#permissionGender").combobox("getValue");

		   if(gender=='' || gender==null){
			   $("#errorLabelGender").css("display","inline");
			   $("#errorLabelGender").html("*请选择性别");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelGender").css("display","none");
			   $("#errorLabelGender").html("");
		   }
		   
		   //生日验证
		   var permissionBrithday = $("#permissionBrithday").datebox("getValue");
		   reg=/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
		   if(!reg.test(permissionBrithday)){
			   $("#errorLabelBrithday").css("display","inline");
			   $("#errorLabelBrithday").html("*请输入正确的日期格式");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelBrithday").css("display","none");
			   $("#errorLabelBrithday").html("");
		   }

		   //身份证号验证
		   var cardId= $("#permissionCardid").val();
		   reg=/^(\d{18,18}|\d{15,15}|\d{17,17}x)$/;
		   if(!reg.test(cardId)){
			   $("#errorLabelCardid").css("display","inline");
			   $("#errorLabelCardid").html("*身份证格式错误");
			   isTrue=false;
		   }
		   else{
			   $("#errorLabelCardid").css("display","none");
			   $("#errorLabelCardid").html("");
		   }
		   
		   //QQ验证
		   var permissionQQ = $("#permissionQQ").numberbox("getValue");
		   reg=/^[0-9]{5,}$/;

		   if(permissionQQ != '' && permissionQQ != null){
			   if(!reg.test(permissionQQ)){
				   $("#errorLabelQQ").css("display","inline");
				   $("#errorLabelQQ").html("*QQ格式错误");
				   isTrue=false; 
			   }
			   else{
				   $("#errorLabelQQ").css("display","none");
				   $("#errorLabelQQ").html(""); 
			   }
		   }
		   else{
			   $("#errorLabelQQ").css("display","none");
			   $("#errorLabelQQ").html(""); 
		   }
		   
		  //座机验证
		   var permissionTel = $("#permissionTel").numberbox("getValue");
		   reg=/^[0-9]{7,10}$/;
		   if(permissionTel != '' && permissionTel != null){
			   if(!reg.test(permissionTel)){
				   $("#errorLabelTel").css("display","inline");
				   $("#errorLabelTel").html("*座机格式错误");
				   isTrue=false; 
			   }
			   else{
				   $("#errorLabelTel").css("display","none");
				   $("#errorLabelTel").html(""); 
			   }
		   }else{
			   $("#errorLabelTel").css("display","none");
			   $("#errorLabelTel").html(""); 
		   }
		   
		   //手机验证
		   var permissionTel = $("#permissionPhone").numberbox("getValue");
		   reg=/^[0-9]{11}$/;
		   if(!reg.test(permissionTel)){
			   $("#errorLabelPhone").css("display","inline");
			   $("#errorLabelPhone").html("*手机格式错误");
			   isTrue=false; 
		   }
		   else{
			   $("#errorLabelPhone").css("display","none");
			   $("#errorLabelPhone").html(""); 
		   }
		   
		   return isTrue;
	   }

   //*****************************添加或者修改end*****************************///	       
	   
})