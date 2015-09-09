package com.beitech.commerce.service;

import com.beitech.commerce.model.Product;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

public interface ProductService {

    void create(Product product);

    Product read(int id);

    void update(Product product);

    void delete(String id);

    List<Product> findAll();

}
