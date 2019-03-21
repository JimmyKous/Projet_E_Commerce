package fr.adaming.managedBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.Service.IAdminService;
import fr.adaming.Service.IArticleService;
import fr.adaming.Service.ICategoryService;
import fr.adaming.model.Admin;

@ManagedBean(name="adMB")
@SessionScoped
public class AdminManagedBean {

	// Transform UML to Java Association
	@EJB
	private IAdminService adService;
	
	// Attributes
	private Admin admin;
	
	// Constructor
	public AdminManagedBean() {
		this.admin = new Admin();
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// Work Methods
	public String logAdmin() {
		
		// Get Formateur with Mail and Pass
		Admin adOut = adService.isExist(admin);
		
		if (adOut!=null){
			
			// Save Admin in session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adSession", adOut);
			
			return "admin";
			
		} else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Adresse Mail et/ou Mot de Passe erroné(s)"));
			
			return "login";
		}
		
	}
	
	
}
