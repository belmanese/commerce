package com.beitech.commerce.dao;

import com.beitech.commerce.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	public Customer read(int id) {

		return getByKey(id);

	}

	public void create(Customer customer) {

		persist(customer);

	}

	public void delete(String id) {

		Query query = getSession().createSQLQuery("delete from Customer where id = :id");
		query.setString("id", id);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {

		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();

	}

}
