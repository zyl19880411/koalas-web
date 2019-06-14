$(document).ready(function() {
 
	//*****************************用户角色表格加载start*****************************
    $('#user_roles_table').datagrid({
        fit:true,
        pagination:true,
        nowrap: false,
        striped:true,
        border:false,
        loadMsg:'查询中...................',
        rownumbers:true,
        fitColumns:true,
        collapsible:false,
        singleSelect:false,
        method:'post',
        url:'UserController/getuserRoles.do',
    	queryParams: {
    		'doc_id':doc_id
    	},
        columns:[[
                {field:'user_roles_check',align:'center',checkbox:true,width:15}, 
                {field:'doc_id',title:'医生ID',align:'center',width:100,hidden:true},
          		{field:'role_id',title:'角色ID',align:'center',width:100,hidden:true},
          		{field:'role_name',title:'角色编码',align:'center',width:100},
          		{field:'role_remark',title:'角色名称',align:'center',width:100},
          		{field:'ischecked',title:'是否选择',align:'center',width:100,hidden:true}
              ]],
          //toolbar:'#userTableTB',
	      onLoadSuccess:function(data){
	    	   $.each(data.rows, function(n,value){  
	    		   if (value.ischecked != 'n'){
	    			   $('#user_roles_table').datagrid('selectRow', n); 
	    		   }
	    		}); 
	      },
	    onLoadError:function(){
	    	location.href = $("#basePath").val() + "login/userLogin.do";
	    }
    });
  //*****************************用户角色表格加载end*****************************
    
});
