package com.semnome.lojajogos.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semnome.lojajogos.entities.auxiliar.OrderItemAux;

@Entity
@Table(name = "ItensPedidos")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemAux id = new OrderItemAux();
	
	private Integer quantity;
	private Double unitPrice;
	
	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity, Double unitPrice) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Double getItensPrice() {
		return unitPrice*quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
