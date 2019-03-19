package fr.adaming.Service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Order;

@Local
public interface IOrderService {

	public Order addOrder(Order o);
	
	public Order getOrder(Order o);
	
	public List<Order> getAllOrder();
}
