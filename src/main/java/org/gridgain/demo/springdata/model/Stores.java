package org.gridgain.demo.springdata.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import java.sql.Date;

public class Stores {

	@QuerySqlField(index = true)
	private Integer STORE_ID;
	@QuerySqlField
	private String STORE_NAME;
	@QuerySqlField
	private String WEB_ADDRESS;
	@QuerySqlField
	private String PHYSICAL_ADDRESS;
	@QuerySqlField
	private Integer LATITUDE;
	@QuerySqlField
	private Integer LONGITUDE;
	@QuerySqlField
	private Object LOGO;
	@QuerySqlField
	private String LOGO_MIME_TYPE;
	@QuerySqlField
	private String LOGO_FILENAME;
	@QuerySqlField
	private String LOGO_CHARSET;
	@QuerySqlField
	private Date LOGO_LAST_UPDATED;

	public Stores () {
	}

    public Stores (Integer STORE_ID, String STORE_NAME, String WEB_ADDRESS, String PHYSICAL_ADDRESS, Integer LATITUDE, Integer LONGITUDE, Object LOGO, String LOGO_MIME_TYPE, String LOGO_FILENAME, String LOGO_CHARSET, Date LOGO_LAST_UPDATED) {
		this.STORE_ID = STORE_ID;
		this.STORE_NAME = STORE_NAME;
		this.WEB_ADDRESS = WEB_ADDRESS;
		this.PHYSICAL_ADDRESS = PHYSICAL_ADDRESS;
		this.LATITUDE = LATITUDE;
		this.LONGITUDE = LONGITUDE;
		this.LOGO = LOGO;
		this.LOGO_MIME_TYPE = LOGO_MIME_TYPE;
		this.LOGO_FILENAME = LOGO_FILENAME;
		this.LOGO_CHARSET = LOGO_CHARSET;
		this.LOGO_LAST_UPDATED = LOGO_LAST_UPDATED;
    }

    public Integer getStore_id() {
        return STORE_ID;
    }

    public void setStore_id(Integer STORE_ID) {
        this.STORE_ID = STORE_ID;
    }
    public String getStore_name() {
        return STORE_NAME;
    }

    public void setStore_name(String STORE_NAME) {
        this.STORE_NAME = STORE_NAME;
    }
    public String getWeb_address() {
        return WEB_ADDRESS;
    }

    public void setWeb_address(String WEB_ADDRESS) {
        this.WEB_ADDRESS = WEB_ADDRESS;
    }
    public String getPhysical_address() {
        return PHYSICAL_ADDRESS;
    }

    public void setPhysical_address(String PHYSICAL_ADDRESS) {
        this.PHYSICAL_ADDRESS = PHYSICAL_ADDRESS;
    }
    public Integer getLatitude() {
        return LATITUDE;
    }

    public void setLatitude(Integer LATITUDE) {
        this.LATITUDE = LATITUDE;
    }
    public Integer getLongitude() {
        return LONGITUDE;
    }

    public void setLongitude(Integer LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }
    public Object getLogo() {
        return LOGO;
    }

    public void setLogo(Object LOGO) {
        this.LOGO = LOGO;
    }
    public String getLogo_mime_type() {
        return LOGO_MIME_TYPE;
    }

    public void setLogo_mime_type(String LOGO_MIME_TYPE) {
        this.LOGO_MIME_TYPE = LOGO_MIME_TYPE;
    }
    public String getLogo_filename() {
        return LOGO_FILENAME;
    }

    public void setLogo_filename(String LOGO_FILENAME) {
        this.LOGO_FILENAME = LOGO_FILENAME;
    }
    public String getLogo_charset() {
        return LOGO_CHARSET;
    }

    public void setLogo_charset(String LOGO_CHARSET) {
        this.LOGO_CHARSET = LOGO_CHARSET;
    }
    public Date getLogo_last_updated() {
        return LOGO_LAST_UPDATED;
    }

    public void setLogo_last_updated(Date LOGO_LAST_UPDATED) {
        this.LOGO_LAST_UPDATED = LOGO_LAST_UPDATED;
    }

}