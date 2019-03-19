package fr.adaming.dao;

import java.util.List;
import fr.adaming.model.Order;

public interface IOrderDao {

	public Order addOrder(Order o);
	
	public Order getOrder(Order o);
	
	public List<Order> getAllOrder();
}
