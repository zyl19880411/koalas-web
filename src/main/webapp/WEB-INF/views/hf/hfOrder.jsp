<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrder.js"></script>

<!-- table页面 -->
<table id='hfOrderTable'>
</table>

<!-- table工具条 -->
<div id="hfOrderTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
	<fieldset style="padding: 2px; margin: 2px; color: #333; border: #06c solid 1px;">
		<legend style="color: #06c; font-weight: 800; background: #fff; border: #b6b6b6 solid 1px; padding: 3px 6px;">信息筛选</legend>

		<div style="margin-bottom:10px">

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">编号:</label>
			<input id='studentId' type="text" name="studentId"  data-options="required:true" style="margin-right: 10px;margin-bottom: 20px;width:100px" />

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right"">姓名:</label>
			<input id='studentName' type="text" name="studentName"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">手机号码:</label>
			<input id='studentPhone' name='studentPhone' type="text" class="easyui-numberbox" value="" data-options="min:0" style="margin-right: 10px;width:100px" >

			<input type="checkbox" style="margin-left: 50px;margin-top: 10px;" name="hforderisme" id="hforderisme" value="isme"/>只看自己

			<c:forEach items="${list}" var="item">
				<c:if test="${item.name == '查询'}">
					<shiro:hasPermission name="${item.code}">
						<a id='${item.permission_id}' href="javascript:void(0);" style="margin-left: 20px;" class="easyui-linkbutton" iconCls="${item.icon}">${item.name}</a>
					</shiro:hasPermission>
				</c:if>
			</c:forEach>

			<br/>

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">跟进人:</label>
			<input id='docName' type="text" name="docName"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">销售组别:</label>
			<input id='orgName' type="text" name="orgName"  data-options="required:true" style="margin-right: 10px;width:100px" />

            <label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right"">录入开始日期:</label>
            <input id='ctime_from' type="text" name="ctime_from"  data-options="editable:false,width:100" style="margin-right: 10px;" />

            <label for="name" style="margin-left: 0px;width:110px;display:inline-block;text-align: right">录入结束日期:</label>
            <input id='ctime_to' type="text" name="ctime_to"  data-options="editable:false,width:100" style="margin-right:10px" />



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
<div id='hfOrderdiv' name='hfOrderdiv'>
	<div id='hfOrderdialog' name='hfOrderdialog'>
	</div>
</div>

<!-- 试听 -->
<div id='hfOrderLisdiv' name='hfOrderLisdiv'>
	<div id='hfOrderLisdialog' name='hfOrderLisdialog'>
	</div>
</div>

<!-- 成单 -->
<div id='hfOrdersuccessdiv' name='hfOrdersuccessdiv'>
	<div id='hfOrdersuccessdialog' name='hfOrdersuccessdialog'>
	</div>
</div>

<!-- 转介绍 -->
<div id='hfOrderintroductiondiv' name='hfOrderintroductiondiv'>
	<div id='hfOrderintroductiondialog' name='hfOrderintroductiondialog'>
	</div>
</div>

<!-- 无效名单 -->
<div id='hfOrdererrordiv' name='hfOrdererrordiv'>
	<div id='hfOrdererrordialog' name='hfOrdererrordialog'>
	</div>
</div>