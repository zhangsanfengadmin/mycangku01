package com.baidu.service;

import com.baidu.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();

    void delUser(Integer uid);

    int updateUser(User user);

    int addUser(User user);
}
