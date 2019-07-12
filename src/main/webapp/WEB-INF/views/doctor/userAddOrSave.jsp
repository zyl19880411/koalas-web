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

<form id="UserADDFrom" method="post">
	<table class="dataintable">
		<input id="doctor_ID" name="doctor_ID" type="hidden" value="${doc_id}">

		<tr>
			<td><i>组织机构</i></td>
			<td>
				<c:if test="${userAddOrSave=='add'}">
				   <input id="permissionUserOrg" style="width: 90%" name="permissionUserOrg">
			    </c:if>
			</td>
			<td><i>姓名</i></td>
			<td>
				<input id='permissionUserName' name="permissionUserName" style="width: 90%" class="easyui-validatebox" value="${doc_name}"/>
			</td>
		</tr>

		<tr>
			<td><i>登录名</i></td>
			<td>
				<input id='permissionLoginName' name="permissionLoginName" class="easyui-validatebox" style="width: 90%"  value="${login_name}"/>
			</td>
			<td><i>密码</i></td>
			<td>
				<input id='permissionPassword' type="password" name="permissionPassword" style="width: 90%" class="easyui-validatebox" />
			</td>
		</tr>

		<tr>
			<td><i>确认密码</i></td>
			<td>
				<input id='permissionCheckPassword' type="password" name="permissionCheckPassword" style="margin-bottom: 10px;width: 90%;" class="easyui-validatebox" />
			</td>
			<td><i>性别</i></td>
			<td>
				<input id="permissionGender" name="permissionGender" style="width: 90%">
			</td>
		</tr>

		<tr>
			<td><i>身份证号</i></td>
			<td>
				<input id="permissionCardid" name="permissionCardid" style="width: 90%" class="easyui-validatebox"  value="${cardid}" />
			</td>
			<td><i>用户生日</i></td>
			<td>
				<input id='permissionBrithday' name="UserBrithday" style="width: 90%" class="easyui-datebox" value="${birth_date}"/>
			</td>
		</tr>

		<tr>
			<td><i>QQ</i></td>
			<td>
				<input id='permissionQQ' style="width: 90%" name="permissionQQ" class="easyui-numberbox" value="${qq}"/>
			</td>
			<td><i>座机</i></td>
			<td>
				<input id='permissionTel' name="permissionTel" style="width: 90%" class="easyui-numberbox" value="${tel}" />
			</td>
		</tr>
		<tr>
			<td><i>手机</i></td>
			<td>
				<input id='permissionPhone' name="permissionPhone" style="width: 90%" class="easyui-numberbox"  value="${phone}" />
			</td>
			<td></td>
			<td>
 			</td>
		</tr>
	</table>

</form>

</div>

