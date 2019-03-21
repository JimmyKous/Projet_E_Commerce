package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.OrderLine;

@Repository
public class OrderLineDaoImpl implements IOrderLineDao {

	@Autowired
	private SessionFactory sf;
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public OrderLine addOrderLine(OrderLine ol) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> getAllOrderLine() {
		Session s = sf.getCurrentSession();
		String req = "FROM OrderLine";
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public OrderLine getOrderLine(OrderLine ol) {
		Session s = sf.getCurrentSession();
		return (OrderLine) s.get(OrderLine.class, ol.getIdOL());
	}

	@Override
	public int DeleteOrderLine(OrderLine ol) {
		Session s = sf.getCurrentSession();
		String req = "DELETE FROM OrderLine AS ol WHERE ol.idOL=:pIdOL";
		Query query = s.createQuery(req);
		query.setParameter("pIdOL", ol.getIdOL());
		return query.executeUpdate();
	}

	@Override
	public int UpdateOrderLine(OrderLine ol) {
		Session s = sf.getCurrentSession();
		try {
			s.merge(ol);
			return 1;
		} catch (Exception e1) {
			return 0;
		}
	}


}
