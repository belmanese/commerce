package com.beitech.commerce.dao;

import com.beitech.commerce.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	public Product read(int id) {

		return getByKey(id);

	}

	public void create(Product product) {

		persist(product);

	}

	public void delete(String id) {

		Query query = getSession().createSQLQuery("delete from Product where id = :id");
		query.setString("id", id);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {

		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();

	}

}
