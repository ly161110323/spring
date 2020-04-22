package com.ly.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private int id;
    private String brand;
    private String name;
    private String specification;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Product() {

    }

    public Product(int id, String brand, String name, String specification, int categoryId) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.specification = specification;
        this.categoryId = categoryId;
    }
}
