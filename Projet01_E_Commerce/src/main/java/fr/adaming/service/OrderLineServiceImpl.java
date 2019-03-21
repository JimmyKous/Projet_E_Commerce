package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IOrderLineDao;
import fr.adaming.model.OrderLine;

@Service("olService")
@Transactional
public class OrderLineServiceImpl implements IOrderLineService {

	@Autowired
	private IOrderLineDao olDao;
	
	//setter for injection of dependance
	public void setOlDao(IOrderLineDao olDao) {
		this.olDao = olDao;
	}

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
