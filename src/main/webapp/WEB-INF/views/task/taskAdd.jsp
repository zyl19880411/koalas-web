<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">

</script>
<script type="text/javascript" src="<%=basePath%>js/common/task/taskAdd.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/task/taskAdd.css" type="text/css">  

<div style="width:90%; height:70%; padding: 10px 10px;">

<form id="taskADDFrom" method="post">

	<div class="fitem">
		<label> 任务名称 </label> 
		<input id='taskName' name="task_name" class="easyui-validatebox"/>
		<label id='errorLabeltaskName' class='errorLabel' style="color: red; font-size: 12">*任务名称错误</label></td>
	</div>
	
	<div class="fitem">
		<label> 任务路径 </label> 
		<input id='taskUrl' name="task_url" class="easyui-validatebox"/>
		<label id='errorLabeltaskUrl' class='errorLabel' style="color: red; font-size: 12">*任务路径错误</label></td>
	</div>
 
    <div class="fitem">
		<label> 任务时间表达式 </label> 
		<input id='taskExpression' name="task_expression" class="easyui-validatebox"/>
		<label id='errorLabeltaskExpression' class='errorLabel' style="color: red; font-size: 12">*任务时间表达式错误</label></td>
	</div>

</form>

</div>

