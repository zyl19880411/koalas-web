package com.muze.core.app.login.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.muze.core.app.login.model.UserModel;
import com.muze.core.app.login.service.UserLoginService;
import com.muze.core.app.utils.Encodes;

/**
 * *********************基本信息说明********************************
 * 类名        :MyRealm.java
 * 项目名称 :com.muze.core.app.doc.web
 * 类说明     :shrio身份认证和权限认证
 * 创建时间 :2015年12月4日
 * 作         者:张玉龙
 * 版         本:v1
 ***************************修改历史********************************
 * 1、none
 * 修改人    :张玉龙
 * 修改时间:2015年12月4日
 ************************主要方法说明********************************
 * 1、doGetAuthenticationInfo身份认证
 * 2、doGetAuthorizationInfo权限认证
 *******************************************************************
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserLoginService userLoginService;
	
	/**
	 * 获取身份验证相关信息,认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {

		// UsernamePasswordToken对象用来存放提交的登录信息
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		//查询是否有这个用户
		UserModel userDto = userLoginService.getUser(token.getUsername());
		
		if(userDto==null){
			throw new UnknownAccountException();
		}
		
		Session session =SecurityUtils.getSubject().getSession();
		session.setAttribute("user", userDto);
		
		return new SimpleAuthenticationInfo(userDto.getUserCode(), Encodes.decode(userDto.getUserPassword()), getName());
	}
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {

		// 获取登录时输入的用户名
		String loginName = (String) principalCollection.fromRealm(getName())
				.iterator().next();
		System.out.println(loginName);

		// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
 
        //用户权限
		List<String> list = userLoginService.getUserPermissions(loginName);
		
		Set<String> set = new HashSet<String>(list); 
		
		info.setStringPermissions(set);
		
		return info;
	}
}
