package fr.adaming.service;

import fr.adaming.dao.AdminDaoImpl;
import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;


public class AdminServiceImpl implements IAdminService {

	// Transform UML to Java Association
	private IAdminDao adDao = new AdminDaoImpl();

	@Override
	public Admin isExist(Admin ad) {
		return adDao.isExist(ad);
	}

}
