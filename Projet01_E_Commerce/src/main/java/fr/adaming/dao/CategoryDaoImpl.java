package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.model.Category;

public class CategoryDaoImpl implements ICategoryDao {

	// This annotation allows to inject an EntityManager instantiated by EJB Container
	@PersistenceContext(unitName="PU_I_Commerce")
	private EntityManager em;
	
	@Override
	public Category createCategory(Category c) {
		em.persist(c);
		return c;
	}

	@Override
	public Category getCategory(Category c) {
		
		try {
			
			return em.find(Category.class, c);
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateCategory(Category c) {
		// JPQL Request
		String req = "UPDATE Catgory AS c SET c.categoryName=:pCategoryName, c.description=:pDescription,"
			+ "WHERE a.idCat=:pIdCat ";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		// Parameters
		query.setParameter("pCategoryName", c.getCategoryName());
		query.setParameter("pDescription", c.getDescription());
		
		try {
			
			return query.executeUpdate();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCategory(Category c) {
		// JPQL Request
		String req = "DELETE Category AS c WHERE c.idCat=:pIdCat";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		// Parameters
		query.setParameter("pIdCat", c.getIdCat());
		
		try {
			
			return query.executeUpdate();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Category> getAllCategory() {
		// JPQL Request
		String req = "SELECT c FROM Category AS c";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		try{
			List<Category> category = query.getResultList();
			for (Category c: category){
				c.setImg("data:image/png;base64,"+Base64.encodeBase64String(c.getPicture()));
			}
			return category ;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
			
	}

}
