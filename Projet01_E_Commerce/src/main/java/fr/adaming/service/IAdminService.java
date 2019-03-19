package fr.adaming.Service;

import javax.ejb.Local;

import fr.adaming.model.Admin;

@Local
public interface IAdminService {
	
	public Admin isExist(Admin ad);

}
