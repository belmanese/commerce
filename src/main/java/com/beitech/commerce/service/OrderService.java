package com.beitech.commerce.service;

import com.beitech.commerce.model.Order;

import java.util.Date;
import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

public interface OrderService {

    void create(Order order);

    Order read(int id);

    void update(Order order);

    void delete(String id);

    List<Order> findAll();

    List<Order> OrdersByCustomerIntoDate(String customerId, Date from, Date to);

    void updateCurrencyRate(String rate);

}
