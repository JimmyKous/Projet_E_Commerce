package fr.adaming.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

import fr.adaming.Service.IArticleService;
import fr.adaming.Service.ICategoryService;
import fr.adaming.model.Article;
import fr.adaming.model.Category;

@ManagedBean(name = "catMB")
@SessionScoped
public class CategoryManagedBean {

	// Transform UML to Java Association
	@EJB
	private ICategoryService catService;

	@EJB
	private IArticleService artService;

	// Attributes
	private Category category;
	private List<Article> articles;
	private HttpSession mySession;
	private UploadedFile image;

	// Constructors
	public CategoryManagedBean() {
		this.category = new Category();
		this.mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.image = null;
	}

	// Getters & Setters
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

	// Work Methods
	public String addCategory() {
		
		if(this.image!=null) {
			this.category.setPicture(this.image.getContents());
		}
		
		Category c = catService.createCategory(category);

		if (c != null) {
			// Recover new Category List
			List<Category> listCat = catService.getAllCategory();

			// Add List to Session
			mySession.setAttribute("listCat", listCat);

			// Calling home account page
			return "viewAllCategory";

		} else {
			// Add error message
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Add Account Failed"));

			// Calling same page
			return "addCategory";
		}

	}

}
