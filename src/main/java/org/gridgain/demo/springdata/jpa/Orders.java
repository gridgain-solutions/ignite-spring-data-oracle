package org.gridgain.demo.springdata.jpa;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CO.ORDERS")
public class Orders {

	@Id
	@Column(name = "ORDER_ID")
	private Integer id;
	@Column(name = "ORDER_TMS")
	private Timestamp orderTime;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customers customer;
	@Column(name = "ORDER_STATUS")
	private String orderStatus;
	@ManyToOne
	@JoinColumn(name = "STORE_ID")
	private Stores store;

	public Orders() {
	}
	
	public Orders(Integer id, Timestamp orderTime, Customers customer, String orderStatus, Stores store) {
		this.id = id;
		this.orderTime = orderTime;
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Stores getStore() {
		return store;
	}

	public void setStore(Stores store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderTime=" + orderTime + ", customer=" + customer + ", orderStatus="
				+ orderStatus + ", store=" + store + "]";
	}

}