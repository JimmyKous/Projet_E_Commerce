package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Persistant Entity
@Table(name="customers") // Table Name
public class Customer {

	// Attributes
	@Id // id is primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto Increment
	@Column(name="id_c") // Column name
	private int id;
	
	@Column(name="mail_c")
	private String name;
	
	@Column(name="pw_c")
	private String mail;
	
	@Column(name="adress_c")
	private String adress;
	
	// Transform UML to Java association
	@OneToMany(mappedBy="customer", cascade={CascadeType.REMOVE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private List<Order> orders;

	// Constructors
	public Customer() {
		super();
	}

	public Customer(String name, String mail, String adress) {
		super();
		this.name = name;
		this.mail = mail;
		this.adress = adress;
	}

	public Customer(String name, String mail, String adress, List<Order> orders) {
		super();
		this.name = name;
		this.mail = mail;
		this.adress = adress;
		this.orders = orders;
	}

	public Customer(int id, String name, String mail, String adress, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.adress = adress;
		this.orders = orders;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}