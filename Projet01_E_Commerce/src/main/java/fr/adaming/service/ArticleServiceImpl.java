package fr.adaming.Service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.ArticleDaoImpl;
import fr.adaming.Dao.IArticleDao;
import fr.adaming.model.Article;

@Stateful
public class ArticleServiceImpl implements IArticleService {
	
	// Transform UML to Java Association
	@EJB
	IArticleDao artDao = new ArticleDaoImpl();
	
	@Override
	public Article createArticle(Article a) {
		return artDao.createArticle(a);
	}

	@Override
	public Article getArticle(Article a) {
		return artDao.getArticle(a);
	}

	@Override
	public int updateArticle(Article a) {
		return artDao.updateArticle(a);
	}

	@Override
	public int deleteArticle(Article a) {
		return artDao.deleteArticle(a);
	}
	

}
