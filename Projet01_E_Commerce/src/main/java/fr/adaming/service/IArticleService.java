package fr.adaming.Service;

import javax.ejb.Local;

import fr.adaming.model.Article;

@Local
public interface IArticleService {

	public Article createArticle(Article a);
	
	public Article getArticle(Article a);
	
	public int updateArticle(Article a);
	
	public int deleteArticle(Article a);
	
}
