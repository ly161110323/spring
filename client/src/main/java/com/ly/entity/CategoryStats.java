package com.ly.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryStats implements Serializable {
    private int id;
    private String category;
    private int units;
    private double prices;

    public CategoryStats() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
}
