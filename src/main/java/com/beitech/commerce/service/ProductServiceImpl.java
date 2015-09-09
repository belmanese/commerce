package com.beitech.commerce.service;

import com.beitech.commerce.dao.ProductDao;
import com.beitech.commerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public void create(Product product) {

        productDao.create(product);

    }

    public Product read(int id) {

        return productDao.read(id);

    }

    public void update(Product product) {

        Product entity = productDao.read(product.getId());
        if(entity!=null)
            entity.setName(product.getName());

    }

    public void delete(String id) {

        productDao.delete(id);

    }

    public List<Product> findAll() {

        return productDao.findAll();

    }
}
