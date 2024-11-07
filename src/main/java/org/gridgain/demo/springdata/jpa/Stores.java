package org.gridgain.demo.springdata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CO.STORES")
public class Stores {

	@Id
	@Column(name = "STORE_ID")
	private Integer id;
	@Column(name = "STORE_NAME")
	private String name;
	@Column(name = "WEB_ADDRESS")
	private String webAddress;
	@Column(name = "PHYSICAL_ADDRESS")
	private String physicalAddress;
	@Column(name = "LATITUDE")
	private Integer lattitude;
	@Column(name = "LONGITUDE")
	private Integer logitude;

	public Stores() {
		
	}
	
	public Stores(Integer id, String name, String webAddress, String physicalAddress, Integer lattitude,
			Integer logitude) {
		this.id = id;
		this.name = name;
		this.webAddress = webAddress;
		this.physicalAddress = physicalAddress;
		this.lattitude = lattitude;
		this.logitude = logitude;
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

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public Integer getLattitude() {
		return lattitude;
	}

	public void setLattitude(Integer lattitude) {
		this.lattitude = lattitude;
	}

	public Integer getLogitude() {
		return logitude;
	}

	public void setLogitude(Integer logitude) {
		this.logitude = logitude;
	}

	@Override
	public String toString() {
		return "Stores [id=" + id + ", name=" + name + ", webAddress=" + webAddress + ", physicalAddress="
				+ physicalAddress + ", lattitude=" + lattitude + ", logitude=" + logitude + "]";
	}

}