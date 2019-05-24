package com.bbt.dao;

import com.bbt.bean.User;


import java.util.HashMap;

public interface UserDao {


    User findUserByUserNameAndPassword(HashMap map);


    int insertUser(User user);

    User findUserByUsername(String username);


}
