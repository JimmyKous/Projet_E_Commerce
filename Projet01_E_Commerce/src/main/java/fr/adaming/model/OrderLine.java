package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="id_o_ol", referencedColumnName="id_o")
	private Order order;

	// Constructors
	public OrderLine() {
		super();
	}

	public OrderLine(int qtyOL, double priceOL, Article article, Order order) {
		super();
		this.qtyOL = qtyOL;
		this.priceOL = priceOL;
		this.article = article;
		this.order = order;
	}

	public OrderLine(int idOL, int qtyOL, double priceOL, Article article, Order order) {
		super();
		this.idOL = idOL;
		this.qtyOL = qtyOL;
		this.priceOL = priceOL;
		this.article = article;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrders(Order order) {
		this.order = order;
	}
	
}
