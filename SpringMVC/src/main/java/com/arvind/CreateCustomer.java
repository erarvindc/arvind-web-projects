package com.arvind;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.arvind.dao.Customer;
import com.arvind.dao.CustomerDAO;

@RestController
public class CreateCustomer {

	@RequestMapping("/customer")
	public ModelAndView createCustomer( 
			@PathParam("email") String email,
			@PathParam("name") String name,
			@PathParam("phone") int phone ) {
		
		System.out.println( email + name + phone );

		ModelAndView mv = new ModelAndView();

		try {
			CustomerDAO.createCustomer(email, name, phone );
		} catch ( Exception e ) {
			mv.setViewName("error.jsp");
			mv.addObject("errorMessage", e.getMessage() );
			return mv;
		}
		
		mv.setViewName("customer.jsp");
		
		mv.addObject("email",  email );
		mv.addObject("name",  name );
		mv.addObject("phone",  phone );
		
		/*Customer customer = new Customer( email, name, phone );
		return customer;*/
		
		return mv;
		
	}
	
	
}
