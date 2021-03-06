package fr.adaming.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

import fr.adaming.model.Article;
import fr.adaming.model.Category;
import fr.adaming.service.ICategoryService;

@ManagedBean(name = "catMB")
@RequestScoped
public class CategoryManagedBean {

	// Transform UML to Java Association
	@ManagedProperty(value="#{catService}")
	private ICategoryService catService;


	// Attributes
	private Category category;
	private List<Article> articles;
	private HttpSession mySession;
	private UploadedFile image;
	private Boolean indice;

	// Constructors
	public CategoryManagedBean() {
		this.category = new Category();
		this.mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.image = null;
		this.indice = false;
	}
	
	@PostConstruct
	public void init() {
	List<Category> listCat = catService.getAllCategory();
	mySession.setAttribute("listCat", listCat);
	}

	// Setter for Dependency Injection
	public void setCatService(ICategoryService catService) {
		this.catService = catService;
	}

	// Getters & Setters
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Boolean getIndice() {
		return indice;
	}

	public void setIndice(Boolean indice) {
		this.indice = indice;
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
			List<Category> listCat = catService.getAllCategory();
			mySession.setAttribute("listCat", listCat);
			return "viewAllCategory";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Add Category Failed"));
			return "addCategory";
		}

	}
	
	public String updateCategory() {
		if(this.image!=null){
			this.category.setPicture(this.image.getContents());
		}
		int test = catService.updateCategory(category);
		if (test !=0) {
			this.mySession.setAttribute("listCat",catService.getAllCategory());
			return "viewAllCategory";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Category Update failed"));
			return "updateCategory";
		}
	}
	
	public String deleteCategory() {
		// Appel de la m�thode Service
		int test = catService.deleteCategory(category);
		if (test !=0) {
			this.mySession.setAttribute("listCat",catService.getAllCategory());
			return "viewAllCategory";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Category Suppression failed"));
			return "deleteArticle";
		}
	}
	
	public String searchCategory() {
		this.indice = true;
		List<Category> listCat = catService.getAllCategory();
		mySession.setAttribute("listCat", listCat);
		this.category = catService.getCategory(category);
		if (this.category != null) {
			return "updateCategory";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This Category does not exist"));
			return"updateCategory";
		}
	}
	
	public String modifAuto() {
		List<Category> listCat = catService.getAllCategory();
		mySession.setAttribute("listCat", listCat);
		this.category = catService.getCategory(category);
		if (this.category != null) {
			return "updateCategory";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This Category does not exist"));
			return"updateCategory";
		}
		
	}
	
	public String modifAuto2() {
		List<Category> listCat = catService.getAllCategory();
		mySession.setAttribute("listCat", listCat);
		this.category = catService.getCategory(category);
		if (this.category != null) {
			return "deleteCategory";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This Category does not exist"));
			return"deleteCategory"; 
		}
		
	}

}
