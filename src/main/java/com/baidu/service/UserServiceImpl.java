package com.baidu.service;

import com.baidu.mapper.UserMapper;
import com.baidu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements   UserService {
    @Autowired
    private UserMapper  userMapper;
    @Override
    public List<User> findUsers(String username) {
        return userMapper.findUsers(username);
    }

    @Override
    public void delUser(Integer uid) {
        userMapper.delById(uid);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
