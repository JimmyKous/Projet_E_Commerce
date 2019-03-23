package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;

@Service("adService")
@Transactional
public class AdminServiceImpl implements IAdminService {

	// Transform UML to Java Association
	@Autowired
	private IAdminDao adDao;
	
	//setter for injection of dependance
	public void setAdDao(IAdminDao adDao) {
		this.adDao = adDao;
	}

	@Override
	public Admin isExist(Admin ad) {
		return adDao.isExist(ad);
	}

}
