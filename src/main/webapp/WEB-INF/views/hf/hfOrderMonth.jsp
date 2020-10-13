<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/hf/hfOrderMonth.js"></script>

<!-- table页面 -->
<table id='hfOrderMonthTable'>
</table>

<!-- table工具条 -->
<div id="hfOrderMonthTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
	<fieldset style="padding: 2px; margin: 2px; color: #333; border: #06c solid 1px;">
		<legend style="color: #06c; font-weight: 800; background: #fff; border: #b6b6b6 solid 1px; padding: 3px 6px;">信息筛选</legend>

		<div style="margin-bottom:10px">

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">编号:</label>
			<input id='studentIdMonth' type="text" name="studentIdMonth"  data-options="required:true" style="margin-right: 10px;margin-bottom: 20px;width:100px" />

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right"">姓名:</label>
			<input id='studentNameMonth' type="text" name="studentNameMonth"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">手机号码:</label>
			<input id='studentPhoneMonth' name='studentPhoneMonth' type="text" class="easyui-numberbox" value="" data-options="min:0" style="margin-right: 10px;width:100px" >

			<input type="checkbox" style="margin-left: 50px;margin-top: 10px;" name="hforderismeMonth" id="hforderismeMonth" value="isme"/>只看自己

			<c:forEach items="${list}" var="item">
					<shiro:hasPermission name="${item.code}">
						<a id='${item.permission_id}' href="javascript:void(0);" style="margin-left: 20px;" class="easyui-linkbutton" iconCls="${item.icon}">${item.name}</a>
					</shiro:hasPermission>
			</c:forEach>
			<br/>

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">跟进人:</label>
			<input id='docNameMonth' type="text" name="docNameMonth"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="name" style="margin-left: 0px;width:100px;display:inline-block;text-align: right">销售组别:</label>
			<input id='orgNameMonth' type="text" name="orgNameMonth"  data-options="required:true" style="margin-right: 10px;width:100px" />

		</div>

	</fieldset>

</div>