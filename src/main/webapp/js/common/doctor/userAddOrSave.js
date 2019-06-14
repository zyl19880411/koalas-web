$(document).ready(
		function() {
			
			//*****************************机构下拉框begin*****************************///  
			$('#permissionUserOrg').combobox({
				url : 'UserController/getOrg.do',
				valueField : 'value',
				textField : 'text',
				editable : false
			});

			//*****************************机构下拉框end*****************************/// 

			//*****************************性别下拉框begin*****************************///  
			$('#permissionGender').combobox({
				valueField : 'value',
				textField : 'text',
				editable : false,
				data:[{
					    value: '1',
					    text: '男'
					},{
						value: '0',
						text: '女'
					}]
			});

			//*****************************性别下拉框end*****************************/// 
			

			//*****************************生日格式begin*****************************///  
			$("#permissionBrithday").datebox({
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
			$('#permissionGender').combobox('setValue',gender);
			
			if(userAddOrSave=='save'){
				$("#permissionLoginName").attr("readonly","true");
			}
			else{
				$("#permissionLoginName").removeAttr("readonly");
				
			}
			
		});
