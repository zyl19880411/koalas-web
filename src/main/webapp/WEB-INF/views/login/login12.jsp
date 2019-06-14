<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="/inc/inc.jsp"></jsp:include>
<title>登录页面</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<script type="text/javascript" src="<%=basePath%>js/common/login/login.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common/login/login.css">
<script type="text/javascript">  
$(document).ready(function() {
	
	var loginBody = $("#loginBody").length;
	if(loginBody==1){
		location.href="<%=basePath%>login/userLogin.do";
	}

})
</script> 

</head>
<body>
	<form id="ff" method=post name="user" action="login/index.do">
		<div></div>
		<table style="margin: auto; width: 100%; height: 100%" border=0
			cellspacing=0 cellpadding=0>
			<tbody>
				<tr>
					<td height=150>&nbsp;</td>
				</tr>
				<tr style="text-align:center;height: 254px">
					<td>
						<div style="margin: 0px auto; width: 936px">
							<img style="display: block"
								src="<%=basePath%>icons/common/login/body_03.jpg" id ='aaaa'>
						</div>
						<div style="background-color: #278296">
							<div style="margin: 0px auto; width: 936px">
								<div
									style="background: url(<%=basePath%>icons/common/login/body_05.jpg) no-repeat; height: 155px">
									<div
										style="text-align: left; width: 265px; float: right; height: 125px; _height: 95px">
										<table border=0 cellspacing=0 cellpadding=0 width="100%">
											<tbody>
												<tr>
													<td style="height: 43px"><input id=username
														class=logininput type=text name=username required="true"
														value="${username}">&nbsp;<label
														style="color: red; font-size: 12"><c:if
																test="${usernameError}">用户名不存在</c:if></label></td>
												</tr>
												<tr>
													<td><input id=password class=logininput type=password
														name=password required="true" value="${password}">&nbsp;<label
														style="color: red; font-size: 12"><c:if
																test="${passwordError}">密码错误</c:if></label></td>
												</tr>
												<tr>
													<td style="height: 50px"><input id=checkcode
														maxlength="4" required="true" class=yzm size=8 type=text
														name=checkcode> <a style="text-align: center;"
														id="verifyClick" title="点击 刷新?" href="javascript:void(0);">
															<img style="width: 65px; height: 22px;" align="absmiddle"
															id="verifyCode" src="<%=basePath%>login/getRandomKey.do" />
													</a>&nbsp;<label style="color: red; font-size: 12">&nbsp;
															<c:if test="${checkcodeError}">验证码错误</c:if>

													</label></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div style="height: 1px; clear: both"></div>
									<div style="width: 380px; float: right; clear: both">
										<table border=0 cellspacing=0 cellpadding=0 width=300>
											<tbody>
												<tr>
													<td width=100 align=right><input
														style="border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px"
														id=btnlogin src="<%=basePath%>icons/common/login/btn1.jpg"
														type=image name=btnlogin></td>
													<td width=100 align=middle><input
														onclick="clearForm()"
														style="border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px"
														id=btnreset src="<%=basePath%>icons/common/login/btn2.jpg"
														type=image name=btnreset></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div style="margin: 0px auto; width: 936px">
							<img src="<%=basePath%>icons/common/login/body_06.jpg">
						</div>
					</td>
				</tr>
				<tr style="height: 30%">
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
