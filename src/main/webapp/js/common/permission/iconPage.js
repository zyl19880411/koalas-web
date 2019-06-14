$(document).ready(function() {
 
	
	var inconCode;
	
	$('#pp').pagination({
	    total:1025,
	    pageList: [200,300,500,1000,1500],
	    pageSize:500,
	    onSelectPage:function(pageNumber,pageSize){

	    	
	    	$.ajax({    
		        type:'post',        
		        url:'PermissionController/selecticon.do',    
		        data:{"page":pageNumber,"rows":pageSize},    
		        cache:false,
		        dataType:'json',  
		        success:function(data,textStatus,XMLHttpRequest){
		        	$("#iconDiv").html("");
		        	var icon =data.list.split(",");
		        	for(var i = 0;i<icon.length;i++){
		        		$("#iconDiv").append("<span style ='margin-left:4px;' class=\""+icon[i].replace(/(^\s*)|(\s*$)/g,'')+ "\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>");
		        		if(i%22==0){
		        			$("#iconDiv").append("<br>");
		        		}
		        	}
		        	
		        	$("#iconDiv span").on("click",function(){
		        		if($("#inconCode").val() == $(this).attr("class")){
		        			$(this).css("background-color","");
		        			$("#inconCode").val("");
		        			return;
		        		}
		        		
		        		$("#inconCode").val($(this).attr("class"));
		        		$(this).siblings().css("background-color","").end().css("background-color","red");
		       	})
		        	
		        },
		        error:function(XMLHttpRequest, textStatus, errorThrown){
		        	$.messager.alert('查询失败','查询图片错误!','error')
		        }
		    });
	    	
	    	
	    	
	    }
	});
	
	$("#iconDiv span").on("click",function(){
		
		if($("#inconCode").val() == $(this).attr("class")){
			$(this).css("background-color","");
			$("#inconCode").val("");
			return;
		}
		 
		$("#inconCode").val($(this).attr("class"));
		$(this).siblings().css("background-color","").end().css("background-color","red");
	})
	
	
	 /*$("#iconDiv span").mouseover(function(){
		  $(this).css("background-color","red");
	 });
	
	 $("#iconDiv span").mouseout(function(){
		  $(this).css("background-color","");
		});*/

});
