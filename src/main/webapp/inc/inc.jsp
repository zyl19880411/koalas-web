<%@ page contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="x-ua-compatible" content="IE=edge" />
<link rel="icon" href="<%=basePath%>icons\common\login\logo.ico" type="image/x-icon" />
<link rel="shortcut icon" href="<%=basePath%>icons\common\login\logo.ico" type="image/x-icon" />
<link rel="bookmark" href="<%=basePath%>icons\common\login\logo.ico" type="image/x-icon" />
<link id="themes" rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>js/common/json/json2.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>js/common/inc/inc.js"></script>

</head>
<body>
<input id="basePath" name="basePath" type="hidden" value="<%=basePath%>">
<input id="menuWidth" name="menuWidth" type="hidden" value="169">
</body>
</html>
