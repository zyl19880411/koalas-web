$(document).ready(function() {
		 
	
	 //********************选择图片start************************************************
	$("#selectIcon").click(function(){
		//重新生成div元素，方便生成dilog画面
	     if($("#icondialog").length == 0){
		     $("#icondiv").html("<div id='icondialog' name='icondialog'></div>");
	     }
	     
	     //显示dilog
		   $('#icondialog').dialog({
			    title: "选择图标",
			    width: 516,
			    height: 400,
			    closed: false,
			    cache: false,
			    href:'PermissionController/icon.do',
			    iconCls: 'icon-save',
			    //content: '123',
			    toolbar: [{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						saveIcon();
					}
				}],
				buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						 $('#icondialog').dialog('close')
					}
				}],
			    modal: true,
			    onClose:function(){
			    	$('#icondialog').dialog('destroy', true)
			    } 
			});
	});
	 //********************图标查询end************************************************
	function saveIcon(){
		 if($("#inconCode").val()==null || $("#inconCode").val()=='' || $("#inconCode").val() =='undefind'){
			 $.messager.alert('提示消息','请选择!','warning');
			 return;
		 }
		 $("#perIcon").val($("#inconCode").val());
   		 $('#icondialog').dialog('close');
	}

});
