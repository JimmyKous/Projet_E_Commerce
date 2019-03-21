package fr.adaming.service;

import fr.adaming.dao.ArticleDaoImpl;
import fr.adaming.dao.IArticleDao;
import fr.adaming.model.Article;


public class ArticleServiceImpl implements IArticleService {
	
	// Transform UML to Java Association
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
