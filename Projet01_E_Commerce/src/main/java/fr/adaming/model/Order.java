package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_o")
	private int id;
	
	@Column(name="adress_o")
	private Adress adress;
	
	// Transform UML to Java Association
	@ManyToOne
	@JoinColumn(name="c_id", referencedColumnName="id_c")
	private Customer customer;

	@Transient
	private Basket basket;
	@Transient
	private List<OrderLine> listOL;

	// Constructor
	public Order() {
		super();
	}

	public Order(int id, Adress adress, Customer customer, Basket basket) {
		super();
		this.id = id;
		this.adress = adress;
		this.customer = customer;
		this.basket = basket;
	}

	public Order(Adress adress, Customer customer, Basket basket) {
		super();
		this.adress = adress;
		this.customer = customer;
		this.basket = basket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public List<OrderLine> getListOL() {
		return listOL;
	}

	public void setListOL(List<OrderLine> listOL) {
		this.listOL = listOL;
	}


	
}
