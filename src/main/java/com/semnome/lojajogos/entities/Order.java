package com.semnome.lojajogos.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.semnome.lojajogos.entities.Enum.OrderStatus;

@Entity
@Table(name = "pedidos")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataCompra;
	
	private Integer orderStatus;
	
	@ManyToOne()
	//@JoinColumn(name = "client_id")
	@JoinColumns({
		@JoinColumn(name = "client_id", referencedColumnName = "id"),
		@JoinColumn(name = "client_name", referencedColumnName = "name")	
	})
	private Client client;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> itensPedidos = new HashSet<>();
	
	public Order() {
	}

	public Order(Instant dataCompra, OrderStatus orderStatus, Client client) {
		this.dataCompra = dataCompra;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Instant dataCompra) {
		this.dataCompra = dataCompra;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCodigo();
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItensPedidos() {
		return itensPedidos;
	}
	
	public Double getTotalPrice() {
		Double total = 0.0;
		
		for(OrderItem oi: itensPedidos) {
			total += oi.getItensPrice();
		}
		
		return total;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
