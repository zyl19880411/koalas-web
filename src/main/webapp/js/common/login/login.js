$(document).ready(function() {

	$("#btnlogin").click(function(){
		//md5加密
		$('#ff').submit();
	})
	
	$("#btnreset").click(function(){
		$('#ff').form('clear');
	})
	
	
	//随机生成验证码
	$("#verifyClick").bind('click', function() {
		var url = 'login/getRandomKey.do?verifyCode=' + Math.random();
		//$('#verifyCode').attr('src',url);
		document.getElementById('verifyCode').setAttribute('src', url);
	});

	//初始化焦点
	$('#username').focus();

	/******************************拦截表单提交事件开始**********************************/
	$('#ff').submit(function() {

		//账号不为空
		if ($.trim($('#username').val()) == '') {
            $.messager.alert('提示消息','请填写账号!','warning');
            $('#username').focus();
            return false;
		}

		//密码不为空
		if ($.trim($('#password').val()) == '') {
            $.messager.alert('提示消息','请填写密码!','warning');
            $('#password').focus();
            return false;
		}

		//验证码长度
		if ($.trim($('#checkcode').val()).length != 4) {
            $.messager.alert('提示消息','请填写正确的验证码!','warning');
			$('#checkcode').focus();
			return false;
		}
		return true;
	})

	/******************************拦截表单提交事件结束**********************************/

	//按回车
    $("#checkcode").keypress(function(e) {
        // 回车键事件
        if(e.which == 13) {
            $("#btnlogin").click();
        }
    });


});