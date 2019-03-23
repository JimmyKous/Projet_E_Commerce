package fr.adaming.managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

import fr.adaming.model.Article;
import fr.adaming.model.Category;
import fr.adaming.service.IArticleService;
import fr.adaming.service.ICategoryService;

@ManagedBean(name="artMB")
@RequestScoped
public class ArticleManagedBean {

	// Transform UML to Java Association
	@ManagedProperty(value="#{artService}")
	private IArticleService artService;
	
	@ManagedProperty(value="#{catService}")
	private ICategoryService catService;

	// attributes

	private Article article;
	private HttpSession mySession;
	// to add a photo in the DB
	private UploadedFile image;
	private int categoryName;

	// constructors
	public ArticleManagedBean() {
		this.article = new Article();
		this.mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.image = null;
	}
	
	//setters for dependency's injection
	public void setArtService(IArticleService artService) {
		this.artService = artService;
	}
	
	public void setCatService(ICategoryService catService) {
		this.catService = catService;
	}

	// getters and setters
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public HttpSession getMySession() {
		return mySession;
	}

	public void setMySession(HttpSession mySession) {
		this.mySession = mySession;
	}

	public int getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(int categoryName) {
		this.categoryName = categoryName;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

	// work methods
	public String addArticle() {
		if(this.image!=null){
			this.article.setPicture(this.image.getContents());
		}
		Category c = new Category();
		c.setIdCat(categoryName);
		this.article.setCategory(catService.getCategory(c));
		Article a = artService.createArticle(article);
		if (a!=null) {
			List<Article> listArt = artService.getAllArticle();
			mySession.setAttribute("listArt", listArt);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Add Article Failed"));
			return "addArticleAdmin";
		}
	}
}


