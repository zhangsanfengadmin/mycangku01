package com.baidu.service;

import com.baidu.mapper.OrdersMapper;
import com.baidu.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements  OrdersService {
    @Autowired
    private OrdersMapper  ordersMapper;
    @Override
    public List<Orders> getOrders() {
        return ordersMapper.getOrders();
    }
}
