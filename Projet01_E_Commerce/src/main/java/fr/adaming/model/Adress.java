package fr.adaming.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Adress implements Serializable {
	
	// Attributes
	private int number;
	private String street;
	private int zipcode;
	private String city;
	private String country;
	
	public Adress() {
		super();
	}

	public Adress(int number, String street, int zipcode, String city, String country) {
		super();
		this.number = number;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
