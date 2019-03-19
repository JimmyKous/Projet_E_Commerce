package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Persistant Entity
@Table(name="admins") // Table Name
public class Admin {
	
	// Attributes
	@Id // id is primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto Increment
	@Column(name="id_a") // Column name
	private int id;
	
	@Column(name="mail_a")
	private String mail;
	
	@Column(name="pw_a")
	private String pw;

	// Constructors
	public Admin() {
		super();
	}

	public Admin(String mail, String pw) {
		super();
		this.mail = mail;
		this.pw = pw;
	}

	public Admin(int id, String mail, String pw) {
		super();
		this.id = id;
		this.mail = mail;
		this.pw = pw;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
