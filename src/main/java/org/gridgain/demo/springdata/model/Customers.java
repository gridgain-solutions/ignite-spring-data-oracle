package org.gridgain.demo.springdata.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Customers {

	@QuerySqlField(index = true)
	private Integer CUSTOMER_ID;
	@QuerySqlField
	private String EMAIL_ADDRESS;
	@QuerySqlField
	private String FULL_NAME;

	public Customers () {
	}

    public Customers (Integer CUSTOMER_ID, String EMAIL_ADDRESS, String FULL_NAME) {
		this.CUSTOMER_ID = CUSTOMER_ID;
		this.EMAIL_ADDRESS = EMAIL_ADDRESS;
		this.FULL_NAME = FULL_NAME;
    }

    public Integer getCustomer_id() {
        return CUSTOMER_ID;
    }

    public void setCustomer_id(Integer CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }
    public String getEmail_address() {
        return EMAIL_ADDRESS;
    }

    public void setEmail_address(String EMAIL_ADDRESS) {
        this.EMAIL_ADDRESS = EMAIL_ADDRESS;
    }
    public String getFull_name() {
        return FULL_NAME;
    }

    public void setFull_name(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }

}