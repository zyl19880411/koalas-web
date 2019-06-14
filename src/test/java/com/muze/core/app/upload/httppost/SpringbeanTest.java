package com.muze.core.app.upload.httppost;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringbeanTest implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println ("afterPropertiesSet()");
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println ("@ PostConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println ("@ PreDestroy");
    }

    public void Running(){
        System.out.println ("Running");
    }
}
