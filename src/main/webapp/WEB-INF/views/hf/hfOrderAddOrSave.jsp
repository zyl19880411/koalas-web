<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
    var orderAddOrSave = '${orderAddOrSave}';
    var id = '${id}';
    var loveSubject = '${loveSubject}';
	var gaokaoYear = '${gaokaoYear}';
	var backup = '${backup}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrderAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/order/hfOrderAddOrSave.css" type="text/css">
<form id="hforderFrom">
<table class="dataintable">

	<input id="hfid" name="hfid" type="hidden" value="${id}">
	<input id="cgaokaoYear" name="cgaokaoYear" type="hidden" value="${gaokaoYear}">
	<input id="cloveSubject" name="cloveSubject" type="hidden" value="${loveSubject}">
	<input id="cbackup" name="cbackup" type="hidden" value="${backup}">

	<tr>
		<td><i>学生姓名</i></td>
		<td><input id="hfusername" class="easyui-validatebox" type="text" name="hfusername" value="${studentName}" style="width: 90%"/></td>
		<td><i>家长电话</i></td>
		<td><input id="hfuserphone" class="easyui-validatebox" type="text" name="hfuserphone" value="${studentPhone}" style="width: 90%"/></td>
	</tr>
	<tr>
		<td><i>编号</i></td>
		<td><input id="hfstudentId" class="easyui-validatebox" type="text" name="hfstudentId" value="${studentId}" style="width: 90%"/></td>
		<td><i>高考年份</i></td>
		<td><input id="hfgaokaoYear"  data-options="editable:false" class="easyui-datebox"  type="text" name="hfgaokaoYear"   style="width: 90%"/></td>
	</tr>
	<tr>
		<td><i>意向课程</i></td>
		<td><input id="hflovesubject" type="text" name="hflovesubject"  style="width: 90%"/></td>
		<td><i>渠道</i></td>
		<td><input id="hfchannel" class="easyui-validatebox" type="text" name="hfchannel" value="${channel}" style="width: 90%"/></td>
	</tr>
	<tr >
		<td><i>备注</i></td>
		<td colspan="3"><textarea id="hftype_Remark" name ='hftype_Remark' style="height:100px;width:97.5%"></textarea></td>
	</tr>


</table>
</form>
