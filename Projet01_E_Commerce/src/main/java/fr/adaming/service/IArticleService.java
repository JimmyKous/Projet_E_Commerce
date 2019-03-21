package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Article;
import fr.adaming.model.Category;


public interface IArticleService {

	public Article createArticle(Article a);
	
	public Article getArticle(Article a);
	
	public int updateArticle(Article a);
	
	public int deleteArticle(Article a);
	
	public List<Article> getAllArticle();
	
	public List<Article> getAllArticleFromCategoty(Category c);
}
