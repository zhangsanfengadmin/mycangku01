package com.baidu.controller;

import com.baidu.pojo.Result;
import com.baidu.pojo.Role;
import com.baidu.pojo.User;
import com.baidu.service.RoleService;
import com.baidu.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//控制层
//@RestController=@Controller+@ResponseBody

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Value("${spring.servlet.multipart.location}")
    private String contractPdfFilePath;

    //get请求
    @GetMapping("showPage")
    public PageInfo<User> findPage(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                   String username) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.findUsers(username);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
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
    @PostMapping("updateUser")
    public String updateUser(@RequestBody User user) {
        //处理
        int len = userService.updateUser(user);
        if (len > 0) {
            return "ok";
        }
        return "no";
    }

    //添加  uid=2&username=zhangsan&
    @PostMapping("addUser")
    public String addUser(@RequestBody User user, @RequestParam("fname") String fname) {
        System.out.println(fname);
        user.setImg(fname);
        //处理
        int len = userService.addUser(user);
        if (len > 0) {
            return "ok";
        }
        return "no";
    }

    /*处理登录*/
    @PostMapping("sys-user/login")
    public Result<User> login(@RequestBody User user) {
        System.out.println(user.getUsername()+"-"+user.getRid());
        Result<User> result = new Result<>();
        //处理
        User u = userService.login(user);
        if (u != null) {//登录成功
            result.setMessage("登录成功");
            result.setSuccess(true);
            result.setResult(u);
        } else {//失败
            result.setMessage("用户名或者密码错误");
            result.setSuccess(false);

        }
        return result;
    }

}
