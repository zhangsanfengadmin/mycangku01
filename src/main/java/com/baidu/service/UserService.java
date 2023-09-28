package com.baidu.service;

import com.baidu.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUsers(String username);

    void delUser(Integer uid);

    int updateUser(User user);

    int addUser(User user);
}
