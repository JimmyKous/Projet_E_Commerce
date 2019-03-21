package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IArticleDao;
import fr.adaming.model.Article;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements IArticleService {
	
	// Transform UML to Java Association
	@Autowired
	private IArticleDao artDao;
	
	//setter for injection of dependance
	public void setArtDao(IArticleDao artDao) {
		this.artDao = artDao;
	}
	
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
