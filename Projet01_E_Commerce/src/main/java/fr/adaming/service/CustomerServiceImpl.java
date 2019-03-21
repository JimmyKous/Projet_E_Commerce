package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICustomerDao;
import fr.adaming.model.Customer;

@Service("cService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	// Transform UML to Java Association
	@Autowired
	private ICustomerDao cDao;

	// setter for injection of dependance
	public void setcDao(ICustomerDao cDao) {
		this.cDao = cDao;
	}

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
