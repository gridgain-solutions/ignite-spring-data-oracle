package org.gridgain.demo.springdata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CO.INVENTORY")
public class Inventory {

	@Id
	@Column(name = "INVENTORY_ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customers customer;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Products product;
	@Column(name = "PRODUCT_INVENTORY")
	private Integer inventory;

	public Inventory() {
		
	}
	
	public Inventory(Integer id, Customers customer, Products product, Integer inventory) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.inventory = inventory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", customer=" + customer + ", product=" + product + ", inventory=" + inventory
				+ "]";
	}

}