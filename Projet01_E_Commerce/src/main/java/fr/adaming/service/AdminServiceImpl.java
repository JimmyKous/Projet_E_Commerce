package fr.adaming.Service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.Dao.AdminDaoImpl;
import fr.adaming.Dao.IAdminDao;
import fr.adaming.model.Admin;

@Stateful
public class AdminServiceImpl implements IAdminService {

	// Transform UML to Java Association
	@EJB
	private IAdminDao adDao = new AdminDaoImpl();

	@Override
	public Admin isExist(Admin ad) {
		return adDao.isExist(ad);
	}

}
