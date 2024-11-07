package org.gridgain.demo.springdata.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CO.PRODUCTS")
public class Products {

	@Id
	@Column(name = "PRODUCT_ID")
	private Integer id;
	@Column(name = "PRODUCT_NAME")
	private String name;
	@Column(name = "UNIT_PRICE")
	private Integer unitPrice;
	@Column(name = "IMAGE_LAST_UPDATED")
	private Date lastUpdated;

	public Products() {

	}

	public Products(Integer id, String name, Integer unitPrice, Date lastUpdated) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.lastUpdated = lastUpdated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", lastUpdated=" + lastUpdated
				+ "]";
	}

}