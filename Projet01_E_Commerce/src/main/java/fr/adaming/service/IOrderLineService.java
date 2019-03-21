package fr.adaming.service;

import java.util.List;

import fr.adaming.model.OrderLine;

public interface IOrderLineService {
	
	public OrderLine addOrderLine(OrderLine ol);
	
	public List<OrderLine> getAllOrderLine();
	
	public OrderLine getOrderLine(OrderLine ol);
	
	public int DeleteOrderLine(OrderLine ol);
	
	public int UpdateOrderLine(OrderLine ol);
}
