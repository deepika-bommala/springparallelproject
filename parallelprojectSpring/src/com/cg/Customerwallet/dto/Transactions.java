package com.cg.Customerwallet.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tranId;
	@Column(name ="mob_no")
	private String mobileNo;
	@Column(name="tran_type")
	private String tranType;
	@Column(name="amount")
	private double amount;
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions( String mobileNo, String tranType,
			double amount) {
		super();
	
		this.mobileNo = mobileNo;
		this.tranType = tranType;
		this.amount = amount;
	}
	

}
