package com.ly.controller;

import com.ly.entity.ConsumptionDetails;
import com.ly.entity.Order;
import com.ly.entity.OrderVo;
import com.ly.entity.Record;
import com.ly.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/getOrderById/{uid}/{page}/{limit}")
    public List<OrderVo> getOrderById(@PathVariable("uid") int uid, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        return orderMapper.getPurchaseRecordsByUserId(uid, (page-1)*limit, limit);
    }

    @GetMapping("/getOrdersCount/{userId}")
    public int getOrdersByUserId(@PathVariable("userId") int userId)
    {
        return orderMapper.countOrdersByUserId(userId);
    }

    @GetMapping("/getConsumptionDetails/{categoryId}/{page}/{limit}")
    public List<ConsumptionDetails> getConsumptionDetails(@PathVariable("categoryId") int categoryId, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        return orderMapper.getOrdersByCategory(categoryId, (page-1)*limit, limit);
    }

    @GetMapping("/getCategoryDetailsCount/{categoryId}")
    public int getConsumptionDetailsCount(@PathVariable("categoryId") int categoryId)
    {
        return orderMapper.countConsumptionDetails(categoryId);
    }

    @GetMapping("/addOrder/{userId}/{productId}/{units}/{price}")
    public void addOrder(@PathVariable("userId") int userId, @PathVariable("productId") int productId, @PathVariable("units") int units, @PathVariable("price") double price) {
        Order order = new Order(-1, userId, productId, units, price, Calendar.getInstance().getTime());
        orderMapper.addOrder(order);
    }

    @GetMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderMapper.deleteOrder(id);
    }

    @GetMapping("/getRecords/{productId}/{page}/{limit}")
    public List<Record> getRecords(@PathVariable("productId") int productId, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        return orderMapper.getRecordsByProductId(productId, (page-1)*limit, limit);
    }

    @GetMapping("/getRecordsCount/{productId}")
    public int getRecordsCount(@PathVariable("productId") int productId) {
        return orderMapper.countRecords(productId);
    }

}
