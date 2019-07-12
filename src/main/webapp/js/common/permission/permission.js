$(document).ready(function() {
	
	//*****************************主页面表格加载开始*****************************
	var selectrow=null;
	
    $('#permissionTable').treegrid({
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
        singleSelect:false,
        lines:true,
        method:'post',
        idField: 'permissionID',
        treeField: 'name',
        toolbar:'#permissionTableTB',
        columns:[[
                {field:'check',align:'center',checkbox:true,width:15},  
                {field:'permissionID',title:'权限ID',align:'center',width:100,hidden:true},
                {field:'_parentId',title:'上级菜单',align:'center',width:100,hidden:true},
                {field:'elementType',title:'菜单等级',align:'center',width:100,hidden:true},
          		{field:'name',title:'菜单名称',align:'left',width:100},
          		{field:'code',title:'菜单编码',align:'center',width:100},
          		{field:'url',title:'菜单路径',align:'center',width:100},
          		{field:'iconCls',title:'菜单图标',align:'center',width:30,hidden:true},
          		{field:'iconClsShow',title:'菜单图标',align:'center',width:30,
        			formatter: function(value,row,index){
        				if (row.iconCls){
        					return '<span class="'+row.iconCls + '">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>';
        				} else {
        					return value;
        				}
        			}},
          		{field:'create_time',title:'创建时间',align:'center',width:100},
          		{field:'remark',title:'菜单说明',align:'center',width:100}
              ]],
        onLoadSuccess:function(row,data){
        	var check = $("#permissionTableTB").next("div").find(".datagrid-header :checkbox");
    		$(check).prop("disabled",true)
    	    $('#permissionTable').treegrid("collapseAll");
    	    
        },
		onCheck:function(row){
	    	  if(selectrow!=row && selectrow!=null){
	    		  $('#permissionTable').treegrid("unselect",selectrow.permissionID);
	    	  }
	    	  selectrow = row;
		  },
		    onLoadError:function(){
		    	location.href = $("#basePath").val() +"login/userLogin.do";
		    }

    });  
    
       //********************表格自适应start************************************************
       var header =$("#permissionTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
    
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#permissionTable').treegrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	 //********************表格自适应end************************************************

	    $('#permissionTable').treegrid({
		   url:"PermissionController/getPermission.do"
		 });
     //********************菜单查询start************************************************
	   $("#D012").click(function(){
		  var options = $('#permissionTable').treegrid("options");  
		  options.url = "PermissionController/getPermission.do";
		  $('#permissionTable').treegrid("load");  
	   });
	 //********************菜单查询end************************************************   
	   
	 //********************菜单添加start************************************************
	   $("#D013").click(function(){
		  var selectRowD013 = $('#permissionTable').treegrid("getSelected");
		  if(selectRowD013 !=null && selectRowD013.elementType==3){
				  $.messager.alert('提示消息','三级菜单无法添加子菜单!','warning');
				   return;
			  }
		  
		  //重新生成div元素，方便生成dilog画面
		     if($("#permissiondialog").length == 0){
			     $("#permissiondiv").html("<div id='permissiondialog' name='permissiondialog'></div>");
		     }
           showDialog("add",selectRowD013);
		  });
		   
	 //********************菜单添加end************************************************
	   
	   //********************菜单修改start************************************************
	   $("#D014").click(function(){
		  var selectRowD014 = $('#permissionTable').treegrid("getSelected");
		  if(selectRowD014 ==null){
				  $.messager.alert('提示消息','请选择!','warning');
				   return;
			}
		  
		  //重新生成div元素，方便生成dilog画面
		     if($("#permissiondialog").length == 0){
			     $("#permissiondiv").html("<div id='permissiondialog' name='permissiondialog'></div>");
		     }
		     
           showDialog("save",selectRowD014);
		  });
		   
	 //********************菜单修改 end************************************************ 
	   
	   //********************菜单删除start************************************************
	   $("#D015").click(function(){
		   var selectRowD015 = $('#permissionTable').treegrid("getSelected");
		   if(selectRowD015 ==null){
				  $.messager.alert('提示消息','请选择!','warning');
				   return;
			}
		   
		   
		   $.messager.confirm('确认删除', '确认删除这个菜单吗?', function(r){
		    	if (r){
				   var permissionId = [];
				   var child = $('#permissionTable').treegrid("getChildren",selectRowD015.permissionID);
				   
				   permissionId[permissionId.length] =selectRowD015.permissionID;
				   
				   for(var i=0;i<child.length;i++){
					   permissionId[permissionId.length] = child[i].permissionID;
				   }
				   $.ajax({    
				       type:'post',        
				       url:'PermissionController/del.do',    
				       data:JSON.stringify(permissionId),   
				       cache:false,
				       dataType : 'text',
				       contentType: 'application/json',
				       success:function(data,textStatus,XMLHttpRequest){
				    	   if(data == 'delSuccess'){
				    		   $.messager.alert('删除确认','权限删除成功!','info',function(){
				    			   $('#permissionTable').treegrid("unselect",selectRowD015.permissionID);
				    			   selectrow=null;
				    			   $('#permissionTable').treegrid("load");
				    		   });
				    	   }else{
		 		        		location.href = $("#basePath").val() +"login/userLogin.do";
		 		        	}
				       },
				       error:function(XMLHttpRequest, textStatus, errorThrown){
				         	$.messager.alert('删除失败','权限删除失败','error');
				       }
				   });
		    	}
		   
		});
	   });
	 //********************菜单删除 end************************************************ 
	   
	   
	   
	   function showDialog(saveOrAdd,selectRowshowDialog){
		  
		   var title='菜单添加';

		   var permissionID='';
		   var elementType=1;
		   var perIcon = '';
		   var perName = '';
		   var url ='';
		   var iconCls='';
		   var remark='';
		   if('save'==saveOrAdd){
			   title = "菜单修改";
			   permissionID=selectRowshowDialog.permissionID;
			   perName = selectRowshowDialog.name;
			   url = selectRowshowDialog.url;
			   iconCls = selectRowshowDialog.iconCls;
			   remark = selectRowshowDialog.remark;
			   elementType =parseInt(selectRowshowDialog.elementType);
		   }
		   else{
			   //添加
			   if(selectRowshowDialog!=null){
				     permissionID=selectRowshowDialog.permissionID;
				     elementType =parseInt(selectRowshowDialog.elementType)+1;
			   }
		   }

		   //显示dilog
		   $('#permissiondialog').dialog({
			    title: title,
			    width: 600,
			    height: 230,
			    closed: false,
			    cache: false,
			    href:encodeURI(encodeURI('PermissionController/' + saveOrAdd + 
			    '.do?permissionID=' + permissionID + 
			    '&perName=' + perName +
			    '&elementType=' + elementType +
			    '&perUrl=' + url +
			    '&perIcon=' + iconCls +
			    '&perRemark=' + remark)),
			    
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'取消',
					iconCls:'icon-remove',
					handler:function(){
						$("#perADDFrom")[0].reset();
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						save(saveOrAdd);
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#permissiondialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#permissiondialog').dialog('destroy', true)
			    } 
			});
	   };
	   
	   
	   function save(addOrSave){
			  if(checkPerInfo()){

				  $.ajax({    
				        type:'post',        
				        url:'PermissionController/addorSave.do',    
				        data:decodeURIComponent($("#perADDFrom").serialize() + '&addOrSave=' + addOrSave,true),    
				        cache:false,    
				        success:function(data,textStatus,XMLHttpRequest){
				        	if(data=='addSuccess'){
				        		$.messager.alert('添加成功','添加菜单成功!','info',function(){
				        			 $('#permissiondialog').dialog('close');
				        			 $('#permissionTable').treegrid("load");
				        		}) 
				        	}
				        	if(data =='updSuccess'){
				        		$.messager.alert('修改成功','修改菜单成功!','info',function(){
				        			 $('#permissiondialog').dialog('close');
				        			 $('#permissionTable').treegrid("load");
				        		})
				        	}
				          
				        },
				        error:function(XMLHttpRequest, textStatus, errorThrown){
				        	$.messager.alert('添加失败','添加菜单错误!','error')
				        }
				    });
				  
			  }
	   }
	   
	   function checkPerInfo(){
		   
 		    //菜单名称验证
		   var perName = $("#perName").val();
		   var reg= /^[\u4e00-\u9fa5a-zA-Z0-9]{2,30}$/;
		   if(!reg.test(perName)){
               $.messager.alert('请输入正确的菜单名称','请输入正确的菜单名称!','info');
               return false;
		   }

		   
		 //菜单图片验证
		   var perIcon = $("#perIcon").val();
		   reg= /^[a-zA-Z0-9\-\_]{2,30}$/;
		   if(!reg.test(perIcon)){
               $.messager.alert('请输入正确的图片名称','请输入正确的图片名称!','info');
               return false;
		   }
		   
		   if(elementType == 2){
			 //菜单路径验证
			   var perUrl = $("#perUrl").val();
			   reg= /^[a-zA-Z0-9\/]{2,30}\.do$/;
			   if(!reg.test(perUrl)){
                   $.messager.alert('请输入正确的菜单路径','请输入正确的菜单路径!','info');
                   return false;
			   }
		   }
		   
		   //菜单说明验证
		   var perRemark = $("#perRemark").val();
		   reg= /^[\u4e00-\u9fa5a-zA-Z0-9]{0,30}$/;
		   if(!reg.test(perRemark)){
               $.messager.alert('请输入正确的菜单说明','请输入正确的菜单说明!','info');
               return false;
		   }
		   return true;
	   }
 
});
