package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.OrderLine;

public class OrderLineDaoImpl implements IOrderLineDao {

	// This annotation allows to inject an EntityManager instantiated by EJB Container
	@PersistenceContext(unitName="PU_I_Commerce")
	private EntityManager em;
	
	@Override
	public OrderLine addOrderLine(OrderLine ol) {
		em.persist(ol);
		return ol;
	}

	@Override
	public List<OrderLine> getAllOrderLine() {
		// JPQL Request
		String req = "SELECT ol FROM OrderLine AS ol";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		try{
			@SuppressWarnings("unchecked")
			List<OrderLine> orderLines = query.getResultList();
			return orderLines ;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderLine getOrderLine(OrderLine ol) {
		
		try {
			
			return em.find(OrderLine.class, ol);
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public int DeleteOrderLine(OrderLine ol) {
		// JPQL Request
		String req = "DELETE OrderLine AS ol WHERE ol.idOL=:pIdOL";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		// Parameters
		query.setParameter("pIdOL", ol.getIdOL());
		
		try {
			
			return query.executeUpdate();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}


	@Override
	public int UpdateOrderLine(OrderLine ol) {
		// JPQL Request
		String req = "UPDATE OrderLine AS ol SET ol.quantity=:pQuantity, ol.price=:pPrice WHERE ol.idOL=:pIdOL";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		// Parameters
		query.setParameter("pIdOL", ol.getIdOL());
		
		try {
			
			return query.executeUpdate();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

}
