package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IOrderDao;
import fr.adaming.model.Order;

@Service("oService")
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao oDao;
	
	//setter for injection of dependance
	public void setoDao(IOrderDao oDao) {
		this.oDao = oDao;
	}

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
