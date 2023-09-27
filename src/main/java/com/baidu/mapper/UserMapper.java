package com.baidu.mapper;

import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    List<User> findUsers();

    void delById(Integer uid);

    @Update("update  user  set  username=#{username},password=#{password},address=#{address},phone=#{phone} where  uid=#{uid}")
    int update(User user);

    @Insert("insert  into  user values(null,#{username},#{password},#{address},#{phone})")
    int addUser(User user);
}
