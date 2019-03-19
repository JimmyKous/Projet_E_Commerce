package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Category createCategory(Category c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		return (Category) s.get(Category.class, c.getIdCat());
	}

	@Override
	public Category getCategory(Category c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCategory(Category c) {
		Session s = sf.getCurrentSession();
		Category cOut = (Category) s.get(Category.class, c.getIdCat());
		c.setIdCat(cOut.getIdCat());
		try {
			s.merge(c);
			return 1;
		}
		catch (Exception e1) {
			return 0;
		}
	}

	@Override
	public int deleteCategory(Category c) {
		Session s = sf.getCurrentSession();
		String req = "DELETE FROM Category as c WHERE c.idCat=:pIdCat";
		Query query = s.createQuery(req);
		query.setParameter("pIdCat", c.getIdCat());
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		Session s = sf.getCurrentSession();
		String req = "FROM Category";
		Query query = s.createQuery(req);
		return query.list();
	}


}
