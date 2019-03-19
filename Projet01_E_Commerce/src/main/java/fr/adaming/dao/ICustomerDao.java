package fr.adaming.Dao;

import javax.ejb.Local;

import fr.adaming.model.Customer;

@Local
public interface ICustomerDao {

	public Customer addCustomer(Customer c);
	
	public int updateCustomer(Customer c);
	
	public int deleteCustomer(Customer c);
	
	public Customer getCustomer(Customer c);
}
