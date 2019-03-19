package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Admin;

public class AdminDaoImpl implements IAdminDao{

	
		// This annotation allows to inject an EntityManager instantiated by EJB Container
		@PersistenceContext(unitName="PU_I_Commerce")
		private EntityManager em;
		
		@Override
		public Admin isExist(Admin ad) {
			
			// JPQL Request
			String  req="SELECT ad FROM Admin as ad WHERE ad.mail=:pMail AND ad.pw=:pPw";
			
			// Récupérer un objet de type Query
			Query query = em.createQuery(req);
			
			// Passage des paramètres
			query.setParameter("pMail", ad.getMail());
			query.setParameter("pPw", ad.getPw());
			
			try {
			
				return (Admin)query.getSingleResult();
			
			} catch (Exception ex){
				ex.printStackTrace();
			}
			return null;
		}

}
