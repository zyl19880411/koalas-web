$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#roleTable').datagrid({
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
          		{field:'role_id',title:'角色ID',align:'center',width:100,hidden:true},
          		{field:'role_name',title:'角色编号',align:'center',width:100},
          		{field:'remark',title:'角色名称',align:'center',width:100},
          		{field:'create_time',title:'注册时间',align:'center',width:100},
          		{field:'org_name',title:'所属机构',align:'center',width:100}
              ]],
        toolbar:'#roleTableTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#roleTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#roleTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   $('#roleTable').datagrid({
		   url:'RoleController/getRoles.do'
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
	   
    //*****************************主页面表格查询*****************************///
	   $("#D007").click(function(){

		   var options = $('#roleTable').datagrid('options');
		   options.url='RoleController/getRoles.do';
		   $('#roleTable').datagrid('load');
	   })
	   
    //*****************************主页面表格查询结束*****************************///
	   
	 //*****************************主页面角色添加start*****************************///
	   $("#D008").click(function(){
		   //重新生成div元素，方便生成dilog画面
		   if($("#roledialog").length == 0){
			   $("#rolediv").html("<div id='roledialog' name='roledialog'></div>");
		   }
		   showdialog("add");
	   })
    //*****************************主页面角色添加end*****************************///   

    //*****************************主页面角色修改start*****************************///
    $("#D009").click(function(){
	    //重新生成div元素，方便生成dilog画面
	    if($("#roledialog").length == 0){
		    $("#rolediv").html("<div id='roledialog' name='roledialog'></div>");
	    }
	    showdialog("save");
    })
    //*****************************主页面角色修改end*****************************/// 
	
    //*****************************主页面角色删除start*****************************///
     $("#D010").click(function(){
    	 var row = $('#roleTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		    $.messager.confirm('确认删除', '确认删除这个角色吗?', function(r){
		    	if (r){
		    		 $.ajax({    
		 		        type:'post',        
		 		        url:'RoleController/del.do',    
		 		        data:{"role_id":row.role_id},    
		 		        cache:false,    
		 		        success:function(data,textStatus,XMLHttpRequest){
		 		        	if(data=='success'){
		 		        		$.messager.alert('删除确认','删除成功!','info',function(){
		 		        			$("#D007").click();
		 		        		});
		 		        		 
		 		        	}else{
		 		        		location.href = $("#basePath").val() +"login/userLogin.do";
		 		        	}
		 		        },
		 		        error:function(XMLHttpRequest, textStatus, errorThrown){
		 		        	$.messager.alert('删除失败','角色删除错误!','error')
		 		        }
		 		    });
		    	}
		    });
    })
    //*****************************主页面角色删除end*****************************///
    
    //*****************************主页面角色权限start*****************************///
     $("#D011").click(function(){
    	 //重新生成div元素，方便生成dilog画面
	     if($("#roledialog").length == 0){
		   $("#rolediv").html("<div id='roledialog' name='roledialog'></div>");
	     }
		   
    	  var row = $('#roleTable').datagrid('getSelected');
		   if(row==null){
			   $.messager.alert('提示消息','请选择!','warning');
			   return false;
		   }
		   
		 //显示dilog
		   $('#roledialog').dialog({
			    title: "角色权限",
			    width: 1000,
			    height: 650,
			    closed: false,
			    cache: false,
			    href:'RoleController/rolePermission.do?role_id=' + row.role_id,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$('#rolePermission').treegrid("reload");
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						saveRolePermission();
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#roledialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#roledialog').dialog('destroy', true)
			    } 
			});
    })
    //*****************************主页面角色权限end*****************************///
    
    //*****************************保存角色权限 start*****************************///
    function saveRolePermission(){
		   var data = $('#rolePermission').treegrid("getSelections");
		  
		   var permission_id = [];
		   
		   for(var i =0;i<data.length;i++){
			   permission_id[i] = data[i].permission_id;
		   }
		   $.ajax({    
		       type:'post',        
		       url:'RoleController/saveRolePermission.do',    
		       data:JSON.stringify(permission_id),   
		       cache:false,
		       dataType : 'text',
		       contentType: 'application/json',
		       success:function(data,textStatus,XMLHttpRequest){
	        		$.messager.alert('添加确认','角色权限保存成功!','info');
	        		$('#roledialog').dialog('close')
		       },
		       error:function(XMLHttpRequest, textStatus, errorThrown){
		         	$.messager.alert('添加失败','角色权限保存失败','error')
		       }
		   });
		   
		   
	}
    //*****************************保存角色权限 end*****************************/// 

    //*****************************添加修改弹出dialog start*****************************///
	  function showdialog(addOrSave){
		   var title='角色添加';
           var row;
		   if('save'==addOrSave){
			   title = "角色修改",
			   row = $('#roleTable').datagrid('getSelected');
			   if(row==null){
				   $.messager.alert('提示消息','请选择!','warning');
				   return false;
			   }
		   }
		   
		   var role_id = row!=null?row.role_id:'';
		   var role_name = row!=null?row.role_name:'';
		   var remark = row!=null?row.remark:'';
		   var org_name = row!=null?row.org_name:'';

		   var href = encodeURI(encodeURI('RoleController/'+addOrSave + 
				   ".do?role_id=" + role_id+  
				   "&role_name=" + role_name+  
				   "&remark=" + remark+  
				   "&org_name=" + org_name 
		   ));
		   
		   //显示dilog
		   $('#roledialog').dialog({
			    title: title,
			    width: 500,
			    height: 230,
			    closed: false,
			    cache: false,
			    href:href,
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$("#RoleADDFrom")[0].reset();
						$("#permissionRoleOrg").combobox("setValue",'');
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
						 $('#roledialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#roledialog').dialog('destroy', true)
			    } 
			});
		   
	  }
    //*****************************添加修改弹出dialog end*****************************///     
	   
	//*****************************添加 begin*****************************///      
	function save(addOrsave){
		if(checkRoleInfo()){
			
			$.ajax({    
		        type:'post',        
		        url:'RoleController/addOrsave.do',    
		        data:decodeURIComponent($("#RoleADDFrom").serialize() + '&addOrSave=' + addOrsave,true),    
		        cache:false,    
		        success:function(data,textStatus,XMLHttpRequest){
		        	if(data=='addSuccess'){
		        		$.messager.alert('添加成功','角色添加成功!','info',function(){
			        		$('#roledialog').dialog('close');
			        		$("#D007").click();
			        	});
		        	};
		        	if(data=='updateSuccess'){
		        		$.messager.alert('修改成功','角色修改成功!','info',function(){
			        		$('#roledialog').dialog('close');
			        		$("#D007").click();
			        	});
		        	};
		        	
		        },
		        error:function(XMLHttpRequest, textStatus, errorThrown){
		        	$.messager.alert('添加失败','用户添加错误!','error')
		        }
		    });
			
		}
	}
	   
	//*****************************添加修改弹出dialog end*****************************///   
	   
    //*****************************添加修改check begin*****************************///
	  function checkRoleInfo(){
		 //判断组织机构是否选择
         
	   if($("#permissionRoleOrg").length>=1){
		   var org = $("#permissionRoleOrg").combobox("getValue");

		   if(org=='' || org==null){
               $.messager.alert('请选择组织机构','请选择组织机构!','info');
               return false;
		   }
	   }
		   
		 //判断角色编码是否正确
		 var roleCode = $("#permissionRoleCode").val();
		 var reg=/^[a-zA-Z0-9]{5,30}$/;
		 if(!reg.test(roleCode)){
             $.messager.alert('请输入5-30位角色编号','请输入5-30位角色编号','info');
             return false;
		 }

		//判断角色名称是否正确
		 var roleName = $("#permissionRoleName").val();
		 reg= /^[\u4e00-\u9fa5]{2,30}$/;
		 if(!reg.test(roleName)){
             $.messager.alert('请输入2-30位角色名称','请输入2-30位角色名称','info');
             return false;
		   }
		 return true;
	  }
    //*****************************添加修改check end*****************************///   
})