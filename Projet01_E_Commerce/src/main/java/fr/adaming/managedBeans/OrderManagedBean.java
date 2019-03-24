package fr.adaming.managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Order;
import fr.adaming.service.IOrderService;

@ManagedBean(name = "oMB")
@RequestScoped
public class OrderManagedBean {
	// Transform UML association to JAVA
	@ManagedProperty(value="#{orderService}")
	IOrderService orderService;


	// attributes
	private Order order;
	private HttpSession mySession;

	// empty constructor
	public OrderManagedBean() {
		this.order = new Order();
		this.mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	// getters and setters
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public HttpSession getMySession() {
		return mySession;
	}

	public void setMySession(HttpSession mySession) {
		this.mySession = mySession;
	}

	//work method
	public String addOrder() {
		Order order = orderService.addOrder(order);
		return null;
	}
	
	public String viewOrder(){
		List<Order> listeOrder = orderService.getAllOrder();
		mySession.setAttribute("listeO", listeOrder);
		return null;
	}
}
