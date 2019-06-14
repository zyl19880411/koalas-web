<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>404</title>
<link rel="stylesheet" type="text/css" href="css/common/error/cmstop-error.css">
</head>
<body class="body-bg">
	<div class="main">
		<p class="title">您想要的界面找不到了</p>
		<a href="<%=basePath%>login/userLogin.do" class="btn">返回主页</a>
	</div>
</body>
</html>