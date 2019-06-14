<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/hf/hferrorphone.js"></script>

<!-- table页面 -->
<table id='hferrorphoneTable'>
</table>

<!-- table工具条 -->
<div id="hferrorphoneTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
	<fieldset style="padding: 2px; margin: 2px; color: #333; border: #06c solid 1px;">
		<legend style="color: #06c; font-weight: 800; background: #fff; border: #b6b6b6 solid 1px; padding: 3px 6px;">信息筛选</legend>

		<div style="margin-bottom: 10px;">

			<label for="errorphonename" style="margin-top: 10px;;margin-left: 0px;width:100px;display:inline-block;text-align: right">编号:</label>
			<input for="errorphonename" id='studentIderrorphone' type="text" name="studentIderrorphone"  data-options="required:true" style="width:100px" />

			<label for="errorphonename" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">姓名:</label>
			<input for="errorphonename" id='studentNameerrorphone' type="text" name="studentNameerrorphone"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="errorphonename" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">手机号码:</label>
			<input for="errorphonename" id='studentPhoneerrorphone' name='studentPhoneerrorphone' type="text" class="easyui-numberbox" value="" data-options="min:0" style="margin-right: 10px;width:100px" >

			<input for="errorphonename" type="checkbox" style="margin-left: 50px;margin-top: 10px;" name="hforderismeerrorphone" id="hforderismeerrorphone" value="isme"/>只看自己

			<br/>

			<label for="nameerrorphone" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">跟进人:</label>
			<input for="errorphonename" id='docNameerrorphone' type="text" name="docNameerrorphone"  data-options="required:true" style="margin-right: 10px;width:100px" />

			<label for="nameerrorphone" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">销售组别:</label>
			<input for="errorphonename" id='orgNameerrorphone' type="text" name="orgNameerrorphone"  data-options="required:true" style="margin-right: 10px;width:100px" />

            <label for="nameerrorphone" style="margin-top: 10px;margin-left: 0px;width:100px;display:inline-block;text-align: right">录入开始日期:</label>
            <input for="errorphonename" id='ctime_fromerrorphone' type="text" name="ctime_fromerrorphone"  data-options="editable:false,width:100" style="margin-right: 10px;" />

            <label for="nameerrorphone" style="margin-top: 10px;margin-left: 0px;width:110px;display:inline-block;text-align: right">录入结束日期:</label>
            <input for="errorphonename" id='ctime_toerrorphone' type="text" name="ctime_toerrorphone"  data-options="editable:false,width:100" style="margin-right:10px" />



		</div>

	</fieldset>

	<div style="">

		<c:forEach items="${list}" var="item">
				<shiro:hasPermission name="${item.code}">
					<a id='${item.permission_id}' href="javascript:void(0);" class="easyui-linkbutton" plain=true iconCls="${item.icon}">${item.name}</a>
					<span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
				</shiro:hasPermission>
		</c:forEach>
	</div>
</div>