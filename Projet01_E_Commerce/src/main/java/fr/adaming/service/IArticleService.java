package fr.adaming.service;

import fr.adaming.model.Article;


public interface IArticleService {

	public Article createArticle(Article a);
	
	public Article getArticle(Article a);
	
	public int updateArticle(Article a);
	
	public int deleteArticle(Article a);
	
}
