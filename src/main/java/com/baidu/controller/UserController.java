package com.baidu.controller;

import com.baidu.pojo.Role;
import com.baidu.pojo.User;
import com.baidu.service.RoleService;
import com.baidu.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//控制层
//@RestController=@Controller+@ResponseBody
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //get 、post
    @GetMapping("showRoles")
    public String showRoles(Model model, String rname) {
        //根据rname进行模糊搜素
        //查
        List<Role> roles = roleService.findRoles(rname);
        //存值
        model.addAttribute("roles", roles);
        model.addAttribute("rname", rname);
        return "role";
    }

    @GetMapping("/del")
    public String del(Integer rid) {
        System.out.println(rid);
        int len = roleService.delById(rid);
        if (len > 0) {
            return "redirect:showRoles";
        }
        return "error";
    }
   //删除
    @DeleteMapping("/delete/{uid}")
    public void delUser(@PathVariable("uid") Integer uid) {
        try {
            userService.delUser(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //修改
    @GetMapping("updateUser")
    public   String    updateUser(User  user){
        //处理
        int  len=userService.updateUser(user);
        if(len>0){
            return   "ok";
        }
        return    "no";
    }
    //添加
    @GetMapping("addUser")
    public   String    addUser(User  user){
        //处理
        int  len=userService.addUser(user);
        if(len>0){
            return   "ok";
        }
        return    "no";
    }
    @GetMapping("test")
    public String testHello() {
        return "hello";
    }

    @GetMapping("show")
    public List<User> show() {
        return userService.findUsers();
    }
}
