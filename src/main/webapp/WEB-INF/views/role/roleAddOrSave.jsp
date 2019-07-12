<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
var roleAddOrSave = '${roleAddOrSave}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/role/roleAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/role/roleAddOrSave.css" type="text/css">  


<form id="RoleADDFrom" method="post">

	<table class="dataintable">
		<input id="role_ID" name="role_ID" type="hidden" value="${role_id}">
		<tr>
			<td><i>组织机构</i></td>
			<td>
			<c:if test="${roleAddOrSave=='add'}">
				<input id="permissionRoleOrg" style="width: 100%" name="permissionRoleOrg">
			</c:if>
			</td>
			<td><i>角色编号</i></td>
			<td>
			  <input id='permissionRoleCode' style="width: 90%" name="permissionRoleCode" class="easyui-validatebox" value="${role_name}"/>
			</td>
		</tr>

		<tr>
			<td><i>角色名称</i></td>
			<td>
				<input id='permissionRoleName' style="width: 90%" name="permissionRoleName" class="easyui-validatebox" value="${remark}"/>
			</td>
			<td><i></i></td>
			<td><i></i></td>
		</tr>

	</table>

</form>

</div>

