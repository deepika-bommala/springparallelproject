package com.cg.Customerwallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.Customerwallet.dto.CustomerWallet;
import com.cg.Customerwallet.dto.Transactions;
import com.cg.Customerwallet.service.IWalletService;

@Controller
public class MyController {
	@Autowired
	IWalletService walSer;

	@RequestMapping(value = "run", method = RequestMethod.GET)
	public String sayHello() {
		return "Welcome";
	}

	@RequestMapping(value = "CreateAccount", method = RequestMethod.GET)
	public String createAccount(
			@ModelAttribute("customer") CustomerWallet customerWallet) {

		return "AcctResult";
	}

	@RequestMapping(value = "insertdata", method = RequestMethod.POST)
	public String insertCustomerDetails(
			@Valid @ModelAttribute("customer") CustomerWallet customerWallet,
			BindingResult res) {
		if (res.hasErrors()) {
			return "AcctResult";
		}

		walSer.createAccount(customerWallet);
		return "successAct";

	}

	@RequestMapping(value = "show balance", method = RequestMethod.GET)
	public String showbaL(@ModelAttribute("customer") CustomerWallet cust) {
		return "balance";

	}

	@RequestMapping(value = "balancePage", method = RequestMethod.GET)
	public ModelAndView bal(@RequestParam("mobNo") String mobno) {

		CustomerWallet cu = walSer.showBalance(mobno);
		double bal = cu.getBalance();

		return new ModelAndView("success", "balance", bal);
	}

	@RequestMapping(value = "showAllCustomerDetails", method = RequestMethod.GET)
	public ModelAndView showAllCustomerDetails() {
		List<CustomerWallet> myAllData = walSer.showAllDetails();
		return new ModelAndView("showall", "customer", myAllData);
	}

	@RequestMapping(value = "deposit", method = RequestMethod.GET)
	public String depositAmt(
			@ModelAttribute("customer") CustomerWallet customerWallet) {
		return "depositpage";

	}

	@RequestMapping(value = "depositamount", method = RequestMethod.POST)
	public ModelAndView depositDetails(@RequestParam("mobNo") String mobileno,
			@RequestParam("balance") double balance,
			@ModelAttribute("customer") CustomerWallet customerwallet) {
		if(walSer.checkMobileNo(mobileno))
		{
		CustomerWallet cust = walSer.depositAmount(mobileno, balance);
		System.out.println(cust.getBalance());

		return new ModelAndView("depositsuccess");
		}
		else
		{
			return new ModelAndView("error");
		}

	}

	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public String withdrawAmt(
			@ModelAttribute("customer") CustomerWallet customerWallet) {
		return "withdrawpage";

	}

	@RequestMapping(value = "withdrawamount", method = RequestMethod.POST)
	public ModelAndView withdrawDetails(@RequestParam("mobNo") String mobileno,
			@RequestParam("balance") double balance,
			@ModelAttribute("customer") CustomerWallet customerwallet) {
		if(walSer.checkMobileNo(mobileno))
		{
		walSer.withdrawAmount(mobileno, balance);
		return new ModelAndView("withdrawsuccess");
		}
		else
		{
			return new ModelAndView("error");
		}

	}

	@RequestMapping(value = "fundtransfer", method = RequestMethod.GET)
	public String fundAmt(
			@ModelAttribute("customer") CustomerWallet customerWallet) {
		return "fundtransferpage";

	}

	@RequestMapping(value = "fundAmt", method = RequestMethod.POST)
	public ModelAndView fundtransferDetails(
			@RequestParam("SmobNo") String sourcemobileno,
			@RequestParam("TmobNo") String targetmobileno,
			@RequestParam("balance") double amount,
			@ModelAttribute("customer") CustomerWallet customerwallet) {
		if(walSer.checkMobileNo(sourcemobileno))
		{
			if(walSer.checkMobileNo(targetmobileno))
			{
	
		System.out.println(sourcemobileno);
		walSer.fundTransfer(sourcemobileno, targetmobileno, amount);
		return new ModelAndView("fundtransfersuccess");
		}
		}
		
		return new ModelAndView("error");
	
	}

	@RequestMapping(value = "PrintTransactions", method = RequestMethod.GET)
	public String getMob(@ModelAttribute("my") Transactions t) {
		return "printpage";
	}

	@RequestMapping(value = "transaction", method = RequestMethod.POST)
	public ModelAndView pt(@ModelAttribute("my") Transactions t) {
		// System.out.println(t.getMobileNo());
	/*	if(walSer.checkMobileNo(t.getMobileNo()))
		{*/
			
	
		List<Transactions> list = walSer.getAll(t.getMobileNo());
		
		return new ModelAndView("transactionsPage", "list", list);
		/*}
		return new ModelAndView("error");*/
		

}
	
}
