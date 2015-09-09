package com.beitech.commerce.dao;

import com.beitech.commerce.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

	public Order read(int id) {

		return getByKey(id);

	}

	public void create(Order order) {

		persist(order);

	}

	public void delete(String id) {

		Query query = getSession().createSQLQuery("delete from Order where id = :id");
		query.setString("id", id);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Order> findAll() {

		Criteria criteria = createEntityCriteria();
		List<Order> orders = (List<Order>) criteria.list();
		return orders;

	}

	public List<Order> OrdersByCustomerIntoDate(String customerId, Date fromDate, Date toDate) {
		String hql = "select distinct o from Order o " +
					 "inner join o.customer c " +
					 "where c.id = :customerId " +
					 	"and o.date between :fromDate and :toDate ";

		List<Order> campaigns = getSession().createQuery(hql).list();

		return getSession().createQuery(hql).list();
	}

}
