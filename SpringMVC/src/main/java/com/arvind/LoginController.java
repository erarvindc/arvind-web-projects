package com.arvind;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView login( HttpServletRequest request, HttpServletResponse response ) {
		
		String loginResult = "Login failed !";
		if ( request.getParameter("usrnm").equals("admin") 
				&& request.getParameter("pwd").equals("password") ) {
			loginResult = "Login Succesful !";
		}
		
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("result.jsp");
		modelview.addObject("result", loginResult );
		return modelview;
	}

}
