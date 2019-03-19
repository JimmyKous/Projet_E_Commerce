package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="categories")
public class Category {
	
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto Increment
	@Column(name="id_cat")
	private int idCat;
	
	@Column(name="name_cat")
	private String categoryName;
	
	@Column(name="description_cat")
	private String description;
	
	@Column(name="picture_cat")
	@Lob
	private byte[] picture;
	
	@Transient
	private String img;
	
	// Transform UML to Java Association
	@OneToMany(mappedBy="category", cascade={CascadeType.REMOVE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private List<Article> articles;

	// Constructors
	public Category() {
		super();
	}

	public Category(String categoryName, String description, byte[] picture, String img, List<Article> articles) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
		this.img = img;
		this.articles = articles;
	}

	public Category(int idCat, String categoryName, String description, byte[] picture, String img,
			List<Article> articles) {
		super();
		this.idCat = idCat;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
		this.img = img;
		this.articles = articles;
	}

	// Getters & Setters
	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}