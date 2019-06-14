package com.muze.core.app.upload.httppost;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetAppcationconext {

	
	//private final static String PATH_SERVLET = "classpath:springmvc/spring-servlet.xml";
	private final static String PATH_SERVICE = "classpath:spring/muzeSpring.xml";
	
	private final static String PATH_MVC = "classpath:springmvc/spring-servlet.xml";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(PATH_SERVICE,PATH_MVC);
		String[] beanName = ctx.getBeanDefinitionNames();

		for(String str:beanName){
			System.out.println(str);
		}

		System.out.println(beanName.length);
 
	}
	
}
