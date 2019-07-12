<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/task/task.js"></script>

<!-- table页面 -->
<table id='taskTable'>
</table>

<!-- table工具条 -->
<div id="taskTableTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">

	<div style="margin-top: 5px; margin-left: 10px">
	    <c:forEach items="${list}" var="item">
			<shiro:hasPermission name="${item.code}">
				<a id='${item.permission_id}' href="javascript:void(0);" class="easyui-linkbutton" plain=true  iconCls="${item.icon}">${item.name}</a>
				<span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
			</shiro:hasPermission>
		</c:forEach>
		</div>
</div>

<!-- 业务对话框 -->
<div id='taskAdddiv' name='taskAdddiv'>
	<div id='taskAdddialog' name='taskAdddialog'></div>
</div>

<!-- 业务对话框 -->
<div id='taskUpddiv' name='taskUpddiv'>
	<div id='taskUpddialog' name='taskUpddialog'></div>
</div>