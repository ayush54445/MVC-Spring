package com.customermanager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	@RequestMapping("/")
	public String showHomePage() {
		return "header";
	}
	
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login_form";
	}
	
	@RequestMapping(value="/login_action", method = RequestMethod.POST)
	public void checkCreds(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws IOException {
		
		if(username.equals("admin") && password.equals("@dmin")) {
			
			req.getSession().setAttribute("username", username);
			
			res.sendRedirect("dashboard");
		} else {
			res.sendRedirect("login");
		}
		
	}
	
	@RequestMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
	
	@RequestMapping("/logout")
	public void logoutAdminUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		
		resp.sendRedirect("login");
	}
	
	

	
}
