package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.AdminService;
import com.example.demo.services.PersonneService;
import com.example.demo.web.dto.PersonneRegistration;

@Controller
@RequestMapping("/registrationadmin")
public class PersonneRegistrationAdminController 
{
	private AdminService adminservice;

	public PersonneRegistrationAdminController(AdminService adminservice) {
		super();
		this.adminservice = adminservice;
	} 
	
	
	@ModelAttribute("admin")
	public PersonneRegistration personneregistration()
	{
		return new PersonneRegistration();
	}
	
	
	
	
	@GetMapping
	public String showRegistrationForm()
	{
		return "registrationadmin";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("admin")PersonneRegistration personneregistration)
	{
		adminservice.saveAdmin(personneregistration);
		return "redirect:/registrationadmin?successadmin";
	}
	

}
