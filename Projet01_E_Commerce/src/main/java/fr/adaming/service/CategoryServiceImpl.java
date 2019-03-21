package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategoryDao;
import fr.adaming.model.Category;

@Service("catService")
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	// Transform UML to Java Association
	@Autowired
	private ICategoryDao catDao;

	// setter for injection of dependance
	public void setCatDao(ICategoryDao catDao) {
		this.catDao = catDao;
	}

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
