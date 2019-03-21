package fr.adaming.service;

import fr.adaming.dao.CustomerDaoImpl;
import fr.adaming.dao.ICustomerDao;
import fr.adaming.model.Customer;


public class CustomerServiceImpl implements ICustomerService {
	
	// Transform UML to Java Association

	private ICustomerDao cDao = new CustomerDaoImpl();

	@Override
	public Customer addCustomer(Customer c) {
		return cDao.addCustomer(c);
	}

	@Override
	public int updateCustomer(Customer c) {
		return cDao.updateCustomer(c);
	}

	@Override
	public int deleteCustomer(Customer c) {
		return cDao.deleteCustomer(c);
	}

	@Override
	public Customer getCustomer(Customer c) {
		return cDao.getCustomer(c);
	}

}
