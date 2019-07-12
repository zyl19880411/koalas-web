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
<script type="text/javascript" src="<%=basePath%>js/common/org/orgAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/org/orgAddOrSave.css" type="text/css"> 


<form id="OrgADDFrom" method="post">
	<input id="parentid" name="parentid" type="hidden" value="${org_id}">
	<table class="dataintable">

	<tr>
		<td><i>机构名称</i></td>
		<td>
			<input id='permissionOrgName' style="width: 90%" name="permissionOrgName" class="easyui-validatebox" value="${org_name}" />
		</td>
		<td><i>机构验证编码</i></td>
		<td>
			<input id='permissionadmincode' style="width: 90%" name="permissionadmincode" class="easyui-validatebox"/>
		</td>
	</tr>

		<tr>
			<td><i>机构验证密码</i></td>
			<td>
				<input id='permissionOrgPassword' style="width: 90%" type="password" name="permissionOrgPassword" class="easyui-validatebox" />
			</td>
			<td><i>机构座机号</i></td>
			<td>
				<input id='permissionOrgTel' style="width: 90%" name="permissionOrgTel" class="easyui-numberbox" value="${tel}" />
			</td>
		</tr>

		<tr>
			<td><i>机构联系人</i></td>
			<td>
				<input id='permissionOrgLinkName' style="width: 90%" name="permissionOrgLinkName" class="easyui-validatebox" value="${link_name}"/>
			</td>
			<td><i>机构联系人手机</i></td>
			<td>
				<input id='permissionOrgLinkPhone' style="width: 90%" name="permissionOrgLinkPhone" class="easyui-numberbox"  value="${link_phone}" />
			</td>
		</tr>

		<tr>
			<td><i>机构地址</i></td>
			<td>
				<input id='permissionOrgAddress' style="width: 90%" name="permissionOrgAddress" class="easyui-validatebox" value="${address}"/>
			</td>
			<td></td>
			<td>
 			</td>
		</tr>

	</table>
</form>

