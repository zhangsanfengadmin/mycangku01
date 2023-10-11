package com.baidu.controller;

import com.baidu.pojo.Orders;
import com.baidu.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale-order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /*获取所有订单*/
    @GetMapping("page/{pageNum}/{pageSize}")
    public PageInfo<Orders> showOrders(@PathVariable("pageNum") Integer pageNum,
                                       @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> orders = ordersService.getOrders();
        System.out.println(orders);
        PageInfo<Orders> pageInfo = new PageInfo<>(orders);
        return pageInfo;
    }


}
