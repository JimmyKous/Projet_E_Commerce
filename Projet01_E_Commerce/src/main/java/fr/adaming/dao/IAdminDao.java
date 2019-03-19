package fr.adaming.Dao;

import javax.ejb.Local;

import fr.adaming.model.Admin;

@Local
public interface IAdminDao {
	
	public Admin isExist(Admin ad);

}
