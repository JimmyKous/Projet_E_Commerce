package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Order;

@Repository
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Order addOrder(Order o) {
		Session s = sf.getCurrentSession();
		s.save(o);
		return (Order) s.get(Order.class, o.getId());
	}

	@Override
	public Order getOrder(Order o) {
		Session s = sf.getCurrentSession();
		return (Order) s.get(Order.class, o.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrder() {
		Session s = sf.getCurrentSession();
		String req = "FROM Order";
		Query query = s.createQuery(req);
		return query.list();
	}
}
