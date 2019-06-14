<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link id="themes" rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<script type="text/javascript" charset="UTF-8" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/common/login/index.js"></script>
</head>

<body class="easyui-layout">
	<div id='topDiv'
		data-options="noheader:true,region:'north',title:'欢迎光临安网沐泽科技有限公司后台',split:false,iconCls:'icon-add',collapsible:false"
		style="height: 100px;background-color:#e0ecff; 
		filter:'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')';
        -moz-background-size:100% 100%;
         background-size:100% 100%;">
         <div style="margin-left:91% ;margin-top:20px;" >
         <label style="color: red">皮肤</label>
        <select id="skin" class="easyui-combobox" name="skin" style="width:80px;" data-options="valueField:'id',textField:'text',editable:false">
         </select>
           <br>
           <a id='refish' href="javascript:void(0)" style="width:110px;" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:false">返回首页</a>
           <br>
           <a id='logout' href="javascript:void(0)" style="width:110px;" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:false">安全退出</a>
         </div>
		</div>
	<div
		data-options="noheader:true,region:'south',title:'South Title',split:false,collapsible:true"
		style="height: 30px;background-color:#e0ecff;">
		<p style="text-align: center;">北京安网沐泽科技有限公司 @CopyRight 1994-2015</p>
		</div>
	<div data-options="region:'west',split:false,border:false"
		style="width: 150px; overflow: auto;">
		<div id="menu" class="easyui-accordion"
			data-options="fit:true,border:false">
			
		</div>

	</div>
	<div data-options="region:'center',title:'信息管理',split:false,collapsible:false,noheader:true"
		style="padding: 0px; background: #eee;">
		<div id="tt" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true,border:false">
		</div>
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

