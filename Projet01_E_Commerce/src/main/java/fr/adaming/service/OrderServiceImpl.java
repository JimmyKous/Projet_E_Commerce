package fr.adaming.Service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.IOrderDao;
import fr.adaming.Dao.OrderDaoImpl;
import fr.adaming.model.Order;

@Stateful
public class OrderServiceImpl implements IOrderService {

	@EJB
	private IOrderDao oDao = new OrderDaoImpl();
	
	@Override
	public Order addOrder(Order o) {
		return oDao.addOrder(o);
	}

	@Override
	public Order getOrder(Order o) {
		return oDao.getOrder(o);
	}

	@Override
	public List<Order> getAllOrder() {
		return oDao.getAllOrder();
	}
	

}
