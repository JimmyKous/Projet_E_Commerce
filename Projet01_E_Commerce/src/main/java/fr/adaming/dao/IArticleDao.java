package fr.adaming.Dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Article;
import fr.adaming.model.Category;

@Local
public interface IArticleDao {

	public Article createArticle(Article a);
	
	public Article getArticle(Article a);
	
	public int updateArticle(Article a);
	
	public int deleteArticle(Article a);
	
	public List<Article> getAllArticleFromCategory(Category c);
	
	public List<Article> getAllArticle();
}
