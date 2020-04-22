package com.ly.feign;

import com.ly.entity.ConsumptionDetails;
import com.ly.entity.OrderVo;
import com.ly.entity.Record;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(value = "order-service")
public interface OrderFeign {

    @GetMapping("/order/getOrderById/{uid}/{page}/{limit}")
    public List<OrderVo> getOrderById(@PathVariable("uid") int uid, @PathVariable("page") int page, @PathVariable("limit") int limit);


    @GetMapping("/order/getOrdersCount/{userId}")
    public int getOrdersByUserId(@PathVariable("userId") int userId);

    @GetMapping("/order/getConsumptionDetails/{categoryId}/{page}/{limit}")
    public List<ConsumptionDetails> getConsumptionDetails(@PathVariable("categoryId") int categoryId, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/order/getCategoryDetailsCount/{categoryId}")
    public int getConsumptionDetailsCount(@PathVariable("categoryId") int categoryId);

    @GetMapping("/order/addOrder/{userId}/{productId}/{units}/{price}")
    public void addOrder(@PathVariable("userId") int userId, @PathVariable("productId") int productId, @PathVariable("units") int units, @PathVariable("price") double price);

    @GetMapping("/order/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") int id);

    @GetMapping("/order/getRecords/{productId}/{page}/{limit}")
    public List<Record> getRecords(@PathVariable("productId") int productId, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/order/getRecordsCount/{productId}")
    public int getRecordsCount(@PathVariable("productId") int productId);

}
