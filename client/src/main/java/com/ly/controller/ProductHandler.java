package com.ly.controller;


import com.ly.entity.Category;
import com.ly.entity.MsgReturn;
import com.ly.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductHandler {
    @Autowired
    private ProductFeign productFeign;

    @GetMapping("/getCategoryStats")
    @ResponseBody
    public MsgReturn getCategoryStats(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int count = productFeign.getCategoryCount();
        if (count == 0)
        {
            return new MsgReturn(-1, "no category", count, null);
        }
        return new MsgReturn(0, "success", count, productFeign.getCategoryStats((page-1)*limit, limit));
    }

    @PostMapping("/addCategory")
    @ResponseBody
    public MsgReturn addCategory(@RequestParam("category") String category) {
        // System.out.println(category);
        if (productFeign.getCategoryByName(category) == null) {
            productFeign.addCategory(category);
            return new MsgReturn(0, "添加成功", 0, null);
        }
        else {
            return new MsgReturn(-1, "该类别名已存在", 0, null);
        }
    }

    @GetMapping("/getAllCategory")
    @ResponseBody
    public List<Category> getAllCategory() {
        return productFeign.getAllCategory();
    }
}
