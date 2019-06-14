<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
var userAddOrSave = '${userAddOrSave}';
var gender = '${gender}';
var cardid = '${cardid}';
var birth_date = '${birth_date}';
var qq = '${qq}';
var tel = '${tel}';
var phone = '${phone}';

</script>
<script type="text/javascript" src="<%=basePath%>js/common/doctor/userAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/doctor/userAddOrSave.css" type="text/css"> 

<div style="width:90%; height:70%; padding: 10px 10px;">
<div class="ftitle">
<c:choose>
		<c:when test="${userAddOrSave=='add'}">
			添加用户
		</c:when>
		<c:otherwise>
			修改用户
		</c:otherwise>
</c:choose>
</div>

<form id="UserADDFrom" method="post">
 
    <input id="doctor_ID" name="doctor_ID" type="hidden" value="${doc_id}">

   <c:if test="${userAddOrSave=='add'}">
      <div class="fitem">
		<label> 组织机构</label> 
		<input id="permissionUserOrg" name="permissionUserOrg">
		<label id='errorLabelOrg'  class='errorLabel' style="color: red; font-size: 12 " >*请选择组织机构 </label></td>
	</div>
   </c:if>

     <div class="fitem">
		<label> 姓名 </label> 
		<input id='permissionUserName' name="permissionUserName" class="easyui-validatebox" value="${doc_name}"/>
		<label id='errorLabelUserName' class='errorLabel' style="color: red; font-size: 12">*用户名错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 登录名 </label> 
		<input id='permissionLoginName' name="permissionLoginName" class="easyui-validatebox"   value="${login_name}"/>
		<label id='errorLabelLoginName' class='errorLabel' style="color: red; font-size: 12">*用户名错误 </label></td>
	</div>
	    
	<div class="fitem">
		<label> 密码</label> 
		<input id='permissionPassword' type="password" name="permissionPassword" class="easyui-validatebox" />
		<label id='errorLabelpwd' class='errorLabel' style="color: red; font-size: 12">*密码错误 </label></td>
	</div>

   <div class="fitem">
		<label> 确认密码</label> 
		<input id='permissionCheckPassword' type="password" name="permissionCheckPassword" style="margin-bottom: 10px;" class="easyui-validatebox" />
		<label id='errorCheckpwd' class='errorLabel' style="color: red; font-size: 12">*两次输入密码不一致 </label></td>
	</div>

	<div class="fitem">
		<label> 性别 </label>
		<input id="permissionGender" name="permissionGender">
		<label id='errorLabelGender' class='errorLabel' style="color: red; font-size: 12">*性别错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 身份证号</label>
		<input id="permissionCardid" name="permissionCardid" class="easyui-validatebox"  value="${cardid}" />
		<label id='errorLabelCardid' class='errorLabel' style="color: red; font-size: 12">* 身份证错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 用户生日</label> 
		<input id='permissionBrithday' name="UserBrithday" class="easyui-datebox" value="${birth_date}"/>
		<label id='errorLabelBrithday' class='errorLabel' style="color: red; font-size: 12">*用户生日错误 </label></td>
	</div>
 
    <div class="fitem">
		<label> QQ</label> 
		<input id='permissionQQ' name="permissionQQ" class="easyui-numberbox" value="${qq}"/>
		<label id='errorLabelQQ' class='errorLabel' style="color: red; font-size: 12">*QQ错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 座机</label> 
		<input id='permissionTel' name="permissionTel" class="easyui-numberbox" value="${tel}" />
		<label id='errorLabelTel' class='errorLabel' style="color: red; font-size: 12">*座机错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 手机</label> 
		<input id='permissionPhone' name="permissionPhone" class="easyui-numberbox"  value="${phone}" />
		<label id='errorLabelPhone' class='errorLabel' style="color: red; font-size: 12">*手机错误 </label></td>
	</div>
</form>

</div>

