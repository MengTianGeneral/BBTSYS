package com.bbt.service.impl;

import com.bbt.bean.User;
import com.bbt.dao.UserDao;

import com.bbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {

        HashMap hashMap=new HashMap();
        hashMap.put("username",username);
        hashMap.put("password",password);

        return userDao.findUserByUserNameAndPassword(hashMap);
    }

    //@Transactional(readOnly = true)
    @Override
    public boolean register(User user) {
        return   userDao.insertUser(user)==1?true:false;
    }




    @Override
    public User findUserByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        return  user;
    }


}
