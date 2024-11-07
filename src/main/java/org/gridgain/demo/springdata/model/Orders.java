package org.gridgain.demo.springdata.model;

import java.sql.Timestamp;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Orders {

	@QuerySqlField(index = true)
	private Integer ORDER_ID;
	@QuerySqlField
	private Timestamp ORDER_TMS;
	@QuerySqlField
	private Integer CUSTOMER_ID;
	@QuerySqlField
	private String ORDER_STATUS;
	@QuerySqlField
	private Integer STORE_ID;

	public Orders() {
	}

	public Orders(Integer ORDER_ID, Timestamp ORDER_TMS, Integer CUSTOMER_ID, String ORDER_STATUS, Integer STORE_ID) {
		this.ORDER_ID = ORDER_ID;
		this.ORDER_TMS = ORDER_TMS;
		this.CUSTOMER_ID = CUSTOMER_ID;
		this.ORDER_STATUS = ORDER_STATUS;
		this.STORE_ID = STORE_ID;
	}

	public Integer getOrder_id() {
		return ORDER_ID;
	}

	public void setOrder_id(Integer ORDER_ID) {
		this.ORDER_ID = ORDER_ID;
	}

	public Timestamp getOrder_tms() {
		return ORDER_TMS;
	}

	public void setOrder_tms(Timestamp ORDER_TMS) {
		this.ORDER_TMS = ORDER_TMS;
	}

	public Integer getCustomer_id() {
		return CUSTOMER_ID;
	}

	public void setCustomer_id(Integer CUSTOMER_ID) {
		this.CUSTOMER_ID = CUSTOMER_ID;
	}

	public String getOrder_status() {
		return ORDER_STATUS;
	}

	public void setOrder_status(String ORDER_STATUS) {
		this.ORDER_STATUS = ORDER_STATUS;
	}

	public Integer getStore_id() {
		return STORE_ID;
	}

	public void setStore_id(Integer STORE_ID) {
		this.STORE_ID = STORE_ID;
	}

}