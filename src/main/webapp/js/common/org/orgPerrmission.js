$(document).ready(function() {
	var onload = 0;
	//*****************************用户角色表格加载start*****************************
    $('#org_perrmission').treegrid({
        fit:true,
        // pagination:true,
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
        idField: 'permissionID',
        treeField: 'name',
        url:'OrgController/getOrgPerrmission.do',
    	queryParams: {
    		'parentid':parentid,
    		'org_id':org_id
    	},
        columns:[[
                {field:'org_perrmission_check',align:'center',checkbox:true,width:15}, 
                {field:'permissionID',title:'权限ID',align:'center',width:100,hidden:true},
                {field:'_parentId',title:'上级菜单',align:'center',width:100,hidden:true},
          		{field:'name',title:'菜单名称',align:'left',width:100},
          		{field:'code',title:'菜单编码',align:'center',width:100},
          		{field:'url',title:'菜单路径',align:'center',width:100},
          		{field:'iconCls',title:'菜单图标',align:'center',width:50,hidden:true},
          		{field:'iconClsShow',title:'菜单图标',align:'center',width:50,
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
          //toolbar:'#userTableTB',
	      onLoadSuccess:function(row,data){
	    	   $.each(data.rows, function(n,value){  
	    		   
	    		   if (value.ischeck != 'n'){
	    			   $('#org_perrmission').treegrid('select', value.permissionID); 
	    		   }
	    		   else{
	    			   $('#org_perrmission').treegrid('unselect', value.permissionID); 
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
	    		var thisid = rowData.permissionID;
	    		var Children =$('#org_perrmission').treegrid("getChildren",thisid);
                for(var i=0;i<Children.length;i++){
                	$('#org_perrmission').treegrid("select",Children[i].permissionID);
                } 
     
                var parent =$('#org_perrmission').treegrid("getParent",thisid);
                while(parent != null){
                	$('#org_perrmission').treegrid("select",parent.permissionID);
                	parent =$('#org_perrmission').treegrid("getParent",parent.permissionID);
                }
                onload=1;
	    	}
	    },
	    onUnselect:function(rowData){
	    	if(onload==1){
	    		onload=0;
	    		var thisid = rowData.permissionID;
		    	var Children =$('#org_perrmission').treegrid("getChildren",thisid);
		    	for(var i=0;i<Children.length;i++){
	            	$('#org_perrmission').treegrid("unselect",Children[i].permissionID);
	            } 
                 /*
		    	var parent =$('#rolePermission').treegrid("getParent",thisid);
	            while(parent != null){
	               $('#rolePermission').treegrid("unselect",parent.permissionID);
	               parent =$('#rolePermission').treegrid("getParent",parent.permissionID);
	             }*/
	            onload=1;
	    	}
	    }
    });
  //*****************************用户角色表格加载end*****************************
    
});
