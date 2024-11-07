package org.gridgain.demo.springdata.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Shipments {

	@QuerySqlField(index = true)
	private Integer SHIPMENT_ID;
	@QuerySqlField
	private Integer STORE_ID;
	@QuerySqlField
	private Integer CUSTOMER_ID;
	@QuerySqlField
	private String DELIVERY_ADDRESS;
	@QuerySqlField
	private String SHIPMENT_STATUS;

	public Shipments() {
	}

	public Shipments(Integer SHIPMENT_ID, Integer STORE_ID, Integer CUSTOMER_ID, String DELIVERY_ADDRESS,
			String SHIPMENT_STATUS) {
		this.SHIPMENT_ID = SHIPMENT_ID;
		this.STORE_ID = STORE_ID;
		this.CUSTOMER_ID = CUSTOMER_ID;
		this.DELIVERY_ADDRESS = DELIVERY_ADDRESS;
		this.SHIPMENT_STATUS = SHIPMENT_STATUS;
	}

	public Integer getShipment_id() {
		return SHIPMENT_ID;
	}

	public void setShipment_id(Integer SHIPMENT_ID) {
		this.SHIPMENT_ID = SHIPMENT_ID;
	}

	public Integer getStore_id() {
		return STORE_ID;
	}

	public void setStore_id(Integer STORE_ID) {
		this.STORE_ID = STORE_ID;
	}

	public Integer getCustomer_id() {
		return CUSTOMER_ID;
	}

	public void setCustomer_id(Integer CUSTOMER_ID) {
		this.CUSTOMER_ID = CUSTOMER_ID;
	}

	public String getDelivery_address() {
		return DELIVERY_ADDRESS;
	}

	public void setDelivery_address(String DELIVERY_ADDRESS) {
		this.DELIVERY_ADDRESS = DELIVERY_ADDRESS;
	}

	public String getShipment_status() {
		return SHIPMENT_STATUS;
	}

	public void setShipment_status(String SHIPMENT_STATUS) {
		this.SHIPMENT_STATUS = SHIPMENT_STATUS;
	}

}