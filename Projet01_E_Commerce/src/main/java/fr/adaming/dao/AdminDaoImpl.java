package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Admin;

@Repository
public class AdminDaoImpl implements IAdminDao{

	// Create Session Factory
	@Autowired
	private SessionFactory sf;
	
	// Setter for Dependancy Injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Admin isExist(Admin ad) {
		Session s = sf.getCurrentSession();
		String req = "FROM Admin AS a WHERE a.mail=:pMail AND a.pw=:pPw";
		Query query = s.createQuery(req);
		query.setParameter("pMail", ad.getMail());
		query.setParameter("pPw", ad.getPw());
		
		return (Admin) query.uniqueResult();
	}

	


}
