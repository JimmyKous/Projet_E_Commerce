package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Article;
import fr.adaming.model.Category;

@Repository
public class ArticleDaoImpl implements IArticleDao {

	@Autowired
	private SessionFactory sf;
	
	// Setter pour l'Injection de Dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Article createArticle(Article a) {
		Session s = sf.getCurrentSession();
		s.save(a);
		return (Article) s.get(Article.class,a.getIdArt());
	}

	@Override
	public Article getArticle(Article a) {
		Session s = sf.getCurrentSession();
		return (Article) s.get(Article.class, a.getIdArt());
	}

	@Override
	public int updateArticle(Article a) {
		Session s = sf.getCurrentSession();
		try {
			s.merge(a);
			return 1;
		} catch (Exception e1) {
			return 0;
		}
	}

	@Override
	public int deleteArticle(Article a) {
		Session s = sf.getCurrentSession();
		String req = "DELETE FROM Article AS a WHERE a.idArt=:pIdArt";
		Query query = s.createQuery(req);
		query.setParameter("pIdArt", a.getIdArt());
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticleFromCategory(Category c) {
		Session s = sf.getCurrentSession();
		String req = "FROM Article AS a WHERE a.category=:pCategory";
		Query query = s.createQuery(req);
		query.setParameter("pCategory", c.getIdCat());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticle() {
		Session s = sf.getCurrentSession();
		String req = "FROM Article";
		Query query = s.createQuery(req);
		return query.list();
	}


}
