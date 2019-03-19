package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_o")
	private int id;
	
	@Column(name="adress_o")
	private String adress;
	
	// Transform UML to Java Association
	@ManyToOne
	@JoinColumn(name="c_id", referencedColumnName="id_c")
	private Customer customer;

	@OneToMany(mappedBy="order", cascade={CascadeType.REMOVE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private List<OrderLine> orderLines;

	// Constructor
	public Order() {
		super();
	}

	public Order(String adress, Customer customer, List<OrderLine> orderLines) {
		super();
		this.adress = adress;
		this.customer = customer;
		this.orderLines = orderLines;
	}

	public Order(int id, String adress, Customer customer, List<OrderLine> orderLines) {
		super();
		this.id = id;
		this.adress = adress;
		this.customer = customer;
		this.orderLines = orderLines;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
}
