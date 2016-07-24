package com.spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.Customer;
import com.spring.domain.PropertyAgent;
import com.spring.domain.PropertyBld;
import com.spring.domain.PrpUser;
import com.spring.misc.UnexpectedError;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
//		List<PropertyBld> prptLst = prptSv.getPropertyList();
//		model.addAttribute("propertyList", prptLst);
// Use web service module instead
		if(true) throw new NullPointerException();

		return "PropertyList";
	}
	
/*	@ExceptionHandler(NullPointerException.class)
	public String errorHandling(NullPointerException ex) {
		return "Error";
	}
*/
	@RequestMapping(value = "/addNewCustomer", method=RequestMethod.POST)
	public ModelAndView addNewCustomertoDb(@ModelAttribute("customer") @Valid Customer customer, 
											BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("CustomerForm");
		}else {
			if(custSv.duplcExist(customer) == null) {
				customer.setPassword(passwordEncoder.encode(customer.getPassword()));
				try{
					custSv.addUser(customer);// Insert to DB
				} catch (Exception e) {
					System.err.print(e.getLocalizedMessage());
					session.setAttribute("unexpErr", UnexpectedError.dbInsertErr);
					mv.setViewName("CustomerForm");  //Unexpected error, fill the form again
					return mv;
				}
				mv.setViewName("UserAdded");
			} else {
				result.rejectValue("username", "error.duplicate.username", "duplicate.username");
				mv.addObject(result);
				mv.setViewName("CustomerForm");  //email already exist, fill the form again
			}
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

	/*the URL patter is the name of the excel file*/
	@RequestMapping(value = "/PrptListExcel", method=RequestMethod.GET)
	public ModelAndView saveAsExcel() {
		List<PropertyBld> prptLst = new ArrayList<PropertyBld>(prptSv.getPropertyList());
		//return a view that can be resolved by a excelView Resolver
		ModelAndView mav = new ModelAndView("excelView", "prptLst", prptLst);
		return mav;
	}

	@RequestMapping(value = "/PrptListPdf", method=RequestMethod.GET)
	public ModelAndView saveAsPDF() {
		List<PropertyBld> prptLst = new ArrayList<PropertyBld>(prptSv.getPropertyList());
		//return a view that can be resolved by a pdfView Resolver
		ModelAndView mav = new ModelAndView("pdfView", "prptLst", prptLst);
		return mav;
	}

	//Retrieve contacts from DB and convert to JSON format
	@RequestMapping(value="/getProperties", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String,Object> getJSONProperties(){
		List<PropertyBld> myProperties = prptSv.getPropertyList();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", myProperties.size());
		data.put("propertiesList", myProperties);
		return data;
	}

}
