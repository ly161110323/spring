package com.ly.controller;


import com.ly.entity.MsgReturn;
import com.ly.entity.Product;
import com.ly.feign.OrderFeign;
import com.ly.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private ProductFeign productFeign;

    @GetMapping("/findOrdersById")
    @ResponseBody
    public MsgReturn getPurchaseRecords(@RequestParam("userId") int userId, @RequestParam("page") int page, @RequestParam("limit") int limit)
    {
        int count = orderFeign.getOrdersByUserId(userId);
        // System.out.println("\n"+count);
        if (count == 0)
        {
            return new MsgReturn(-1, "no data", count, null);
        }
        return new MsgReturn(0, "success", count, orderFeign.getOrderById(userId, page, limit));
    }

    @GetMapping("/getConsumptionDetails")
    @ResponseBody
    public MsgReturn getConsumptionDetails(@RequestParam("categoryId") int categoryId, @RequestParam("page") int page, @RequestParam("limit") int limit)
    {
        int count = orderFeign.getConsumptionDetailsCount(categoryId);
        if (count == 0)
        {
            return new MsgReturn(-1, "no data", count, null);
        }
        return new MsgReturn(0, "success", count, orderFeign.getConsumptionDetails(categoryId, page, limit));
    }

    @PostMapping("/addOrder")
    @ResponseBody
    public MsgReturn addOrder(@RequestParam("userId") int userId, @RequestParam("units") int units, @RequestParam("price") double price, @RequestParam("brand") String brand, @RequestParam("name") String name, @RequestParam("specification") String specification, @RequestParam("categoryId") int categoryId) {
        Product product = productFeign.findProduct(brand, name, specification, categoryId);
        if (product == null)
        {
            productFeign.addProduct(brand, name, specification, categoryId);
            product = productFeign.findProduct(brand, name, specification, categoryId);
        }
        orderFeign.addOrder(userId, product.getId(), units, price);
        return new MsgReturn(0, "success", 0, null);
    }

    @GetMapping("/deleteById")
    @ResponseBody
    public MsgReturn deleteOrder(@RequestParam("orderId") int orderId) {
        orderFeign.deleteOrder(orderId);
        return new MsgReturn(0,"success", 0, null);
    }

    @GetMapping("/getRecords")
    @ResponseBody
    public MsgReturn getRecords(@RequestParam("productId") int productId, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        int count = orderFeign.getRecordsCount(productId);
        if (count == 0)
            return new MsgReturn(-1, "no data", count, null);
        else
            return new MsgReturn(0, "success", count, orderFeign.getRecords(productId, page, limit));
    }
}
