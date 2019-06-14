<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/hflisten/hflisten.js"></script>

<!-- table页面 -->
<table id='hflistenTable'>
</table>

<!-- table工具条 -->
<div id="hflistenTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
	<fieldset style="padding: 2px; margin: 2px; color: #333; border: #06c solid 1px;">
		<legend style="color: #06c; font-weight: 800; background: #fff; border: #b6b6b6 solid 1px; padding: 3px 6px;">信息筛选</legend>

		<div style="margin-bottom:10px">

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">编号:</label>
			<input for="lisname" id='hflistenstudentId' type="text" name="hflistenstudentId"  data-options="required:true" style="margin-right: 10px;width:100px;margin-top: 10px;" />

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">姓名:</label>
			<input for="lisname" id='hflistenstudentName' type="text" name="hflistenstudentName"  data-options="required:true" style="margin-top: 10px;margin-right: 10px;width:100px" />

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">手机号码:</label>
			<input for="lisname" id='hflistenstudentPhone' name='hflistenstudentPhone' type="text" class="easyui-numberbox" value="" data-options="min:0" style="margin-top: 10px;margin-right: 10px;width:100px" >

			<input for="lisname" type="checkbox" style="margin-top: 10px;margin-left: 50px;margin-top: 10px;" name="hflistenhforderisme" id="hflistenhforderisme" value="isme"/>只看自己

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">跟进人:</label>
			<input for="lisname" id='hflistendocName' type="text" name="hflistendocName"  data-options="required:true" style="margin-top: 10px;margin-right: 10px;width:100px" />

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">销售组别:</label>
			<input for="lisname" id='hflistenorgName' type="text" name="hflistenorgName"  data-options="required:true" style="margin-top: 10px;margin-right: 10px;width:100px" />

            <label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">邀约开始日期:</label>
            <input for="lisname" id='hflistenOrderctime_from' type="text" name="hflistenOrderctime_from"  data-options="editable:false,width:100" style="margin-top: 10px;margin-right: 10px;" />

            <label for="lisname" style="margin-top: 10px;margin-left: 0px;width:110px;display:inline-block;text-align: right">邀约结束日期:</label>
            <input for="lisname" id='hflistenOrderctime_to' type="text" name="hflistenOrderctime_to"  data-options="editable:false,width:100" style="margin-top: 10px;margin-right:10px" />

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">试听开始日期:</label>
			<input for="lisname" id='hflistenctime_from' type="text" name="hflistenctime_from"  data-options="editable:false,width:100" style="margin-top: 10px;margin-right: 10px;" />

			<label for="lisname" style="margin-top: 10px;margin-left: 0px;width:110px;display:inline-block;text-align: right">试听结束日期:</label>
			<input for="lisname" id='hflistenctime_to' type="text" name="hflistenctime_to"  data-options="editable:false,width:100" style="margin-top: 10px;margin-right:10px" />

			<c:forEach items="${list}" var="item">
				<c:if test="${item.name == '查询'}">
					<shiro:hasPermission name="${item.code}">
						<a id='${item.permission_id}' href="javascript:void(0);" style="margin-left: 20px;" class="easyui-linkbutton" iconCls="${item.icon}">${item.name}</a>
					</shiro:hasPermission>
				</c:if>
			</c:forEach>

		</div>

	</fieldset>

	<div style="margin-top:5px; margin-left: 10px">

		<c:forEach items="${list}" var="item">
			<c:if test="${item.name != '查询'}">
				<shiro:hasPermission name="${item.code}">
					<a id='${item.permission_id}' href="javascript:void(0);" class="easyui-linkbutton" plain=true iconCls="${item.icon}">${item.name}</a>
					<span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
				</shiro:hasPermission>
			</c:if>
		</c:forEach>
	</div>
</div>


<!-- 业务对话框 -->
<div id='hfLisUpdatediv' name='hfLisUpdatediv'>
	<div id='hfLisUpdatedialog' name='hfLisUpdatedialog'>
	</div>
</div>
