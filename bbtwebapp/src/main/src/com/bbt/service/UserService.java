package com.bbt.service;

import com.bbt.bean.User;


public interface UserService {


    User login(String username, String password);

    boolean   register(User user);

    User findUserByUsername(String username);


}
