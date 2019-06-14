$(document).ready(function() {
	
	if (roleAddOrSave == 'add') {
		
		//*****************************机构下拉框begin*****************************///  
		$('#permissionRoleOrg').combobox({
			url : 'UserController/getOrg.do',
			valueField : 'value',
			textField : 'text',
			editable : false
		});
		//*****************************机构下拉框end*****************************/// 
	}

});
