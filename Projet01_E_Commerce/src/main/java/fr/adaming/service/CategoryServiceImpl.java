package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.CategoryDaoImpl;
import fr.adaming.dao.ICategoryDao;
import fr.adaming.model.Category;


public class CategoryServiceImpl implements ICategoryService {

	// Transform UML to Java Association
	
	ICategoryDao catDao = new CategoryDaoImpl();
		
	@Override
	public Category createCategory(Category c) {
		return catDao.createCategory(c);
	}

	@Override
	public Category getCategory(Category c) {
		return catDao.getCategory(c);
	}

	@Override
	public int updateCategory(Category c) {
		return catDao.updateCategory(c);
	}

	@Override
	public int deleteCategory(Category c) {
		return catDao.deleteCategory(c);
	}

	@Override
	public List<Category> getAllCategory() {
		return catDao.getAllCategory();
	}

	
}
