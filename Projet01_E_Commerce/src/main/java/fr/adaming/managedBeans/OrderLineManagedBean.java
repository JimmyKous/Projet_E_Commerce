package fr.adaming.managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Order;
import fr.adaming.model.OrderLine;
import fr.adaming.service.IOrderLineService;

@ManagedBean(name = "olMB")
@RequestScoped
public class OrderLineManagedBean {

	// transform UML association to JAVA
	@ManagedProperty(value = "#{olService}")
	private IOrderLineService orderLineService;
	

	// attributes
	private OrderLine orderLine;
	private HttpSession mySession;

	// empty constructor
	public OrderLineManagedBean() {
		this.orderLine = new OrderLine();
		this.mySession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	// getters and setters

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public HttpSession getMySession() {
		return mySession;
	}

	public void setMySession(HttpSession mySession) {
		this.mySession = mySession;
	}

	// work methods
	public String addOrderLine() {
		OrderLine ol = orderLineService.addOrderLine(orderLine);
		return null;
	}
	public String viewAllOrderLine(){
		List<OrderLine> listeOL = orderLineService.getAllOrderLine();
		mySession.setAttribute("listeOL", listeOL);
		return null;
	}
}
