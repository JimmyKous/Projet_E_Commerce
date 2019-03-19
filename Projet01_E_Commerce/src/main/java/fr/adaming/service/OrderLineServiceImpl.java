package fr.adaming.Service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.IOrderLineDao;
import fr.adaming.Dao.OrderLineDaoImpl;
import fr.adaming.model.OrderLine;

@Stateful
public class OrderLineServiceImpl implements IOrderLineService {

	@EJB 
	IOrderLineDao olDao	= new OrderLineDaoImpl();
	
	@Override
	public OrderLine addOrderLine(OrderLine ol) {
		return olDao.addOrderLine(ol);
	}

	@Override
	public List<OrderLine> getAllOrderLine() {
		return olDao.getAllOrderLine();
	}

	@Override
	public OrderLine getOrderLine(OrderLine ol) {
		return olDao.getOrderLine(ol);
	}

	@Override
	public int DeleteOrderLine(OrderLine ol) {
		// TODO Auto-generated method stub
		return olDao.DeleteOrderLine(ol);
	}

	@Override
	public int UpdateOrderLine(OrderLine ol) {
		return olDao.UpdateOrderLine(ol);
	}

}
