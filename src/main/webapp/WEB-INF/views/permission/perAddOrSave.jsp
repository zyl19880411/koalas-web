<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
   var elementType = '${elementType}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/permission/perAddOrSave.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/common/permission/perAddOrSave.css" type="text/css"> 

<div style="width:90%; height:70%; padding: 10px 10px;">
<div class="ftitle">
<c:choose>
		<c:when test="${AddOrSave=='add'}">
			添加菜单
		</c:when>
		<c:otherwise>
			修改菜单
		</c:otherwise>
</c:choose>
</div>

<form id="perADDFrom" method="post">
   <input id="elementType" name="elementType" type="hidden" value="${elementType}">
   <input id="permissionID" name="permissionID" type="hidden" value="${permissionID}">
 
    <div class="fitem">
		<label> 菜单名称 </label> 
		<input id='perName' name="perName" class="easyui-validatebox" value="${perName}" />
		<label id='errorLabelperName' class='errorLabel' style="color: red; font-size: 12">*菜单名称错误 </label></td>
	</div>
	
	<div class="fitem">
		<label> 菜单图片</label> 
		<input id='perIcon' name="perIcon" class="easyui-validatebox" value="${perIcon}" />
		<a id="selectIcon" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'"></a>
		<label id='errorLabeperIcon' class='errorLabel' style="color: red; font-size: 12">*菜单图片错误 </label></td>
	</div>
 
   <c:if test="${elementType=='2'}">
      <div class="fitem">
		<label> 菜单路径</label> 
		<input id='perUrl' name="perUrl" class="easyui-validatebox" value="${perUrl}" />
		<label id='errorLabeperUrl' class='errorLabel' style="color: red; font-size: 12">*菜单路径错误 </label></td>
	  </div>
   </c:if>

    <div class="fitem">
		<label> 菜单说明</label> 
		<input id='perRemark' name="perRemark" class="easyui-validatebox" value="${perRemark}" />
		<label id='errorLabeperRemark' class='errorLabel' style="color: red; font-size: 12">*菜单说明错误 </label></td>
	</div>

</form>

<!-- 业务对话框 -->
<div id='icondiv' name='icondiv'>
	<div id='icondialog' name='icondialog'>
	</div>
</div>

</div>

