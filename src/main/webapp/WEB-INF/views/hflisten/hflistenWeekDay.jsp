<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/hflisten/hflistenWeekDay.js"></script>

<!-- table页面 -->
<table id='hflistenWeekDayTable'>
</table>

<!-- table工具条 -->
<div id="hflistenWeekDayTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
	<fieldset style="padding: 2px; margin: 2px; color: #333; border: #06c solid 1px;">
		<legend style="color: #06c; font-weight: 800; background: #fff; border: #b6b6b6 solid 1px; padding: 3px 6px;">信息筛选</legend>

		<div style="margin-bottom:10px">

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">编号:</label>
			<input for="lisWeekDayname" id='hflistenstudentIdWeekDay' type="text" name="hflistenstudentIdWeekDay"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">姓名:</label>
			<input for="lisWeekDayname" id='hflistenstudentNameWeekDay' type="text" name="hflistenstudentNameWeekDay"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">手机号码:</label>
			<input for="lisWeekDayname" id='hflistenstudentPhoneWeekDay' name='hflistenstudentPhoneWeekDay' type="text" class="easyui-numberbox" value="" data-options="min:0" style="margin-right: 10px;width:100px" >

			<input for="lisWeekDayname" type="checkbox" style="margin-left: 50px;margin-top: 10px;" name="hflistenhforderismeWeekDay" id="hflistenhforderismeWeekDay" value="isme"/>只看自己

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">跟进人:</label>
			<input for="lisWeekDayname" id='hflistendocNameWeekDay' type="text" name="hflistendocNameWeekDay"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">销售组别:</label>
			<input for="lisWeekDayname" id='hflistenorgNameWeekDay' type="text" name="hflistenorgNameWeekDay"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">邀约开始日期:</label>
			<input for="lisWeekDayname" id='hflistenOrderctime_fromWeekDay' type="text" name="hflistenOrderctime_fromWeekDay"  data-options="editable:false,width:100" style="margin-right: 10px;" />

			<label for="lisWeekDayname" style="margin-top: 10px;margin-left: 0px;width:110px;display:inline-block;text-align: right">邀约结束日期:</label>
			<input for="lisWeekDayname" id='hflistenOrderctime_toWeekDay' type="text" name="hflistenOrderctime_toWeekDay"  data-options="editable:false,width:100" style="margin-right:10px" />


		</div>

	</fieldset>

	<div style="margin-top:5px; margin-left: 10px">

		<c:forEach items="${list}" var="item">
				<shiro:hasPermission name="${item.code}">
					<a id='${item.permission_id}' href="javascript:void(0);" class="easyui-linkbutton" plain=true iconCls="${item.icon}">${item.name}</a>
					<span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
				</shiro:hasPermission>
		</c:forEach>
	</div>
</div>