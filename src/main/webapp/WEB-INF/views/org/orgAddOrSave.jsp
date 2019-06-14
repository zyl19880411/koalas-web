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

<div style="width:90%; height:70%; padding: 10px 10px;">
<div class="ftitle">
<c:choose>
		<c:when test="${orgAddOrSave=='add'}">
			添加机构
		</c:when>
		<c:otherwise>
			修改机构
		</c:otherwise>
</c:choose>
</div>

<form id="OrgADDFrom" method="post">
 
   <input id="parentid" name="parentid" type="hidden" value="${org_id}">
 
    <div class="fitem">
		<label> 机构名称 </label> 
		<input id='permissionOrgName' name="permissionOrgName" class="easyui-validatebox" value="${org_name}" />
		<label id='errorLabelOrgName' class='errorLabel' style="color: red; font-size: 12">*机构名称错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 机构验证编码</label> 
		<input id='permissionadmincode' name="permissionadmincode" class="easyui-validatebox"/>
		<label id='errorLabeladmincode' class='errorLabel' style="color: red; font-size: 12">*机构验证编码错误 </label></td>
	</div>
	    
	<div class="fitem">
		<label> 机构验证密码</label> 
		<input id='permissionOrgPassword' type="password" name="permissionOrgPassword" class="easyui-validatebox" />
		<label id='errorLabelorgpwd' class='errorLabel' style="color: red; font-size: 12">*机构验证密码错误 </label></td>
	</div>

	<div class="fitem">
		<label>机构座机号</label> 
		<input id='permissionOrgTel' name="permissionOrgTel" class="easyui-numberbox" value="${tel}" />
		<label id='errorLabelOrgTel' class='errorLabel' style="color: red; font-size: 12">*座机错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 机构联系人 </label> 
		<input id='permissionOrgLinkName' name="permissionOrgLinkName" class="easyui-validatebox" value="${link_name}"/>
		<label id='errorLabelOrgLinkName' class='errorLabel' style="color: red; font-size: 12">*机构联系人错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 机构联系人手机</label> 
		<input id='permissionOrgLinkPhone' name="permissionOrgLinkPhone" class="easyui-numberbox"  value="${link_phone}" />
		<label id='errorLabelOrgLinkPhone' class='errorLabel' style="color: red; font-size: 12">*机构联系人手机错误 </label></td>
	</div>
	
	 <div class="fitem">
		<label> 机构地址 </label> 
		<input id='permissionOrgAddress' name="permissionOrgAddress" class="easyui-validatebox" value="${address}"/>
		<label id='errorLabelOrgAddress' class='errorLabel' style="color: red; font-size: 12">*机构地址错误 </label></td>
	</div>
	
</form>

</div>

