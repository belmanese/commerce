package com.beitech.commerce.service;

import com.beitech.commerce.dao.CustomerDao;
import com.beitech.commerce.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void create(Customer customer) {

        customerDao.create(customer);

    }

    public Customer read(int id) {

        return customerDao.read(id);

    }

    public void update(Customer customer) {

        Customer entity = customerDao.read(customer.getId());
        if(entity!=null){
            entity.setName(customer.getName());
            entity.setEmail(customer.getEmail());
        }

    }

    public void delete(String id) {

        customerDao.delete(id);

    }

    public List<Customer> findAll() {

        return customerDao.findAll();

    }
}
