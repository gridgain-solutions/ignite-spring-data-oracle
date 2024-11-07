package org.gridgain.demo.springdata.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Inventory {

	@QuerySqlField(index = true)
	private Integer INVENTORY_ID;
	@QuerySqlField
	private Integer STORE_ID;
	@QuerySqlField
	private Integer PRODUCT_ID;
	@QuerySqlField
	private Integer PRODUCT_INVENTORY;

	public Inventory () {
	}

    public Inventory (Integer INVENTORY_ID, Integer STORE_ID, Integer PRODUCT_ID, Integer PRODUCT_INVENTORY) {
		this.INVENTORY_ID = INVENTORY_ID;
		this.STORE_ID = STORE_ID;
		this.PRODUCT_ID = PRODUCT_ID;
		this.PRODUCT_INVENTORY = PRODUCT_INVENTORY;
    }

    public Integer getInventory_id() {
        return INVENTORY_ID;
    }

    public void setInventory_id(Integer INVENTORY_ID) {
        this.INVENTORY_ID = INVENTORY_ID;
    }
    public Integer getStore_id() {
        return STORE_ID;
    }

    public void setStore_id(Integer STORE_ID) {
        this.STORE_ID = STORE_ID;
    }
    public Integer getProduct_id() {
        return PRODUCT_ID;
    }

    public void setProduct_id(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }
    public Integer getProduct_inventory() {
        return PRODUCT_INVENTORY;
    }

    public void setProduct_inventory(Integer PRODUCT_INVENTORY) {
        this.PRODUCT_INVENTORY = PRODUCT_INVENTORY;
    }

}