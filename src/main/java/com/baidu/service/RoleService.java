package com.baidu.service;

import com.baidu.pojo.Role;

import java.util.List;

public interface RoleService {
    /*查询所有*/
    List<Role>  findRoles(String rname);

    int delById(Integer rid);
}
