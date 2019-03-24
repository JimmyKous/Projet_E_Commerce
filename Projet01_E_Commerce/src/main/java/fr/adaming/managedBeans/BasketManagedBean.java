package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Adress;
import fr.adaming.model.Article;
import fr.adaming.model.Basket;
import fr.adaming.model.Customer;
import fr.adaming.model.Order;
import fr.adaming.model.OrderLine;
import fr.adaming.service.IArticleService;
import fr.adaming.service.IOrderLineService;
import fr.adaming.service.IOrderService;

@SuppressWarnings("serial")
@ManagedBean(name="basMB")
@SessionScoped
public class BasketManagedBean implements Serializable {
	
	// UML to Java Association Transformation
	@ManagedProperty(value="#{olService}")
	IOrderLineService olService;
	
	@ManagedProperty(value="#{artService}")
	IArticleService artService;
	
	@ManagedProperty(value="#{oService}")
	IOrderService oService;
	
	// Attributes
	private Customer customer;
	private Basket basket;
	private OrderLine orderLine;
	private Article article;
	private Adress adress;
	private int quantity;
	private double price;
	private double priceT;
	private int size;
	private double total;
	private String messageMail;
	private List<OrderLine> listOL;
	private List<Article> listArt;
	private HttpSession mySession;
	
	// Constructor
	public BasketManagedBean() {
	this.customer = new Customer();
	this.basket = new Basket();
	this.orderLine = new OrderLine();
	this.article = new Article();
	this.adress = new Adress();
	this.customer.setAdress(adress);
	this.listOL = new ArrayList<OrderLine>();
	this.size = listOL.size();
	this.total = 0;
	orderLine.setArticle(article);
	basket.setOlList(listOL);
	}
	
	// Getters & Setters
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	public OrderLine getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPriceT() {
		return priceT;
	}
	public void setPriceT(double priceT) {
		this.priceT = priceT;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMessageMail() {
		return messageMail;
	}
	public void setMessageMail(String messageMail) {
		this.messageMail = messageMail;
	}
	public List<OrderLine> getListOL() {
		return listOL;
	}
	public void setListOL(List<OrderLine> listOL) {
		this.listOL = listOL;
	}
	public List<Article> getListArt() {
		return listArt;
	}
	public void setListArt(List<Article> listArt) {
		this.listArt = listArt;
	}

	public void setOlService(IOrderLineService olService) {
		this.olService = olService;
	}

	public void setArtService(IArticleService artService) {
		this.artService = artService;
	}

	public void setoService(IOrderService oService) {
		this.oService = oService;
	}
	
	@PostConstruct
	public void init() {
		mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		mySession.setAttribute("listArt", artService.getAllArticle());
		mySession.setAttribute("listOL", listOL);
		mySession.setAttribute("size", size);
		mySession.setAttribute("total", total);
	}
	
	// Work Methods
	public String connecter(){
		mySession.setAttribute("listArt", artService.getAllArticle());
		return "homePageCustomer";
	}
	public String addProductToBasket() {
		OrderLine olOut = new OrderLine();
		olOut.setArticle(article);
		System.out.println(article.getDesignation());
		// Check Stock
		if (quantity <= article.getStock()){
			olOut.setQtyOL(quantity);
			this.priceT = article.getPrice()*this.quantity;
			olOut.setPriceOL(priceT);
			olOut.setArticle(article);
			// Update Stock in database
			article.setStock(article.getStock()-this.quantity);
			artService.updateArticle(article);
			this.listOL.add(olOut);
			this.size = listOL.size();
			this.total = this.total + olOut.getPriceOL();
			olOut = olService.addOrderLine(olOut);
			mySession.setAttribute("listOL", listOL);
			mySession.setAttribute("size", size);
			mySession.setAttribute("total", total);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The product has been added to your basket"));
			return "homePageCustomer";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("There is not enough available stock, try ordering less articles"));
			return "homePageCustomer";
		}
		
	}
	
	public String deleteProductFromBasket() {
		double amount = orderLine.getPriceOL();
		int test = olService.DeleteOrderLine(orderLine);
		if (test != 0) { 
			for (int i = 0; i < listOL.size(); i++) {
				if(article.getIdArt() == listOL.get(i).getArticle().getIdArt()) {
					this.total = this.total - amount;
					this.size = listOL.size();
					mySession.setAttribute("size", size);
					mySession.setAttribute("total", total);
				}
			}
			mySession.setAttribute("listOL", listOL);
			mySession.setAttribute("size", size);
			mySession.setAttribute("total", total);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The product has been deleted from your basket"));
			return "homePageCustomer";
		} 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problem encountered deleting product from your basket, try again"));
		return "basket";
	}
	
	public String validate() {
		if (this.listOL.isEmpty() == true) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The product has been deleted from your basket"));
			return "basket";
		}
		return "homePageCustomer";
	}
	
	@SuppressWarnings("unchecked")
	public String validateBasket() {
		this.listOL = (List<OrderLine>) mySession.getAttribute("listOL");
		this.basket.setOlList(this.listOL);
		customer.setAdress(adress);
		Order order = new Order(adress, customer, basket);
		Order oOut = oService.addOrder(order);
		oOut.setListOL(listOL);
		// Email
		messageMail = "Mrs/Mr"+ oOut.getCustomer().getName()+",\n We are pleased to inform you your order has been accepted and will be processed as soon as possible !"
		+"\n Please find the recapitulative of your order:"
		+ "\n" + oOut.getListOL()
		+ "\n" + oOut;
		return "thanks";
	}
	
}
