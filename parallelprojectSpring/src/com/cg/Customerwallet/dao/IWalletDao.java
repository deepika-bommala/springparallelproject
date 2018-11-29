package com.cg.Customerwallet.dao;

import java.util.List;

import com.cg.Customerwallet.dto.CustomerWallet;
import com.cg.Customerwallet.dto.Transactions;

public interface IWalletDao {

	public boolean save(CustomerWallet customerWallet);

	public CustomerWallet findOne(String mobileNo);

	public List<CustomerWallet> showAllDetails();

	public void  create(Transactions t);

	public List<Transactions> getAll(String mobile);

}
