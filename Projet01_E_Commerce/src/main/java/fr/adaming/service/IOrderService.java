package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Order;

public interface IOrderService {

	public Order addOrder(Order o);
	
	public Order getOrder(Order o);
	
	public List<Order> getAllOrder();
}
