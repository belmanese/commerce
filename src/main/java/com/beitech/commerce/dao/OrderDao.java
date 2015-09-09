package com.beitech.commerce.dao;

import com.beitech.commerce.model.Order;

import java.util.Date;
import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

public interface OrderDao {

    void create(Order order);

    Order read(int id);

    void delete(String id);

    List<Order> findAll();

    List<Order> OrdersByCustomerIntoDate(String customerId, Date from, Date to);

}
