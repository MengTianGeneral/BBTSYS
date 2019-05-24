package com.bbt.controller;

import com.bbt.bean.User;
import com.bbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Author TheFlash
 * @Date 2019/5/23
 * @TIME 15:28
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session) {

        //请求参数的合法验证

        User login = userService.login(username, password);

        ModelAndView modelAndView = new ModelAndView();
        if (login == null) {

            //用户不存在
            modelAndView.setViewName("/login.jsp");
            modelAndView.addObject("msg", "用户名或者密码不对！");
        } else {
            //登录成功
            //放到session里
            session.setAttribute("user", login);
            modelAndView.setViewName("/user.jsp");
        }
        return modelAndView;
    }


    @RequestMapping("/regist")
    public ModelAndView resgist(String username,String password, String wechatid,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        User user =new User(null,username,password,wechatid);

       User userByUsername = userService.findUserByUsername(username);
        boolean b;
        if (userByUsername!=null)b=true;else  b=false;

        if (b){
            //说明用户名已经存在
            modelAndView.setViewName("/addUser.jsp");
            modelAndView.addObject("msg", "用户已经存在！请重新注册");

        }else {
            //说明用户名尚未注册，可以进行注册
            boolean registUser= userService.register(user);
            //如果注册成功
            if (registUser){
                User user_regist = userService.findUserByUsername(username);
                session.setAttribute("user",user_regist);
                modelAndView.setViewName("/login.jsp");
                modelAndView.addObject("msg", "注册成功，请登陆！");
            }//用户注册失败
            else {
                modelAndView.setViewName("/addUser.jsp");
                modelAndView.addObject("msg", "注册失败，请重新尝试！");
            }
        }

        return modelAndView;
    }
    }
