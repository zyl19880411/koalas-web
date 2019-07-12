<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
var groupAddOrSave = '${groupAddOrSave}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/group/groupAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/group/groupAddOrSave.css" type="text/css">  


<form id="groupADDFrom" method="post">
	<table class="dataintable">
		<input id="group_ID" name="group_ID" type="hidden" value="${group_id}">

		<tr>
			<td style="width: 12%"><i>组织机构</i></td>
			<td style="width: 15%">
				<c:if test="${groupAddOrSave=='add'}">
					<div class="fitem">
						<input id="permissiongroupOrg" style="width: 90%" name="permissiongroupOrg">
					</div>
				</c:if>
 			</td>
			<td style="width: 12%"><i>团队名称</i></td>
			<td style="width: 15%">
				<input id='permissiongroupName' style="width: 90%" name="permissiongroupName" class="easyui-validatebox" value="${group_name}"/>
			</td>
			<td style="width: 12%"><i>团队说明</i></td>
			<td>
				<input id='permissiongroupremark' style="width: 90%" name="permissiongroupremark" class="easyui-validatebox" value="${remark}"/>

			</td>
		</tr>

	</table>

</form>

