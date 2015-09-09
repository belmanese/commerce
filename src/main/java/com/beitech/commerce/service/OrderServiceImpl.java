package com.beitech.commerce.service;

import com.beitech.commerce.dao.OrderDao;
import com.beitech.commerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public void create(Order order) {

        orderDao.create(order);

    }

    public Order read(int id) {

        return orderDao.read(id);

    }

    public void update(Order order) {

        Order entity = orderDao.read(order.getId());
        if(entity!=null) {
            entity.setDeliveryAddress(order.getDeliveryAddress());
            entity.setCustomer(order.getCustomer());

        }

    }

    public void delete(String id) {

        orderDao.delete(id);

    }

    public List<Order> findAll() {

        return orderDao.findAll();

    }

    public List<Order> OrdersByCustomerIntoDate(String customerId, Date from, Date to) {

        return orderDao.OrdersByCustomerIntoDate(customerId, from, to);

    }

    public void updateCurrencyRate(String rate) {

        for(Order order: orderDao.findAll())
            order.setCurrencyRate(rate);

    }
}
