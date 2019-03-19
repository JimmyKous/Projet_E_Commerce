package fr.adaming.Service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Category;

@Local
public interface ICategoryService {

	public Category createCategory(Category c);
	
	public Category getCategory(Category c);
	
	public int updateCategory(Category c);
	
	public int deleteCategory(Category c);
	
	public List<Category> getAllCategory();
	
}
