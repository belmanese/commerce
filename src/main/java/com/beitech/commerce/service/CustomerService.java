package com.beitech.commerce.service;

import com.beitech.commerce.model.Customer;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

public interface CustomerService {

    void create(Customer customer);

    Customer read(int id);

    void update(Customer customer);

    void delete(String id);

    List<Customer> findAll();

}
