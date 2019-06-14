$(document).ready(function() {

	var onload = 0;
	//*****************************主页面表格加载开始*****************************
    $('#rolePermission').treegrid({
        fit:true,
        //pagination:true,
        url:'RoleController/getRolePermission.do',
        nowrap: false,
        animate: true,
        striped:true,
        border:false,
        loadMsg:'查询中...................',
        rownumbers:true,
        fitColumns:true,
        collapsible:false,
        singleSelect:false,
        lines:true,
        method:'post',
        idField: 'permission_id',
        treeField: 'name',
        columns:[[
                {field:'check',align:'center',checkbox:true,width:15},  
          		{field:'permission_id',title:'权限ID',align:'center',width:100,hidden:true},
          		{field:'name',title:'菜单名',align:'left',width:100},
          		{field:'code',title:'菜单编码',align:'center',width:100},
          		{field:'url',title:'菜单路径',align:'center',width:100},
          		{field:'create_time',title:'创建时间',align:'center',width:100},
          		{field:'remark',title:'菜单说明',align:'center',width:100}
              ]],
          onLoadSuccess:function(row,data){
   	    	   $.each(data.rows, function(n,value){  
   	    		   if (value.isCheck != 'n'){
   	    			   $('#rolePermission').treegrid('select',value.permission_id); 
   	    		   }
   	    		   else{
   	    			   $('#rolePermission').treegrid('unselect',value.permission_id); 
   	    		   }
   	    		});
   	    	onload = 1;
   	      },
	    onLoadError:function(){
	    	location.href = $("#basePath").val() + "login/userLogin.do";
	    },
	    onSelect:function(rowData){
	    	if(onload==1){
	    		onload=0;
	    		var thisid = rowData.permission_id;
	    		var Children =$('#rolePermission').treegrid("getChildren",thisid);
                for(var i=0;i<Children.length;i++){
                	$('#rolePermission').treegrid("select",Children[i].permission_id);
                } 
     
                var parent =$('#rolePermission').treegrid("getParent",thisid);
                while(parent != null){
                	$('#rolePermission').treegrid("select",parent.permission_id);
                	parent =$('#rolePermission').treegrid("getParent",parent.permission_id);
                }
                onload=1;
	    	}
	    },
	    onUnselect:function(rowData){
	    	if(onload==1){
	    		onload=0;
	    		var thisid = rowData.permission_id;
		    	var Children =$('#rolePermission').treegrid("getChildren",thisid);
		    	for(var i=0;i<Children.length;i++){
	            	$('#rolePermission').treegrid("unselect",Children[i].permission_id);
	            } 
                 /*
		    	var parent =$('#rolePermission').treegrid("getParent",thisid);
	            while(parent != null){
	               $('#rolePermission').treegrid("unselect",parent.permission_id);
	               parent =$('#rolePermission').treegrid("getParent",parent.permission_id);
	             }*/
	            onload=1;
	    	}
	    }
    });
    
});
