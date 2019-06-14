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
    var area = '${area}';
    var nj = '${nj}';
    var listenSubject = '${listenSubject}';
    var listenTime = '${listenTime}';
    var teacher = '${teacher}';
    var teacherPhone = '${teacherPhone}';
    var teacherInfo = '${teacherInfo}';
    var listener = '${orderAddOrSave}';

</script>
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrderListen.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/order/hfOrderAddOrSave.css" type="text/css">
<form id="hforderListenFrom">
<table class="dataintable">

	<input id="orderListenId" name="orderListenId" type="hidden" value="${id}">

	<tr>
		<td><i>学生地址</i></td>
		<td><input id="hflistenArea" type="text" name="hflistenArea" value="${area}"  style="width: 90%"/></td>
		<td><i>学生年级</i></td>
		<td><input id="hflistennj" type="text" name="hflistennj" style="width: 90%"/></td>
	</tr>

	<tr>
		<td><i>试听课程</i></td>
		<td><input id="hflistenSubject" type="text" name="hflistenSubject"  style="width: 90%"/></td>
		<td><i>试听时间</i></td>
		<td><input id="hflistenTime" class="easyui-datetimebox" type="text" name="hflistenTime" style="width: 90%"/></td>
	</tr>

	<tr>
		<td><i>授课老师</i></td>
		<td><input id="hfteacherName" class="easyui-validatebox" type="text" name="hfteacherName"  value="${teacher}" style="width: 90%"/></td>
		<td><i>授课老师电话</i></td>
		<td><input id="hfteacherPhone" class="easyui-validatebox" type="text" name="hfteacherPhone"  value="${teacherPhone}" style="width: 90%"/></td>
	</tr>

	<tr >
		<td><i>授课老师详情</i></td>
		<td colspan="3"><textarea id="hfteacherInfo" name ='hfteacherInfo' style="height:100px;width:97.5%"></textarea></td>
	</tr>

</table>
</form>
