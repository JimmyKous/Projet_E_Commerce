package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Article;
import fr.adaming.model.Category;

public class ArticleDaoImpl implements IArticleDao {

	// This annotation allows to inject an EntityManager instantiated by EJB Container
	@PersistenceContext(unitName="PU_I_Commerce")
	private EntityManager em;
	
	@Override
	public Article createArticle(Article a) {
		em.persist(a);
		return a;
	}

	@Override
	public Article getArticle(Article a) {
		
		try {
			
			return em.find(Article.class, a);
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

	@Override
	public int updateArticle(Article a) {
		// JPQL Request
		String req = "UPDATE Article AS a SET a.designation=:pDesignation, a.description=:pDescription,"
				+ " a.price=:pPrice, a.stock=:pStock, a.picture=:pPicture WHERE a.idArt=:pIdArt ";
		
		// Instanciate Query Object
		Query query = em.createQuery(req);
		
		// Parameters
		query.setParameter("pDesignation", a.getDesignation());
		query.setParameter("pDescription", a.getDescription());
		query.setParameter("pPrice", a.getPrice());
		query.setParameter("pStock", a.getStock());
		query.setParameter("pPicture", a.getPicture());
		query.setParameter("pIdArt", a.getIdArt());
		
		try {
			
			return query.executeUpdate();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteArticle(Article a) {
		// JPQL Request
		String req = "DELETE Article AS a WHERE a.idArt=:pIdArt ";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		// Parameters
		query.setParameter("pIdArt", a.getIdArt());
		
		try {
			
			return query.executeUpdate();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Article> getAllArticleFromCategory(Category c) {
		// JPQL Request
		String req = "SELECT a FROM Article AS a WHERE category=:pCategory";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		// Parameter
		query.setParameter("pCategory", c);
		
		try{
			@SuppressWarnings("unchecked")
			List<Article> articles = query.getResultList();
			return articles ;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Article> getAllArticle() {
		// JPQL Request
		String req = "SELECT a FROM Article AS a";
		
		// Instantiate Query Object
		Query query = em.createQuery(req);
		
		try{
			@SuppressWarnings("unchecked")
			List<Article> articles = query.getResultList();
			return articles ;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
