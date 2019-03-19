package fr.adaming.dao;

import fr.adaming.model.Customer;

public interface ICustomerDao {

	public Customer addCustomer(Customer c);
	
	public int updateCustomer(Customer c);
	
	public int deleteCustomer(Customer c);
	
	public Customer getCustomer(Customer c);
}
