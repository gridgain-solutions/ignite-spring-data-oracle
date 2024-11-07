package org.gridgain.demo.springdata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CO.CUSTOMERS")
public class Customers {

	@Id
	@Column(name = "CUSTOMER_ID")
	private Integer id;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "FULL_NAME")
	private String fullName;

	public Customers() {
		
	}
	
	public Customers(Integer id, String emailAddress, String fullName) {
		this.id = id;
		this.emailAddress = emailAddress;
		this.fullName = fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", emailAddress=" + emailAddress + ", fullName=" + fullName + "]";
	}

}