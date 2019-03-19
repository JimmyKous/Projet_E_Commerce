package fr.adaming.Service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.OrderLine;

@Local
public interface IOrderLineService {
	
	public OrderLine addOrderLine(OrderLine ol);
	
	public List<OrderLine> getAllOrderLine();
	
	public OrderLine getOrderLine(OrderLine ol);
	
	public int DeleteOrderLine(OrderLine ol);
	
	public int UpdateOrderLine(OrderLine ol);
}
