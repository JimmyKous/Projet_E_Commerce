package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Customer;
import fr.adaming.model.Etudiant;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	// Create Hibernate's SessionFactory
	@Autowired
	private SessionFactory sf;
	
	// Setter for Dependancy Injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Customer addCustomer(Customer c) {
		Session s = sf.getCurrentSession();
		return (Customer) s.get(Customer.class,c.getId());
	}

	@Override
	public int updateCustomer(Customer c) {
		Session s = sf.getCurrentSession();
		Customer cOut = (Customer) s.get(Customer.class, c.getId());
		c.setId(cOut.getId());
		try {
			s.merge(c);
			return 1;
		}
		catch (Exception e1) {
			return 0;
		}
	}

	@Override
	public int deleteCustomer(Customer c) {
		Session s = sf.getCurrentSession();
		String req = "DELETE FROM Customer AS c WHERE c.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", c.getId());
		return query.executeUpdate();
	}

	@Override
	public Customer getCustomer(Customer c) {
		Session s = sf.getCurrentSession();
		return (Customer) s.get(Customer.class, c.getId());
	}

}