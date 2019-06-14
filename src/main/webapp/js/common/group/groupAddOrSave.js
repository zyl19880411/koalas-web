$(document).ready(function() {
	
	if (groupAddOrSave == 'add') {
		
		//*****************************机构下拉框begin*****************************///  
		$('#permissiongroupOrg').combobox({
			url : 'UserController/getOrg.do',
			valueField : 'value',
			textField : 'text',
			editable : false
		});
		//*****************************机构下拉框end*****************************/// 
	}

});
