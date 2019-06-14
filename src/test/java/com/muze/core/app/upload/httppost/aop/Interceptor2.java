package com.muze.core.app.upload.httppost.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Interceptor2 {

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入环绕通知2");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("退出方法2");
        return object;
    }

}
