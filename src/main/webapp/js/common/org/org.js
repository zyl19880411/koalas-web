$(document).ready(function() {
	
	//选中行
	var selectrowCheck =0;
	var oncheck =0;
	//*****************************主页面表格加载开始*****************************
    $('#orgTable').treegrid({
        fit:true,
        //pagination:true,
        //url:'RoleController/getRolePermission',
        nowrap: false,
        animate: true,
        striped:true,
        border:false,
        loadMsg:'查询中...................',
        rownumbers:true,
        fitColumns:false,
        collapsible:false,
        singleSelect:true,
        method:'post',
        idField: 'org_id',
        lines:true,
        treeField: 'org_name',
        toolbar:'#orgTableTB',
        columns:[[
                {field:'check',align:'center',checkbox:true,width:15},  
                {field:'org_id',title:'机构ID',align:'center',width:100,hidden:true},
                {field:'_parentId',title:'上级菜单',align:'center',width:100,hidden:true},
                {field:'org_name',title:'机构名称',halign:'center',align:'left',width:100},
                {field:'tel',title:'机构电话',align:'center',width:100},
                {field:'link_name',title:'机构联系人',align:'center',width:100},
                {field:'link_phone',title:'联系人电话',align:'center',width:100},
                {field:'address',title:'地址',align:'center',width:100},
                {field:'create_time',title:'创建时间',align:'center',width:100}
              ]],
              onLoadSuccess:function(row,data){
            	  $('#orgTable').treegrid("collapseAll");
              },
              onClickRow:function(row){
            	  if(selectrowCheck==null){
            		  $('#orgTable').treegrid("unselect",row.org_id);
            	  }
              },
              onCheck:function(row){
            	   
            	  if(row == selectrowCheck){
	            	   $('#orgTable').treegrid("unselect",row.org_id);
	            	   selectrowCheck=null;
	            	   oncheck = 1;
	               }
	               else{
	            	   selectrowCheck = row;
	               }
              },
      	    onLoadError:function(){
    	    	location.href = $("#basePath").val() +"login/userLogin.do";
    	    }
    });  
    
       //********************表格自适应start************************************************
       var header =$("#orgTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
    
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#orgTable').treegrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	 //********************表格自适应end************************************************
      
	   $('#orgTable').treegrid({
		   url:"OrgController/getOrg.do"
	   })
	   
     //********************机构查询start************************************************
	   $("#D016").click(function(){
		   var options = $('#orgTable').treegrid("options");  
			  options.url = "OrgController/getOrg.do";
			  $('#orgTable').treegrid("load");  
	   });
	 //********************机构查询end************************************************   
	  
	 //********************添加机构start************************************************
	   $("#D017").click(function(){
		 //重新生成div元素，方便生成dilog画面
	     if($("#orgdialog").length == 0){
		     $("#orgdiv").html("<div id='orgdialog' name='orgdialog'></div>");
	     }
	     showdialog("add");
	   });
	  //********************添加机构end************************************************
	   
	 //********************修改机构start************************************************
	   $("#D018").click(function(){
		 //重新生成div元素，方便生成dilog画面
	     if($("#orgdialog").length == 0){
		     $("#orgdiv").html("<div id='orgdialog' name='orgdialog'></div>");
	     }
	     showdialog("save");
	   });
	  //********************修改机构end************************************************
	   
	   //********************删除机构start************************************************ 
	   $("#D019").click(function(){
		   var delOrg = $('#orgTable').treegrid("getSelected");
		   if(delOrg==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return;
		   }
		   var _parentid =  delOrg._parentId;
		   if(_parentid=='' || _parentid ==null){
			   $.messager.alert('提示消息','只能删除子机构!','warning');
			   return;
		   }
		   
		   $.messager.confirm('确认删除', '确认删除这个机构吗?', function(r){
		    	if (r){
		    		$.ajax({    
				        type:'post',        
				        url:'OrgController/del.do',    
				        data:{"org_id":delOrg.org_id},    
				        cache:false,    
				        success:function(data,textStatus,XMLHttpRequest){
				        	if(data=='delSuccess'){
				        		$.messager.alert('删除成功','删除机构成功!','info',function(){
				        			 $('#orgTable').treegrid("load");
				        			 selectrowCheck =0;
				        		     oncheck =0;
				        			 $('#orgTable').treegrid("unselect",delOrg.org_id);
				        		}); 
				        	}else{
		 		        		location.href = $("#basePath").val() +"login/userLogin.do";
		 		        	}
				        },
				        error:function(XMLHttpRequest, textStatus, errorThrown){
				        	$.messager.alert('删除失败','删除机构错误!','error')
				        }
				    });
		    	}
		   });
		});
	   //********************删除机构end************************************************
	   
	   //********************机构权限start************************************************ 
         $("#D020").click(function(){
		   
		   var orgPermission = $('#orgTable').treegrid("getSelected");
		   if(orgPermission==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return;
		   }
		   var _parentid =  orgPermission._parentId;
		   if(_parentid=='' || _parentid ==null){
			   $.messager.alert('提示消息','只能对所属机构设置权限!','warning');
			   return;
		   }
		   
		   var org_id =  orgPermission.org_id;
		   
		 //重新生成div元素，方便生成dilog画面
	     if($("#orgdialog").length == 0){
		     $("#orgdiv").html("<div id='orgdialog' name='orgdialog'></div>");
	     }
	     
	     //显示dilog
		   $('#orgdialog').dialog({
			    title: "机构权限",
			    width: 900,
			    height: 600,
			    closed: false,
			    cache: false,
			    href:"OrgController/orgPerrmission.do?parentid="+_parentid +"&org_id=" + org_id,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$('#org_perrmission').treegrid("reload");
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						saveOrgPerrmission();
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#orgdialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#orgdialog').dialog('destroy', true)
			    } 
			});

	   });
	   
       function saveOrgPerrmission(){
    	 
    	   var rows = $('#org_perrmission').treegrid("getSelections");
    	   
           var permission_id = [];
		   
		   for(var i =0;i<rows.length;i++){
			   permission_id[i] = rows[i].permissionID;
		   }
    	   
		   $.ajax({    
		       type:'post',        
		       url:'OrgController/saveOrgPerrmission.do',    
		       data:JSON.stringify(permission_id),   
		       cache:false,
		       dataType : 'text',
		       contentType: 'application/json',
		       success:function(data,textStatus,XMLHttpRequest){
		    	   if(data == 'success'){
		    		   $.messager.alert('添加确认','机构权限保存成功!','info');
		        		$('#orgdialog').dialog('close')  
		    	   }
	        		
		       },
		       error:function(XMLHttpRequest, textStatus, errorThrown){
		         	$.messager.alert('添加失败','机构权限保存失败','error')
		       }
		   });
       }

	   //********************机构权限end************************************************ 

	  //*****************************添加修改弹出dialog start*****************************///
		  function showdialog(addOrSave){

			   var title='机构添加';
 
			   if('save'==addOrSave){
				   title = "机构修改"
			   }
			   var row = $('#orgTable').datagrid('getSelected');
			   if(row==null){
				   $.messager.alert('提示消息','请选择!','warning');
				   return false;
			   }
			   
			   var org_id = row!=null?row.org_id:'';
			   var org_name = row!=null?row.org_name:'';
			   var tel = row!=null?row.tel:'';
			   var link_name = row!=null?row.link_name:'';
			   var link_phone = row!=null?row.link_phone:'';
			   var address = row!=null?row.address:'';
			   var create_time = row!=null?row.create_time:'';
			   
			   var href = encodeURI(encodeURI('OrgController/'+addOrSave + 
					   ".do?org_id=" + org_id+  
					   "&org_name=" + org_name+  
					   "&tel=" + tel+  
					   "&link_name=" + link_name +
					   "&link_phone=" + link_phone +
					   "&address=" + address +
					   "&create_time=" + create_time));
			   
			   //显示dilog
			   $('#orgdialog').dialog({
				    title: title,
				    width: 700,
				    height: 280,
				    closed: false,
				    cache: false,
				    href:href,
				    iconCls: 'icon-save',
				    //content: '123',
				    toolbar: [{
						text:'取消',
						iconCls:'icon-remove',
						handler:function(){
							$("#OrgADDFrom")[0].reset();
							$("#permissionOrgTel").numberbox("setValue",'');
							$("#permissionOrgLinkPhone").numberbox("setValue",'');
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
							 $('#orgdialog').dialog('close')
						}
					}],
				    modal: true,
				    onClose:function(){
				    	$('#orgdialog').dialog('destroy', true)
				    } 
				});
			   
		  }
	     //*****************************添加修改弹出dialog end*****************************/// 
		  function save(addOrSave){
			  if(checkOrgInfo()){

				  $.ajax({    
				        type:'post',        
				        url:'OrgController/addorSave.do',    
				        data:decodeURIComponent($("#OrgADDFrom").serialize() + '&addOrSave=' + addOrSave,true),    
				        cache:false,    
				        success:function(data,textStatus,XMLHttpRequest){
				        	if(data=='addSuccess'){
				        		$.messager.alert('添加成功','添加机构成功!','info',function(){
				        			 $('#orgdialog').dialog('close');
				        			 $('#orgTable').treegrid("load");
				        		}) 
				        	}
				        	if(data =='updSuccess'){
				        		$.messager.alert('修改成功','修改机构成功!','info',function(){
				        			 $('#orgdialog').dialog('close');
				        			 $('#orgTable').treegrid("load");
				        		})
				        	}
				          
				        },
				        error:function(XMLHttpRequest, textStatus, errorThrown){
				        	$.messager.alert('添加失败','添加机构错误!','error')
				        }
				    });
			  }
		  }

		  function checkOrgInfo(){
 			   //机构名称验证
			   var orgName = $("#permissionOrgName").val();
			   var reg= /^[\u4e00-\u9fa5a-zA-Z0-9]{2,30}$/;
			   if(!reg.test(orgName)){
                   $.messager.alert('请输入正确的机构名','请输入正确的机构名!','info');
                   return false;
			   }
			  
			   //机构验证编码验证
			   var adminCode = $("#permissionadmincode").val();
			   reg=/^[a-zA-Z0-9]{5,10}$/;
			   if(!reg.test(adminCode)){
                   $.messager.alert('请输入正确5-10位验证编码','请输入正确5-10位验证编码!','info');
                   return false;
			   }

			 //密码验证
			   var pwd = $("#permissionOrgPassword").val();
			   reg=/[0-9]+/;
			   var regA=/[a-zA-Z]+/;
			   var regB=/^.{5,10}$/;
			   if(!reg.test(pwd) || !regA.test(pwd) || !regB.test(pwd)){
                   $.messager.alert('请输入5-10位数字字母密码组合','请输入5-10位数字字母密码组合!','info');
                   return false;
			   }

			 //座机验证
			   var permissionOrgTel = $("#permissionOrgTel").numberbox("getValue");
			   reg=/^[0-9]{7,10}$/;
			   if(!reg.test(permissionOrgTel)){
                   $.messager.alert('座机格式错误','座机格式错误!','info');
                   return false;
			   }

			   //判断联系人姓名验证
			   var permissionOrgLinkName = $("#permissionOrgLinkName").val();
			   var reg= /^[\u4e00-\u9fa5·]{2,}$/;
			   if(!reg.test(permissionOrgLinkName)){
                   $.messager.alert('请输入正确的联系人姓名','请输入正确的联系人!','info');
                   return false;
			   }
			   
			   //手机验证
			   var permissionOrgLinkPhone = $("#permissionOrgLinkPhone").numberbox("getValue");
			   reg=/^[0-9]{11}$/;
			   if(!reg.test(permissionOrgLinkPhone)){
                   $.messager.alert('手机格式错误','手机格式错误!','info');
                   return false;
			   }
			   
			   //机构地址验证
			   var permissionOrgAddress = $("#permissionOrgAddress").val();
			   var reg= /^[\u4e00-\u9fa50-9A-Za-z]{2,30}$/;
			   if(!reg.test(permissionOrgAddress)){
                   $.messager.alert('机构地址错误','机构地址错误!','info');
                   return false;
			   }

			  return true;
		  }	  
});
