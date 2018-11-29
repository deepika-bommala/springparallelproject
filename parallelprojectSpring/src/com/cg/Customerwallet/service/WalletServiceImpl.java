package com.cg.Customerwallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Customerwallet.dao.IWalletDao;
import com.cg.Customerwallet.dto.CustomerWallet;
import com.cg.Customerwallet.dto.Transactions;

@Service("walSer")
@Transactional
public class WalletServiceImpl implements IWalletService {
	@Autowired
	IWalletDao walDao;

	@Override
	public CustomerWallet createAccount(CustomerWallet custWallet) {

		if (walDao.save(custWallet)) {
			return custWallet;
		}

		return null;

	}

	@Override
	public CustomerWallet showBalance(String mobileno) {
		CustomerWallet cu=walDao.findOne(mobileno);
		return cu;
				
				
		
	}

	@Override
	public CustomerWallet fundTransfer(String sourceMobileNo,
			String targetMobileNo, double amount) {
		CustomerWallet custWal = withdrawAmount(sourceMobileNo, amount);
	
		depositAmount(targetMobileNo, amount);
	
		Transactions trans=new Transactions(sourceMobileNo,"transfered",amount);
		walDao.create(trans);
		

		Transactions tran=new Transactions(targetMobileNo,"recieved",amount);
		walDao.create(tran);
		
	
		
		return custWal;

	}

	@Override
	public CustomerWallet depositAmount(String mobileNo, double amount) {
		double Amt;
		String trantype="deposit";
		CustomerWallet custWallet = walDao.findOne(mobileNo);
		 Amt = custWallet.getBalance();

		double depAmt = amount + Amt;
		custWallet.setBalance(depAmt);
		walDao.save(custWallet);
		Transactions tran=new Transactions(mobileNo,trantype,amount);
		walDao.create(tran);
		return custWallet;
		
		

	}

	@Override
	public CustomerWallet withdrawAmount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		double Amt=0;
		CustomerWallet custWallet = walDao.findOne(mobileNo);
		 Amt = custWallet.getBalance();

		double depAmt = Amt - amount;
		custWallet.setBalance(depAmt);
		walDao.save(custWallet);
	
		Transactions tran=new Transactions(mobileNo,"withdrawn",amount);
		walDao.create(tran);
		return custWallet;

	}

	@Override
	public List<CustomerWallet> showAllDetails() {

		return walDao.showAllDetails();
	}
	@Override
	public List<Transactions> getAll(String mobile) {
		// TODO Auto-generated method stub
		List<Transactions> list = null;
		list = walDao.getAll(mobile);
		//System.out.println(list);
		return list;
	}

	@Override
	public boolean checkMobileNo(String mobileNo) {
		List<CustomerWallet> li=walDao.showAllDetails();
		for(CustomerWallet List:li)
		{
			if(List.getMobNo()==mobileNo)
			{
				return true;
			}
			
		}
		return false;
	}

}
