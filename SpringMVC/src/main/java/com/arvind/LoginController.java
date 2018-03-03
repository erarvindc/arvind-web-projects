package com.arvind;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arvind.service.LoginService;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView login( HttpServletRequest request, HttpServletResponse response ) {
		
		LoginService loginService = new LoginService();
		
		String loginResult = "Login failed !";
		if ( loginService.isLoginSuccessful
				( request.getParameter("usrnm"), request.getParameter("pwd") ) ) {
			loginResult = "Login Successful !";
		}
		
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("result.jsp");
		modelview.addObject("result", loginResult );
		return modelview;
	}

}
