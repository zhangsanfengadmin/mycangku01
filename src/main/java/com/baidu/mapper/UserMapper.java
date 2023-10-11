package com.baidu.mapper;

import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    List<User> findUsers(String username);

    void delById(Integer uid);

    @Update("update  user  set  username=#{username},password=#{password},address=#{address},phone=#{phone},birth=#{birth},img=#{img} where  uid=#{uid}")
    int update(User user);

    @Insert("insert  into  user(username,password,address,phone,birth,img) values(#{username},#{password},#{address},#{phone},#{birth},#{img})")
    int addUser(User user);

    @Select("select    *  from   user  where   username=#{username}  and  password=#{password}")
    User login(User user);
}
