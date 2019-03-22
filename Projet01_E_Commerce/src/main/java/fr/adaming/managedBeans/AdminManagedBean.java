package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;
import fr.adaming.service.IArticleService;
import fr.adaming.service.ICategoryService;

@SuppressWarnings("serial")
@ManagedBean(name = "adMB")
@RequestScoped
public class AdminManagedBean implements Serializable {

	// Attributes
	private Admin admin;

	// Transform UML to Java Association
	@ManagedProperty(value = "#{adService}")
	private IAdminService adService;
	
	@ManagedProperty(value = "#{catService}")
	private ICategoryService catService;
	
	@ManagedProperty(value = "#{artService}")
	private IArticleService artService;
	
	// Constructor
	public AdminManagedBean() {
		this.admin = new Admin();
	}

	// Setter for Dependance Injection
	public void setAdService(IAdminService adService) {
		this.adService = adService;
	}
	
	public void setCatService(ICategoryService catService) {
		this.catService = catService;
	}

	public void setArtService(IArticleService artService) {
		this.artService = artService;
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

		if (adOut != null) {

			// Save Admin in session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adSession", adOut);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listCat", catService.getAllCategory());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listArt", artService.getAllArticle());
			return "admin";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Adresse Mail et/ou Mot de Passe erroné(s)"));
			return "login";
		}

	}

}
