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

<form id="taskADDFrom" method="post">
	<table class="dataintable">

		<tr>
			<td><i>任务名称</i></td>
			<td>
				<input id='taskName' name="task_name" style="width: 90%" class="easyui-validatebox"/>
			</td>
			<td><i>任务时间表达式</i></td>
			<td>
				<input id='taskExpression' style="width: 90%" name="task_expression" class="easyui-validatebox"/>
			</td>
		</tr>

		<tr>
			<td><i>任务路径</i></td>
			<td colspan="3">
				<input id='taskUrl' name="task_url" style="width: 97%" class="easyui-validatebox"/>
			</td>
		</tr>

	</table>
</form>


