<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="/inc/inc.jsp"></jsp:include>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<title>koalas-web join us</title>

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common/login/newlogin.css">
<script type="text/javascript" src="<%=basePath%>js/common/login/login.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->

<script type="text/javascript">
	$(document).ready(function() {

		var loginBody = $("#loginBody").length;
		if(loginBody==1){
			location.href="<%=basePath%>login/userLogin.do";
		}

        if('${usernameError}'){
            $.messager.alert('提示消息','账号不存在!','warning');
            return;
        }
        if('${passwordError}'){
            $.messager.alert('提示消息','密码错误!','warning');
            return;
        }
        if('${checkcodeError}'){
            $.messager.alert('提示消息','验证码错误!','warning');
            return;
        }
	})
</script>

</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h1>koalas-web</h1>
						<form id="ff" action="login/index.do" name="f" method="post" >
							<div class="input_outer">
								<span class="u_user"></span>
								<input id="username" name="username" value="${username}" class="text" style="color: #000000 !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input id="password" name="password" value="${password}" class="text" style="color: #000000 !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="input_outer">
								<span class="us_chcekcode"></span>
								<input id="checkcode" name="checkcode" class="text" style="color: #000000 !important; position:absolute; z-index:100;"value="" type="text" placeholder="请输入验证码">
								<a style="text-align: center;;position: absolute;left: 350px;top: 0px;" id="verifyClick" title="点击 刷新?" href="javascript:void(0);">
								<img style="width: 100px; height: 40px;" align="absmiddle" id="verifyCode" src="<%=basePath%>login/getRandomKey.do" />
							</div>
							<div class="mb2"><a class="act-but submit" id="btnlogin" name="btnlogin" href="javascript:void(0);" style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="<%=basePath%>js/common/login/TweenLite.min.js"></script>
		<script src="<%=basePath%>js/common/login/EasePack.min.js"></script>
		<script src="<%=basePath%>js/common/login/rAF.js"></script>
		<script src="<%=basePath%>js/common/login/demo-1.js"></script>

	</body>
</html>