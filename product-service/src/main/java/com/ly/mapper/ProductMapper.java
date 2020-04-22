package com.ly.mapper;

import com.ly.entity.Category;
import com.ly.entity.CategoryStats;
import com.ly.entity.Product;

import java.util.List;

public interface ProductMapper {
    public List<CategoryStats> getCategoryStats(int index, int limit);
    public int countCategorys();
    public Category getCategoryByName(String name);
    public void addCategory(String name);
    public Product findProduct(Product product);
    public void addProduct(Product product);
    public List<Category> getAllCategory();
}
