<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
    var id = '${id}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrderintroduction.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/order/hfOrderAddOrSave.css" type="text/css">
<form id="hforderintroductionFrom">
<table class="dataintable">

	<input id="orderintroductionId" name="orderintroductionId" type="hidden" value="${id}">

	<tr>
		<td><i>转介绍类型</i></td>
		<td><input id="hfintroductionType" type="text" name="hfintroductionType"  style="width: 95%;margin-top: 100px;"/></td>
	</tr>
	<tr>
		<td><i>转介绍人</i></td>
		<td><input id="hfintroductionName" type="text" name="hfintroductionName" style="width: 90%"/></td>
	</tr>

</table>
</form>
