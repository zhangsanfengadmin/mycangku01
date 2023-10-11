package com.baidu.service;

import com.baidu.pojo.Orders;

import java.util.List;

public interface OrdersService {
    /*查询所有的订单*/
    List<Orders> getOrders();
}
