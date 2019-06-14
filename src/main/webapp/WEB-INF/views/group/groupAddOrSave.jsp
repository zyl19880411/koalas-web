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

<div style="width:90%; height:70%; padding: 10px 10px;">
<div class="ftitle">
<c:choose>
		<c:when test="${groupAddOrSave=='add'}">
			添加团队
		</c:when>
		<c:otherwise>
			修改团队
		</c:otherwise>
</c:choose>
</div>

<form id="groupADDFrom" method="post">

  <input id="group_ID" name="group_ID" type="hidden" value="${group_id}">
 
   <c:if test="${groupAddOrSave=='add'}">
      <div class="fitem">
		<label> 组织机构</label> 
		<input id="permissiongroupOrg" name="permissiongroupOrg">
		<label id='errorLabelgroupOrg'  class='errorLabel' style="color: red; font-size: 12 " >*请选择组织机构 </label></td>
	</div>
   </c:if>

	<div class="fitem">
		<label> 团队名称 </label> 
		<input id='permissiongroupName' name="permissiongroupName" class="easyui-validatebox" value="${group_name}"/>
		<label id='errorLabelgroupName' class='errorLabel' style="color: red; font-size: 12">*团队名称错误</label></td>
	</div>
	
	<div class="fitem">
		<label> 团队说明 </label> 
		<input id='permissiongroupremark' name="permissiongroupremark" class="easyui-validatebox" value="${remark}"/>
		<label id='errorLabelgroupremark' class='errorLabel' style="color: red; font-size: 12">*团队说明错误</label></td>
	</div>

</form>

</div>

