package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Article;
import fr.adaming.model.Category;

public interface IArticleDao {

	public Article createArticle(Article a);
	
	public Article getArticle(Article a);
	
	public int updateArticle(Article a);
	
	public int deleteArticle(Article a);
	
	public List<Article> getAllArticleFromCategory(Category c);
	
	public List<Article> getAllArticle();
}
