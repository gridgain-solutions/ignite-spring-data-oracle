package org.gridgain.demo.springdata.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class OrderItems {

	@QuerySqlField(index = true)
	private Integer ORDER_ID;
	@QuerySqlField
	private Integer LINE_ITEM_ID;
	@QuerySqlField
	private Integer PRODUCT_ID;
	@QuerySqlField
	private Integer UNIT_PRICE;
	@QuerySqlField
	private Integer QUANTITY;
	@QuerySqlField
	private Integer SHIPMENT_ID;

	public OrderItems() {
	}

	public OrderItems(Integer ORDER_ID, Integer LINE_ITEM_ID, Integer PRODUCT_ID, Integer UNIT_PRICE, Integer QUANTITY,
			Integer SHIPMENT_ID) {
		this.ORDER_ID = ORDER_ID;
		this.LINE_ITEM_ID = LINE_ITEM_ID;
		this.PRODUCT_ID = PRODUCT_ID;
		this.UNIT_PRICE = UNIT_PRICE;
		this.QUANTITY = QUANTITY;
		this.SHIPMENT_ID = SHIPMENT_ID;
	}

	public Integer getOrder_id() {
		return ORDER_ID;
	}

	public void setOrder_id(Integer ORDER_ID) {
		this.ORDER_ID = ORDER_ID;
	}

	public Integer getLine_item_id() {
		return LINE_ITEM_ID;
	}

	public void setLine_item_id(Integer LINE_ITEM_ID) {
		this.LINE_ITEM_ID = LINE_ITEM_ID;
	}

	public Integer getProduct_id() {
		return PRODUCT_ID;
	}

	public void setProduct_id(Integer PRODUCT_ID) {
		this.PRODUCT_ID = PRODUCT_ID;
	}

	public Integer getUnit_price() {
		return UNIT_PRICE;
	}

	public void setUnit_price(Integer UNIT_PRICE) {
		this.UNIT_PRICE = UNIT_PRICE;
	}

	public Integer getQuantity() {
		return QUANTITY;
	}

	public void setQuantity(Integer QUANTITY) {
		this.QUANTITY = QUANTITY;
	}

	public Integer getShipment_id() {
		return SHIPMENT_ID;
	}

	public void setShipment_id(Integer SHIPMENT_ID) {
		this.SHIPMENT_ID = SHIPMENT_ID;
	}

}