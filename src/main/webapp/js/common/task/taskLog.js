$(document).ready(function() {

	//*****************************主页面表格加载开始*****************************
    $('#taskLogTable').datagrid({
        fit:true,
        pagination:true,
        nowrap: false,
        striped:true,
        border:false,
        loadMsg:'查询中...................',
        rownumbers:true,
        collapsible:false,
        fitColumns:false,
        singleSelect:true,
        method:'post',
        columns:[[
          		{field:'taskId',title:'任务ID',align:'center',width:50,hidden:true},
          		{field:'taskName',title:'任务名称',align:'center',width:100},
          		{field:'taskBeginTime',title:'开始时间',align:'center',width:50},
          		{field:'taskEndTime',title:'结束时间',align:'center',width:50},
          		{field:'taskResult',title:'执行状态',align:'center',width:50,
        			formatter: function(value,row,index){
        				if (value==null || value==''){
        					return '执行中';
        				} else if(value=='1'){
        					return "(执行)成功"
        				}
        				else{
        					return "(执行)失败"
        				}

        			}},
          		{field:'taskRunningMessage',title:'执行结果',align:'left',halign:'center',width:150}
              ]],
        toolbar:'#taskLogTableTB',
	    onLoadError:function(){
	    	location.href = $("#basePath").val() +"login/userLogin.do";
	    }
    });

      //********************表格自适应start************************************************
      var header =$("#taskLogTableTB").next("div").find("div .datagrid-header .datagrid-htable");
	   
	   var headerWidth=0;;
	   $.each(header,function(index,value){
		   headerWidth+=$(value).width();
	   });
      
	   if(headerWidth<=$(document).width()-$("#menuWidth").val()){
		   $('#taskLogTable').datagrid({
			   fitColumns:true
		   });
	   }
	   $(".datagrid-view").css("background","url('"+ $("#basePath").val()+ "icons/common/login/btnindex.jpg')");
	   $('#taskLogTable').datagrid({
		   url:'TaskLogController/getAllTaskLog.do'
	   });
	 //********************表格自适应end************************************************
	   
	   //$(window).height(); //浏览器当前窗口可视区域高度
	   //$(document).height(); //浏览器当前窗口文档的高度
	   //$(document.body).height();//浏览器当前窗口文档body的高度
	   //$(document.body).outerHeight(true);//浏览器当前窗口文档body的总高度 包括border padding margin
	   //$(window).width(); //浏览器当前窗口可视区域宽度
	   //$(document).width();//浏览器当前窗口文档对象宽度
	   //$(document.body).width();//浏览器当前窗口文档body的高度
	   //$(document.body).outerWidth(true);//浏览器当前窗口文档body的总宽度 包括border padding margin 
	   
    //*****************************主页面表格加载结束*****************************   
	 //*****************************主页面表格查询begin*****************************   
	   $("#KFGL0lWTbrctpHkO8ZjIjSjJI8nHQ8xE").click(function(){
		   $('#taskLogTable').datagrid({
			   url:'TaskLogController/getAllTaskLog.do'
		   });
	   })
	 //*****************************主页面表格查询end*****************************   
	   
})