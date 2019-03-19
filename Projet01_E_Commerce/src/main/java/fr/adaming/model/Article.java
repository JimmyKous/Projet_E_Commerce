package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="articles")
public class Article {
	
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_art")
	private int idArt;
	
	@Column(name="designation_art")
	private String designation;
	
	@Column(name="description_art")
	private String description;
	
	@Column(name="price_art")
	private double price;
	
	@Column(name="stock_art")
	private String stock;
	
	
	@Column(name="picture_art")
	@Lob
	private byte[] picture;
	
	@Transient
	private String img;
	
	// Transform UML to Java Association
	@ManyToOne
	@JoinColumn(name="id_cat_art", referencedColumnName="id_cat")
	private Category category;
	
	@OneToOne(mappedBy="article")
	private OrderLine orderLine;

	public Article() {
		super();
	}

	public Article(String designation, String description, double price, String stock, byte[] picture,
			Category category) {
		super();
		this.designation = designation;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.picture = picture;
		this.category = category;
	}

	public Article(int idArt, String designation, String description, double price, String stock, byte[] picture,
			Category category) {
		super();
		this.idArt = idArt;
		this.designation = designation;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.picture = picture;
		this.category = category;
	}

	public int getIdArt() {
		return idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
