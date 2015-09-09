package com.beitech.commerce.dao;

import com.beitech.commerce.model.Product;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

public interface ProductDao {

    void create(Product product);

    Product read(int id);

    void delete(String id);

    List<Product> findAll();

}
