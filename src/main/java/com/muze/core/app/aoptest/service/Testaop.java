package com.muze.core.app.aoptest.service;



//@Aspect
public class Testaop{
	
//	@Pointcut(value = "execution(* com.muze.core.app.task.service.TaskService.getTasks(..)) && args(pageBounds)",argNames="pageBounds")
//	public void any(PageBounds pageBounds){
//		
//	}	
//	@Before(value="any(pageBounds)",argNames="pageBounds")
//	public void before(PageBounds pageBounds){
//		System.out.println("*************************");
//	}
//	
	public void before(){
		System.out.println("*************************");
	}
	

}
