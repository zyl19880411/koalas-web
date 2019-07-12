<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
    var elementType = '${elementType}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/permission/perAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/permission/perAddOrSave.css" type="text/css">

<form id="perADDFrom" method="post">
	<table class="dataintable">
		<input id="elementType" name="elementType" type="hidden" value="${elementType}">
		<input id="permissionID" name="permissionID" type="hidden" value="${permissionID}">


		<tr>
			<td><i>菜单名称</i></td>
			<td>
				<input id='perName' name="perName" style="width: 90%" class="easyui-validatebox" value="${perName}" />
			</td>
			<td><i>菜单图片</i></td>
			<td>
				<input id='perIcon' name="perIcon" style="width: 70%" class="easyui-validatebox" value="${perIcon}" />
				<a id="selectIcon" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'"></a>
			</td>
		</tr>

		<tr>
			<td><i>菜单路径</i></td>
			<td>
				<c:if test="${elementType=='2'}">
					<input id='perUrl' name="perUrl" style="width: 90%" class="easyui-validatebox" value="${perUrl}" />
				</c:if>
			</td>
			<td><i>菜单说明</i></td>
			<td>
			<input id='perRemark' style="width: 90%" name="perRemark" class="easyui-validatebox" value="${perRemark}" />
			</td>
		</tr>

	</table>
</form>

<!-- 业务对话框 -->
<div id='icondiv' name='icondiv'>
	<div id='icondialog' name='icondialog'>
	</div>
</div>


