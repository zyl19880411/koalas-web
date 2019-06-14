<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
  var parentid = '${parentid}';
  var org_id = '${org_id}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/org/orgPerrmission.js"></script>

<!-- table页面 -->
<table id='org_perrmission'>
</table>
