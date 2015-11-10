package com.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.CustomerDaoImp;
import com.spring.domain.Customer;
import com.spring.domain.PrpUser;
import com.spring.domain.UserAddress;
import com.spring.service.UserService;


@Controller
public class ProptCntl {

	//CustomerDaoImp custSv = new ContactDaoImp();
	@Autowired
	UserService custSv;
	
	@RequestMapping("/")
	public String showHomePage(){
		return "index";
	}
	
	@RequestMapping("/showCustomerForm")
	public String showContactForm(Model model) {
		//model.addAttribute(new Contact());
		/**
		 * Form backing object
		 * This is an empty form to be used by the form to fill the values of the contact object
		 * */
		model.addAttribute("customer", new Customer());
		//model.addAttribute("address", new UserAddress());
		return "CustomerForm";
	}
	
	@RequestMapping("/viewContactList")
	public String  showContactList(Model model) {
		//send the contact list to the "ContactList.jsp"
		//model.addAttribute("contactList", pb.getContactList());
		
		List<PrpUser> cl = custSv.getUserList();
		model.addAttribute("contactList", cl);
		return "ContactList";
	}
	
/*	@RequestMapping(value = "/addNewCustomer", method=RequestMethod.POST)
	public String addNewCustomertoDb(@ModelAttribute("customer") Customer customer) {
		if(customer.getFirstName().isEmpty() || customer.getLastName().isEmpty())
			return "CustomerForm";
			
		custSv.addUser(customer);// Insert to DB		
		return "ContactAdded";
	}
*/
	@RequestMapping(value = "/addNewCustomer", method=RequestMethod.POST)
	public ModelAndView addNewCustomertoDb(@ModelAttribute("customer") Customer customer, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("CustomerForm");
		}else {
			custSv.addUser(customer);// Insert to DB
			mv.setViewName("UserAdded");
		}
		
		return mv;
	}

	
	@RequestMapping(value = "/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer userId) {
		custSv.deleteUserById(userId);
		return "redirect:/viewContactList";
	}

	@RequestMapping(value = "/edit/{contactId}")
	public String editContact(@PathVariable("contactId") Integer contactId) {
		//custSv.deleteContactById(contactId);
		return "redirect:/viewContactList";
	}

}
