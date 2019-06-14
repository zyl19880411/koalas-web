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

<div style="width:90%; height:70%; padding: 10px 10px;">
<div class="ftitle">
<c:choose>
		<c:when test="${roleAddOrSave=='add'}">
			添加角色
		</c:when>
		<c:otherwise>
			修改角色
		</c:otherwise>
</c:choose>
</div>

<form id="RoleADDFrom" method="post">

  <input id="role_ID" name="role_ID" type="hidden" value="${role_id}">
 
   <c:if test="${roleAddOrSave=='add'}">
      <div class="fitem">
		<label> 组织机构</label> 
		<input id="permissionRoleOrg" name="permissionRoleOrg">
		<label id='errorLabelRoleOrg'  class='errorLabel' style="color: red; font-size: 12 " >*请选择组织机构 </label></td>
	</div>
   </c:if>

	<div class="fitem">
		<label> 角色编号 </label> 
		<input id='permissionRoleCode' name="permissionRoleCode" class="easyui-validatebox" value="${role_name}"/>
		<label id='errorLabelRoleCode' class='errorLabel' style="color: red; font-size: 12">*角色编号错误</label></td>
	</div>
	
	<div class="fitem">
		<label> 角色名称 </label> 
		<input id='permissionRoleName' name="permissionRoleName" class="easyui-validatebox" value="${remark}"/>
		<label id='errorLabelRoleName' class='errorLabel' style="color: red; font-size: 12">*角色名称错误</label></td>
	</div>

</form>

</div>

