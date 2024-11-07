package org.gridgain.demo.springdata.model;

import java.sql.Date;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Products {

	@QuerySqlField(index = true)
	private Integer PRODUCT_ID;
	@QuerySqlField
	private String PRODUCT_NAME;
	@QuerySqlField
	private Integer UNIT_PRICE;
	@QuerySqlField
	private String IMAGE_MIME_TYPE;
	@QuerySqlField
	private String IMAGE_FILENAME;
	@QuerySqlField
	private String IMAGE_CHARSET;
	@QuerySqlField
	private Date IMAGE_LAST_UPDATED;

	public Products() {
	}

	public Products(Integer PRODUCT_ID, String PRODUCT_NAME, Integer UNIT_PRICE, String IMAGE_MIME_TYPE,
			String IMAGE_FILENAME, String IMAGE_CHARSET, Date IMAGE_LAST_UPDATED) {
		this.PRODUCT_ID = PRODUCT_ID;
		this.PRODUCT_NAME = PRODUCT_NAME;
		this.UNIT_PRICE = UNIT_PRICE;
		this.IMAGE_MIME_TYPE = IMAGE_MIME_TYPE;
		this.IMAGE_FILENAME = IMAGE_FILENAME;
		this.IMAGE_CHARSET = IMAGE_CHARSET;
		this.IMAGE_LAST_UPDATED = IMAGE_LAST_UPDATED;
	}

	public Integer getProductId() {
		return PRODUCT_ID;
	}

	public void setProductId(Integer PRODUCT_ID) {
		this.PRODUCT_ID = PRODUCT_ID;
	}

	public String getProductName() {
		return PRODUCT_NAME;
	}

	public void setProductName(String PRODUCT_NAME) {
		this.PRODUCT_NAME = PRODUCT_NAME;
	}

	public Integer getUnit_price() {
		return UNIT_PRICE;
	}

	public void setUnitPrice(Integer UNIT_PRICE) {
		this.UNIT_PRICE = UNIT_PRICE;
	}

	public String getImageMimeType() {
		return IMAGE_MIME_TYPE;
	}

	public void setImageMimeType(String IMAGE_MIME_TYPE) {
		this.IMAGE_MIME_TYPE = IMAGE_MIME_TYPE;
	}

	public String getImageFilename() {
		return IMAGE_FILENAME;
	}

	public void setImageFilename(String IMAGE_FILENAME) {
		this.IMAGE_FILENAME = IMAGE_FILENAME;
	}

	public String getImage_charset() {
		return IMAGE_CHARSET;
	}

	public void setImage_charset(String IMAGE_CHARSET) {
		this.IMAGE_CHARSET = IMAGE_CHARSET;
	}

	public Date getImage_last_updated() {
		return IMAGE_LAST_UPDATED;
	}

	public void setImage_last_updated(Date IMAGE_LAST_UPDATED) {
		this.IMAGE_LAST_UPDATED = IMAGE_LAST_UPDATED;
	}

}