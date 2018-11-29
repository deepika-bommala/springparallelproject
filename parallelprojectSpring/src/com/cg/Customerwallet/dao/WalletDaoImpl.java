package com.cg.Customerwallet.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import org.springframework.stereotype.Repository;

import com.cg.Customerwallet.dto.CustomerWallet;
import com.cg.Customerwallet.dto.Transactions;
@Repository("walDao")
public class WalletDaoImpl implements IWalletDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean save(CustomerWallet customerWallet) {
		
		if(customerWallet!=null){
				//transaction begin
		entityManager.persist(customerWallet);				// sends it to data base
		entityManager.flush();		//end transaction
		return true;							// successful transaction
		}
		
		return false;	
	
	}

	@Override
	public CustomerWallet findOne(String mobileNo) {
		 CustomerWallet cWallet=entityManager.find(CustomerWallet.class, mobileNo);
		return cWallet ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerWallet> showAllDetails() {
		
		Query queryOne=entityManager.createQuery("FROM CustomerWallet");
		List<CustomerWallet> myList=queryOne.getResultList();
		return myList;

	}

	@Override
	public void  create(Transactions t) {
		entityManager.persist(t);
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Transactions> getAll(String mobile){									//receives trasactions from database
		List<Transactions> list= new ArrayList<Transactions>();				//creating list to store all transactions
		Query qry=entityManager.createQuery("FROM Transactions where mobileNo =:mobile");
		
		qry.setParameter("mobile",mobile);
		
		list=qry.getResultList();
	//	System.out.println(list);
		
		return list;
}


	
	}
