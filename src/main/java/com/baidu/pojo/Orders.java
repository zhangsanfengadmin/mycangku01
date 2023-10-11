package com.baidu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.io.Serializable;

//订单类
@Table(name = "orders")
@Data@ToString
public class Orders implements Serializable {
    private String code;
    private Double price;
    private String file;
    private Integer status;
    private  String   customerName;
    private   String   tel;


}
