package fr.adaming.Service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.CustomerDaoImpl;
import fr.adaming.Dao.ICustomerDao;
import fr.adaming.model.Customer;

@Stateful
public class CustomerServiceImpl implements ICustomerService {
	
	// Transform UML to Java Association
	@EJB
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
