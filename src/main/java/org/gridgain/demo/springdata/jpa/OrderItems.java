package org.gridgain.demo.springdata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CO.ORDERITEMS")
public class OrderItems {

	@Id
	@Column(name = "ORDER_ID")
	private Integer id;
	@Column(name = "LINE_ITEM_ID")
	private Integer lineItemId;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Products product;
	@Column(name = "UNIT_PRICE")
	private Integer unitPrice;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "SHIPMENT_ID")
	private Shipments shipment;

	public OrderItems() {
	}

	public OrderItems(Integer id, Integer lineItemId, Products product, Integer unitPrice, Integer quantity,
			Shipments shipment) {
		this.id = id;
		this.lineItemId = lineItemId;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.shipment = shipment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Integer lineItemId) {
		this.lineItemId = lineItemId;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Shipments getShipment() {
		return shipment;
	}

	public void setShipment(Shipments shipment) {
		this.shipment = shipment;
	}

}