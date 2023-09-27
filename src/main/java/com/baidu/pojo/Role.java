package com.baidu.pojo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//角色
//绑定表
@Table(name = "t_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer rid;
    private String rname;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                '}';
    }
}
