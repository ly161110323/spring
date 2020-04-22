package com.ly.controller;


import com.ly.entity.Category;
import com.ly.entity.CategoryStats;
import com.ly.entity.Product;
import com.ly.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductHandler {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/getCategoryStats/{index}/{limit}")
    public List<CategoryStats> getCategoryStats(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return productMapper.getCategoryStats(index, limit);
    }

    @GetMapping("/getCategoryCount")
    public int getCategoryCount() {
        return productMapper.countCategorys();
    }

    @GetMapping("/getCategoryByName/{name}")
    public Category getCategoryByName(@PathVariable("name") String name) {
        return productMapper.getCategoryByName(name);
    }

    @GetMapping("/addCategory/{name}")
    public void addCategory(@PathVariable("name") String name) {
        productMapper.addCategory(name);
    }

    @GetMapping("/findProduct/{brand}/{name}/{specification}/{categoryId}")
    public Product findProduct(@PathVariable("brand") String brand, @PathVariable("name") String name, @PathVariable("specification") String specification, @PathVariable("categoryId") int categoryId) {
        return productMapper.findProduct(new Product(-1, brand, name, specification, categoryId));
    }

    @GetMapping("/addProduct/{brand}/{name}/{specification}/{categoryId}")
    public void addProduct(@PathVariable("brand") String brand, @PathVariable("name") String name, @PathVariable("specification") String specification, @PathVariable("categoryId") int categoryId) {
        productMapper.addProduct(new Product(-1, brand, name, specification, categoryId));
    }

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory() {
        return productMapper.getAllCategory();
    }
}
