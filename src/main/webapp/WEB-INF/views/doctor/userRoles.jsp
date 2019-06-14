<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
var doc_id = '${doc_id}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/doctor/userRoles.js"></script>

<!-- table页面 -->
<table id='user_roles_table'>
</table>
