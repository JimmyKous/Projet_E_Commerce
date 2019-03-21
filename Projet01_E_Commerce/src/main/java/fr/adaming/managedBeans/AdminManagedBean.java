package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;

@SuppressWarnings("serial")
@ManagedBean(name = "adMB")
@RequestScoped
public class AdminManagedBean implements Serializable {

	// Attributes
	private Admin admin;
	private HttpSession maSession;

	// Transform UML to Java Association
	@ManagedProperty(value = "#{adService}")
	private IAdminService adService;

	// Constructor
	public AdminManagedBean() {
		this.admin = new Admin();
	}

	// Setter for Dependance Injection
	public void setAdService(IAdminService adService) {
		this.adService = adService;
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
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
			return "admin";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Adresse Mail et/ou Mot de Passe erroné(s)"));
			return "login";
		}

	}

}
