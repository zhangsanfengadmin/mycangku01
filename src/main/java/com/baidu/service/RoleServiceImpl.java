package com.baidu.service;

import com.baidu.mapper.RoleMapper;
import com.baidu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoles(String rname) {
        //通用mapper的条件查询
        Example example = new Example(Role.class);
        //
        Example.Criteria criteria = example.createCriteria();
        //对rname进行判断
        if (rname != null && rname != "") {
            //条件
            criteria.andLike("rname", "%" + rname + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public int delById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
