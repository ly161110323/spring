package com.ly.feign;


import com.ly.entity.Category;
import com.ly.entity.CategoryStats;
import com.ly.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "product-service")
public interface ProductFeign {

    @GetMapping("/product/getCategoryStats/{index}/{limit}")
    public List<CategoryStats> getCategoryStats(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/product/getCategoryCount")
    public int getCategoryCount();

    @GetMapping("/product/getCategoryByName/{name}")
    public Category getCategoryByName(@PathVariable("name") String name);

    @GetMapping("/product/addCategory/{name}")
    public void addCategory(@PathVariable("name") String name);

    @GetMapping("/product/findProduct/{brand}/{name}/{specification}/{categoryId}")
    public Product findProduct(@PathVariable("brand") String brand, @PathVariable("name") String name, @PathVariable("specification") String specification, @PathVariable("categoryId") int categoryId);

    @GetMapping("/product/addProduct/{brand}/{name}/{specification}/{categoryId}")
    public void addProduct(@PathVariable("brand") String brand, @PathVariable("name") String name, @PathVariable("specification") String specification, @PathVariable("categoryId") int categoryId);

    @GetMapping("/product/getAllCategory")
    public List<Category> getAllCategory();

}