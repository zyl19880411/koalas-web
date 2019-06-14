package com.muze.core.app.upload.httppost;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/muzeSpring1.xml" })
public class RoleTest {

    private final static Logger LOGGER = LoggerFactory.getLogger (RoleTest.class);

    /*@Autowired
    RoleService roleService;

    @Test
    public void getRolesTest(){
        PageBounds pageBounds = new PageBounds(0,10);
        System.out.println(roleService.getRoles("admin",pageBounds));
    }*/

    @Autowired
    private SpringbeanTest springbeanTest;

    @Before
    public void before(){
        /*System.out.println("1111111111111");*/
    }

    @Test
    public void springBeanTest() throws Exception {
        springbeanTest.Running ();
    }

    @After
    public void After(){
       /* System.out.println("222222222222222");*/
    }

}
