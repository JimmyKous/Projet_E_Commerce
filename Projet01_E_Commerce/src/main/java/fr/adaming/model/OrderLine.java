package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_lines")
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ol")
	private int idOL;

	@Column(name="qty_ol")
	private int qtyOL;
	
	@Column(name="price_ol")
	private double priceOL;
	
	// Transform UML to Java Association
	@OneToOne
	@JoinColumn(name="id_art_ol", referencedColumnName="id_art")
	private Article article;
	
	// Constructors
	public OrderLine() {
		super();
	}

	public OrderLine(int qtyOL, double priceOL, Article article) {
		super();
		this.qtyOL = qtyOL;
		this.priceOL = priceOL;
		this.article = article;
	}

	public OrderLine(int idOL, int qtyOL, double priceOL, Article article) {
		super();
		this.idOL = idOL;
		this.qtyOL = qtyOL;
		this.priceOL = priceOL;
		this.article = article;
	}

	// Getters & Setters
	public int getIdOL() {
		return idOL;
	}

	public void setIdOL(int idOL) {
		this.idOL = idOL;
	}

	public int getQtyOL() {
		return qtyOL;
	}

	public void setQtyOL(int qtyOL) {
		this.qtyOL = qtyOL;
	}

	public double getPriceOL() {
		return priceOL;
	}

	public void setPriceOL(double priceOL) {
		this.priceOL = priceOL;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
