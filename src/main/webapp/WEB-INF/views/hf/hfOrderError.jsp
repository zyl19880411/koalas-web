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
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrderError.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/order/hfOrderAddOrSave.css" type="text/css">
<form id="hforderErrorFrom">
    <input id="orderErrorId" name="orderErrorId" type="hidden" value="${id}">
<table class="dataintable">

	<tr>
        <td style="width: 40%;"><i>无效类型</i></td>
        <td style="width: 60%";><input id="hfErrorType" type="text" name="hfErrorType"  style="width: 90%;"/></td>
	</tr>

</table>
</form>
