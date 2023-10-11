package com.baidu.mapper;

import com.baidu.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper{
    /*查询所有的订单*/
    List<Orders> getOrders();
}
