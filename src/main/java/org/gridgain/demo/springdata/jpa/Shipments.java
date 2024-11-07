package org.gridgain.demo.springdata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CO.SHIPMENTS")
public class Shipments {

	@Id
	@Column(name = "SHIPMENT_ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "STORE_ID")
	private Stores store;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customers customer;
	@Column(name = "DELIVERY_ADDRESS")
	private String deliveryAddress;
	@Column(name = "SHIPMENT_STATUS")
	private String status;
	
	public Shipments() {
		
	}
	
	public Shipments(Integer id, Stores store, Customers customer, String deliveryAddress, String status) {
		this.id = id;
		this.store = store;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Stores getStore() {
		return store;
	}

	public void setStore(Stores store) {
		this.store = store;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Shipments [id=" + id + ", store=" + store + ", customer=" + customer + ", deliveryAddress="
				+ deliveryAddress + ", status=" + status + "]";
	}

}