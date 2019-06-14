<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/common/doctor/user.js"></script>

<!-- table页面 -->
<table id='userTable'>
</table>

<!-- table工具条 -->
<div id="userTableTB" style="padding: 2px; height: auto; background-color: #F5FFFA;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
	<fieldset style="color: #333; border: #06c solid 1px;">
		<legend style="color: #06c; font-weight: 800; background: #fff; border: #b6b6b6 solid 1px; padding: 3px 6px;">查询信息</legend>
		
		<div style="margin: 10px">
			 <label for="name" style="margin-left: 20px;">姓名:</label>
			 <input id='userName' type="text" name="userName"  data-options="required:true" style="margin-right: 10px;" /> 
			 
			 <label for="name" style="margin-left: 20px;">手机号码:</label> 
			 <input id='tel' name='tel' type="text" class="easyui-numberbox" value="" data-options="min:0" style="margin-right: 10px;" >

			 <c:forEach items="${list}" var="item">
			   <c:if test="${item.name == '查询'}">
				   <shiro:hasPermission name="${item.code}">
				     <a id='${item.permission_id}' href="javascript:void(0);" class="easyui-linkbutton" iconCls="${item.icon}">${item.name}</a>
				   </shiro:hasPermission>
			   </c:if>
			 </c:forEach>
			 
		</div>

	</fieldset>
	
	<div style="margin-top:5px; margin-left:5px">
	
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
<div id='userdiv' name='userdiv'>
	<div id='userdialog' name='userdialog'>
	</div>
</div>
 