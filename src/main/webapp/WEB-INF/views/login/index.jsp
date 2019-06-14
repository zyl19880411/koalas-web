<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>后台管理页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="/inc/inc.jsp"></jsp:include>
<script type="text/javascript">
var userName = '${LoginUserName}';
</script>
<script type="text/javascript" src="<%=basePath%>js/common/login/index.js"></script>
</head>

<body class="easyui-layout" id="loginBody">
	<div id='topDiv'
		data-options="noheader:true,region:'north',title:'欢迎光临koalas-web',split:false,iconCls:'icon-add',collapsible:false"
		style="height: 50px;background-color:#e0ecff;text-align: right; background: url('<%=basePath%>icons/common/login/iconp.png');
		filter:'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')';
        -moz-background-size:100% 100%;
         background-size:100% 100%;">
         <div style="margin-top:15px;margin-right: 20px;" >
         <label style="color: #333;">皮肤</label>
        <select id="skin" class="easyui-combobox" name="skin" style="width:80px;" data-options="valueField:'id',textField:'text',editable:false">
         </select>
			 <a id='allsk' href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-arrow_in',plain:true">全屏操作</a>
			 <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

			 <a id='refish' href="<%=basePath %>login/index.do" class="easyui-linkbutton" data-options="iconCls:'icon-arrow_undo',plain:true">回到首页</a>
			 <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

			 <a id='logout' href="<%=basePath %>login/logout.do" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">安全退出</a>
         </div>


		</div>
	<div
		data-options="noheader:true,region:'south',title:'South Title',split:false,collapsible:true"
		style="height: 28px;background-color:#e0ecff;text-align: center;">
		koalas-web @CopyRight 2019-作者张玉龙-商用请联系
		</div>
	<div data-options="region:'west',title:'登陆者: ${LoginUserName}',split:false,border:false"
		style="width: 169px; overflow: auto;background: url('<%=basePath%>icons/common/login/btnindex.jpg');">
		<div id="menu" class="easyui-accordion"
			data-options="multiple:true,fit:false,border:false">
			<!-- <div title="人员管理" data-options="iconCls:'icon-feed_key',border:false" style="overflow: auto; padding: 10px;">
				<a name='btn' id="btn" tabtitle="测试按钮1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'" style="width:98%;margin-bottom:3px;text-align: left;">测试按钮</a>
			</div> -->
			<c:forEach var="item" items="${menu}" varStatus="s">
			   <!-- 一级菜单 -->
			   <c:if test="${item.elementType==1}">
			       <c:if test="${!s.first}">
			          </div>
			       </c:if>
			      <shiro:hasPermission name="${item.code}">
			         <div title="${item.name}" data-options="iconCls:'${item.icon}',border:false,collapsed:false" style="overflow: auto; padding: 10px;background: url('<%=basePath%>icons/common/login/index.jpg');">
			      </shiro:hasPermission>
			   </c:if>

			   <!-- 二级菜单 -->
			   <c:if test="${item.elementType==2}">
			      <shiro:hasPermission name="${item.code}">
			        <a name='btn' url="${item.url}" tabtitle="${item.name}" icon='${item.icon}' class="easyui-linkbutton" data-options="plain:true,iconCls:'${item.icon}'" style="width:120px;margin-bottom:3px;text-align: left;">${item.name}</a>
			       </shiro:hasPermission>
			   </c:if>
               
               <c:if test="${s.last}">
			          </div>
			   </c:if>
			</c:forEach>
		</div>

	</div>
	<div data-options="region:'center',title:'信息管理',split:false,collapsible:false,noheader:true"
		style="padding: 0px; background: url('<%=basePath%>icons/common/login/index.jpg');
		filter:'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')';
        -moz-background-size:100% 100%;
         background-size:100% 100%;">
		<div id="tt" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true,border:false">

		</div>
   </div>

	<div id="p-tools">
		<a href="javascript:void(0)" class="icon-mini-refresh" onclick="alert('refresh')"></a>
	</div>

	  <div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose" name ='close'>关闭</div>
		<div id="mm-tabcloseall" name ='closeAll'>全部关闭</div>
		<div id="mm-tabcloseother" name ='closeOther'>除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright" name ='closeRight'>当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft" name ='closeLeft'>当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit" name ='Exit'>退出</div>
	</div>
 
</body>

</html>
