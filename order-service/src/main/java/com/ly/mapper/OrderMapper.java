package com.ly.mapper;

import com.ly.entity.ConsumptionDetails;
import com.ly.entity.Order;
import com.ly.entity.OrderVo;
import com.ly.entity.Record;

import java.util.List;

public interface OrderMapper {
    public List<OrderVo> getPurchaseRecordsByUserId(int userId, int page, int limit);
    public List<ConsumptionDetails> getOrdersByCategory(int categoryId, int page, int limit);
    public int countOrdersByUserId(int userId);
    public int countConsumptionDetails(int categoryId);
    public void addOrder(Order order);
    public List<Record> getRecordsByProductId(int productId, int index, int limit);
    public int countRecords(int productId);
    public void deleteOrder(int id);
}
