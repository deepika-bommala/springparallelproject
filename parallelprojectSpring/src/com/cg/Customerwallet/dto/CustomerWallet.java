package com.cg.Customerwallet.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;




@Entity
@Table(name ="customer_wallet")
public class CustomerWallet {
	
	@Column(name ="cust_name")
	@NotEmpty(message="name should not be empty")
	@Size(min=3, max=15,message ="name should have min length")
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String custName;
	@Id
	@Column(name = "cust_mobNo")
	@NotEmpty(message="mobile number should not be empty")
	@Pattern(regexp ="[6-9][0-9]{9}")
	private String mobNo;
	@Column(name ="cust_balance")
	@NotNull(message="balance should not be empty")
	@Pattern(regexp="[1-9][0-9]+")
	private double balance;

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public CustomerWallet(String custName, String mobNo, double balance) {
		super();
		this.custName = custName;
		this.mobNo = mobNo;
		this.balance = balance;
	}
	public CustomerWallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerWallet [custName=" + custName + ", mobNo=" + mobNo
				+ ", balance=" + balance + "]";
	}
	
	

}
