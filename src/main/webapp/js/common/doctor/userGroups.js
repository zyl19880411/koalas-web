$(document).ready(function() {
 
	//*****************************用户角色表格加载start*****************************
    $('#user_Groups_table').datagrid({
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
        url:'UserController/getuserGroups.do',
    	queryParams: {
    		'doc_id':doc_id
    	},
        columns:[[
                {field:'user_Groups_check',align:'center',checkbox:true,width:15}, 
                {field:'doc_id',title:'医生ID',align:'center',width:100,hidden:true},
          		{field:'group_id',title:'团队ID',align:'center',width:100,hidden:true},
          		{field:'group_name',title:'团队编码',align:'center',width:100},
          		{field:'remarks',title:'团队名称',align:'center',width:100},
          		{field:'ischecked',title:'是否选择',align:'center',width:100,hidden:true}
              ]],
          //toolbar:'#userTableTB',
	      onLoadSuccess:function(data){
	    	   $.each(data.rows, function(n,value){  
	    		   if (value.ischecked != 'n'){
	    			   $('#user_Groups_table').datagrid('selectRow', n); 
	    		   }
	    		}); 
	      },
	    onLoadError:function(){
	    	location.href = $("#basePath").val() + "login/userLogin.do";
	    }
    });
  //*****************************用户角色表格加载end*****************************
    
});
