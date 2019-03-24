package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Basket implements Serializable{

	// Attributes
	private List<OrderLine> olList;

	public Basket() {
		super();
	}

	public Basket(List<OrderLine> olList) {
		super();
		this.olList = olList;
	}

	public List<OrderLine> getOlList() {
		return olList;
	}

	public void setOlList(List<OrderLine> olList) {
		this.olList = olList;
	}
}
