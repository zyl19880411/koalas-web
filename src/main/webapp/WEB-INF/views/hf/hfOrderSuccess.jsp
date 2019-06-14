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
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrderSuccess.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/order/hfOrderAddOrSave.css" type="text/css">
<form id="hforderSuccessFrom">
<table class="dataintable">

	<input id="orderSuccessId" name="orderSuccessId" type="hidden" value="${id}">

	<tr>
		<td><i>试听关单时间</i></td>
		<td><input id="hfcloseVTime" class="easyui-datetimebox" type="text" name="hfcloseVTime"  style="width: 90%"/></td>
		<td><i>合同编号</i></td>
		<td><input id="hfcontractNumbe" type="text" name="hfcontractNumbe" style="width: 90%"/></td>
	</tr>

	<tr>
		<td><i>成单课时</i></td>
		<td><input id="hfclassHour" type="text" name="hfclassHour"  style="width: 85%;margin-top: 100px;"/></td>
		<td><i>成单金额</i></td>
		<td><input id="hforderMoney" type="text" name="hforderMoney" style="width: 90%"/></td>
	</tr>

	<tr>
		<td><i>奖品</i></td>
		<td><input id="hfgift" type="text" name="hfgift"  style="width: 90%"/></td>
		<td><i>支付方式</i></td>
		<td><input id="hfpayStatus" type="text" name="hfpayStatus" style="width: 90%"/></td>
	</tr>
	<tr>
		<td><i>支付时间</i></td>
		<td><input id="hfpayTime" class="easyui-datetimebox" type="text" name="hfpayTime"  style="width: 90%"/></td>
		<td><i></i></td>
		<td></td>
	</tr>
</table>
</form>
