package com.bbt.test;


import com.bbt.bean.User;
import com.bbt.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {


    @Autowired
    UserService service;


    @Test
    public void testLogin(){

        User admin = service.login("admin", "123");

        Assert.assertNotNull(admin);

        System.out.println("admin="+admin);

    }

    @Test
    public void testRegister(){

        User user = new User();
        user.setUsername("allengg");
        user.setPassword("abc");
        user.setEmail("abc@allen.com");


        boolean register = service.register(user);

        Assert.assertTrue(register);

        System.out.println("admin="+register);

    }

    @Test
    public void testRegister2(){
        String username = "allen";
        User user = service.findUserByUsername(username);
        System.out.println("user="+user);


    }

}
