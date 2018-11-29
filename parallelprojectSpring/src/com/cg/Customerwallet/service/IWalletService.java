package com.cg.Customerwallet.service;

import java.util.List;

import com.cg.Customerwallet.dto.CustomerWallet;
import com.cg.Customerwallet.dto.Transactions;

public interface IWalletService {
	public CustomerWallet createAccount(CustomerWallet custWallet);
	public CustomerWallet showBalance (String mobileno);
	public CustomerWallet fundTransfer (String sourceMobileNo,String targetMobileNo, double amount);
	public CustomerWallet depositAmount (String mobileNo,double amount );
	public CustomerWallet withdrawAmount(String mobileNo, double amount);
	public List<CustomerWallet> showAllDetails();
	public List<Transactions> getAll(String mobile);
	public boolean checkMobileNo(String mobileNo);


	}

