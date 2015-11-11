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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.Customer;
import com.spring.domain.PropertyAgent;
import com.spring.domain.PropertyBld;
import com.spring.domain.PrpUser;
import com.spring.service.PropertyBldServiceImp;
import com.spring.service.UserService;


@Controller
@SessionAttributes("propertyAgent")
public class ProptCntl {

	@Autowired
	UserService custSv;
	@Autowired
	UserService prptAgtSv;
	@Autowired
	PropertyBldServiceImp prptSv;
	
	@RequestMapping("/")
	public String showHomePage(){
		return "Login";
	}
	
	@RequestMapping("/showCustomerForm")
	public String showContactForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "CustomerForm";
	}

	@RequestMapping("/showPrptAgentForm")
	public String showPrptAgentForm(Model model) {
		model.addAttribute("propertyAgent", new PropertyAgent());
		return "PropertyAgentForm";
	}

	@RequestMapping("/showPropertyForm")
	public String showPropertyForm(Model model) {
		model.addAttribute("property", new PropertyBld());
		return "PropertyForm";
	}

	@RequestMapping("/viewContactList")
	public String  showContactList(Model model) {
		//send the contact list to the "ContactList.jsp"
		//model.addAttribute("contactList", pb.getContactList());
		
		List<PrpUser> cl = custSv.getUserList();
		model.addAttribute("contactList", cl);
		return "ContactList";
	}

	@RequestMapping("/showPropertyList")
	public String  showPropertyList(Model model) {
		//send the contact list to the "ContactList.jsp"
		//model.addAttribute("contactList", pb.getContactList());
		
		List<PropertyBld> prptLst = prptSv.getPropertyList();
		model.addAttribute("propertyList", prptLst);
		return "PropertyList";
	}

	@RequestMapping(value = "/addNewCustomer", method=RequestMethod.POST)
	public ModelAndView addNewCustomertoDb(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("CustomerForm");
		}else {
			custSv.addUser(customer);// Insert to DB
			mv.setViewName("UserAdded");
		}
		
		return mv;
	}

	@RequestMapping(value = "/addNewPrptAgent", method=RequestMethod.POST)
	public ModelAndView addNewPrptAgentoDb(@ModelAttribute("propertyAgent") @Valid PropertyAgent propertyAgent, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("PropertyAgentForm");
		}else {
			prptAgtSv.addUser(propertyAgent);
			mv.setViewName("UserAdded");
		}
		
		return mv;
	}

	@RequestMapping(value = "/addNewProperty", method=RequestMethod.POST)
	public ModelAndView addNewPropertyoDb(@ModelAttribute("property") @Valid PropertyBld property, 
			@ModelAttribute("propertyAgent") @Valid PropertyAgent propertyAgent,
			BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("PropertyForm");
		}else {
			property.setpAgt(propertyAgent);
			prptSv.addProperty(property);
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
