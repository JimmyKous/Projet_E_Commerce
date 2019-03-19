package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.OrderLine;

public interface IOrderLineDao {
	
	public OrderLine addOrderLine(OrderLine ol);
	
	public List<OrderLine> getAllOrderLine();
	
	public OrderLine getOrderLine(OrderLine ol);
	
	public int DeleteOrderLine(OrderLine ol);
	
	public int UpdateOrderLine(OrderLine ol);

}
