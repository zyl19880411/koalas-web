<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(200);%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>403 - 用户权限不足</title>
</head>

<body>
	<h2>403 - 用户权限不足</h2>
	<a href="<%=basePath%>login/userLogin.do">点击我返回</a>
</body>
</html>