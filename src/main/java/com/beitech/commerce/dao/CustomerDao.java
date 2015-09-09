package com.beitech.commerce.dao;

import com.beitech.commerce.model.Customer;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

public interface CustomerDao {

    void create(Customer customer);

    Customer read(int id);

    void delete(String id);

    List<Customer> findAll();

}
