package fr.adaming.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

import fr.adaming.model.Article;
import fr.adaming.service.IArticleService;

@ManagedBean(name="artMB")
@RequestScoped
public class ArticleManagedBean {

	// Transform UML to Java Association
	@ManagedProperty(value="artService")
	private IArticleService artService;

	// attributes

	private Article article;
	private HttpSession mySession;
	// to add a photo in the DB
	private UploadedFile image;

	// constructors
	public ArticleManagedBean() {
		this.article = new Article();
		this.mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.image = null;
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
		Article a = artService.createArticle(article);
		
			return "viewAllArticles";

		}
	}


