package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Order;

public class OrderDaoImpl implements IOrderDao {

	// This annotation allows to inject an EntityManager instantiated by EJB Container
	@PersistenceContext(unitName="PU_I_Commerce")
	private EntityManager em;
	
	@Override
	public Order addOrder(Order o) {
		em.persist(o);
		return o;
	}

	@Override
	public Order getOrder(Order o) {
		
		try{
			
			return em.find(Order.class, o);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		// JPQL Request
		String req = "SELECT o FROM Order AS o";
		
		// Instanciate Query Object
		Query query = em.createQuery(req);
		
		try {
			@SuppressWarnings("unchecked")
			List<Order> orders = query.getResultList();
			return orders;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

}
