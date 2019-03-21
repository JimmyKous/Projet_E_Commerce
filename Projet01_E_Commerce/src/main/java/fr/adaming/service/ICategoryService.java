package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Category;

public interface ICategoryService {

	public Category createCategory(Category c);
	
	public Category getCategory(Category c);
	
	public int updateCategory(Category c);
	
	public int deleteCategory(Category c);
	
	public List<Category> getAllCategory();
	
}
