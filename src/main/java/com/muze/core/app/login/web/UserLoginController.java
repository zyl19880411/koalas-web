package com.muze.core.app.login.web;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.muze.core.app.login.model.LoginModel;
import com.muze.core.app.login.model.UserModel;
import com.muze.core.app.login.service.UserLoginService;
import com.muze.core.app.utils.ConstantUtil;
import com.muze.core.app.utils.PageURLUtil;
import com.muze.core.app.utils.VerifyCode;

/**
 * *********************基本信息说明********************************
 * 类名        :UserLoginController.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :用户登录，退出获取验证码
 * 创建时间 :2015年12月4日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月4日
 ************************主要方法说明********************************
 * 1、login:登录后页面跳转
 * 2、loginIndex:根据用户登录信息对登录内容进行认证
 * 3、logout:退出
 * 4、unauthorized:无权限跳转页面
 * 5、getRandomKey获取随机验证码
 *******************************************************************
 */
@Controller
@RequestMapping("/login")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :login
	 * 方法说明 :登录页面跳转
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、request:消息头
	 * 2、response:相应头
	 * 3、model:表单参数对象
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、判断是否验证，若没有验证泽转到登录页面
	 * 2、如果验证转向到index页面
	 *******************************************************************
	 */
	@RequestMapping("/userLogin")
	public String login(HttpServletRequest request,HttpServletResponse response,Map<String,Object> model) throws Exception{
		Subject subject = SecurityUtils.getSubject();
		//是否验证
		if(subject.isAuthenticated()||subject.isRemembered()){
			Session session = subject.getSession();
			UserModel userDto = (UserModel) session.getAttribute("user");
			//获取菜单信息
			List<LoginModel> loginDto = userLoginService.getUserInfo(userDto.getUserCode());
			model.put("menu", loginDto);
			model.put("LoginUserName",userDto.getUserName());
			return PageURLUtil.login.INDEX;
		} 
		return PageURLUtil.login.USER_LOGIN;
	}

	/**
	 * *********************基本信息说明********************************
	 * 方法名     :loginIndex
	 * 方法说明 :index页面跳转
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、request:消息头
	 * 2、userName:账号
	 * 3、password:密码
	 * 4、checkcode:验证码
	 * 5、model:表单参数对象
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、判断账号密码验证码是否是空，如果为空则转向登录页面
	 * 2、验证码验证，若验证出错则转向登录页面
	 * 3、调用shrio的login来转向身份验证
	 * 4、获取菜单信息，跳转到主页面
	 *******************************************************************
	 */
	@RequestMapping("/index")
	public String loginIndex(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="username",required=false)  String userName,
			@RequestParam(value="password",required=false)  String password,
			@RequestParam(value="checkcode",required=false)  String checkcode,
			Map<String,Object> model) throws Exception{
		
		if(userName==null || password==null || checkcode==null){
			return PageURLUtil.login.FORWARD_LOGIN;
		}

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		//获取验证码验
		String sessionCode = (String) session.getAttribute(VerifyCode.VERIFY_TYPE_COMMENT);
		if(sessionCode==null){
			return PageURLUtil.login.FORWARD_LOGIN;
		}
		
		//验证码验证
		if(!checkcode.toLowerCase().equals(sessionCode.toLowerCase())){
			model.put("checkcodeError",true);
			model.put("password",password);
			model.put("username",userName);
			return PageURLUtil.login.FORWARD_LOGIN;
		}
		
		//登录验证
		try {
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
			//usernamePasswordToken.setRememberMe(true);
			SecurityUtils.getSubject().login(usernamePasswordToken);
			session.setAttribute(ConstantUtil.LOGIN_USER, userName);
			List<LoginModel> loginDto = userLoginService.getUserInfo(userName);
			model.put("menu", loginDto);
		} catch (UnknownAccountException e) {//账号不存在
			model.put("usernameError",true);
			System.out.println("账号不存在");
			return PageURLUtil.login.FORWARD_LOGIN;
		} catch(IncorrectCredentialsException e){ //密码错误
			model.put("passwordError",true);
			System.out.println("密码错误");
			return PageURLUtil.login.FORWARD_LOGIN;
		} 
		UserModel userDto = (UserModel) session.getAttribute("user");
		model.put("LoginUserName",userDto.getUserName());
		return PageURLUtil.login.INDEX;
	}

	/**
	 * *********************基本信息说明********************************
	 * 方法名     :logout
	 * 方法说明 :退出
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、request:消息头
	 * 2、response:相应头
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、退出，注销登录状态
	 * 2、返回登录页面
	 *******************************************************************
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		// 使用权限管理工具进行用户的退出，注销登录
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.removeAttribute(ConstantUtil.LOGIN_USER);
		SecurityUtils.getSubject().logout();
		return PageURLUtil.login.REDIRECT_LOGIN;
	}
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :unauthorized
	 * 方法说明 :无权限跳转的路径
	 * 反回类型 :String
	 * 方法参数 :
	 * 1、none
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、跳转到无权限路径页面
	 *******************************************************************
	 */
	@RequestMapping("/unauthorized")
	public String unauthorized(){
	 
		return PageURLUtil.error.UNAUTHORIZED;
	}
	
	/**
	 * *********************基本信息说明********************************
	 * 方法名     :getRandomKey
	 * 方法说明 :获取随机验证码并且返回到登录页面
	 * 反回类型 :void
	 * 方法参数 :
	 * 1、request:消息头
	 * 2、response:响应头
	 * 创建时间 :2015年12月10日
	 * 作         者:张玉龙
	 * 版         本:v1
	 ************************修改历史***********************************
	 * 1、none
	 * 修改人    :张玉龙
	 * 修改时间:2015年12月10日
	 ************************方法功能说明********************************
	 * 1、生成随机验证码图片放入session并且返回给响应对象
	 * 2、将图片返回给前台页面
	 *******************************************************************
	 */
	@RequestMapping("/getRandomKey")
	public void getRandomKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 生成验证码，写入用户session
		String verifyCode = VerifyCode.generateTextCode(
				VerifyCode.TYPE_ALL_MIXED, 4, "null");
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute(VerifyCode.VERIFY_TYPE_COMMENT,
				verifyCode);
		System.out.println("verifyCode=" + verifyCode);
		// 输出验证码给客户端
		response.setContentType("image/jpeg");
		/*
		 * textCode 文本验证码 width 图片宽度 height 图片高度 interLine 图片中干扰线的条数
		 * randomLocation 每个字符的高低位置是否随机 backColor 图片颜色，若为null，则采用随机颜色 f
		 * oreColor字体颜色，若为null，则采用随机颜色 lineColor 干扰线颜色，若为null，则采用随机颜色
		 */
		BufferedImage bim = VerifyCode.generateImageCode(verifyCode, 100, 40, 8,
				true, Color.WHITE, Color.BLACK, null);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bim, "png", out);
 
		try {
			out.flush();
 
		} finally {
			out.close();
 
		}
	}
}
