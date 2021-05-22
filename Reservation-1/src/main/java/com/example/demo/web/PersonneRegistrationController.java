package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.PersonneService;
import com.example.demo.web.dto.PersonneRegistration;

@Controller
@RequestMapping("/registration")
public class PersonneRegistrationController 
{
	private PersonneService personneservice;

	public PersonneRegistrationController(PersonneService personneservice) {
		super();
		this.personneservice = personneservice;
	} 
	
	
	@ModelAttribute("personne")
	public PersonneRegistration personneregistration()
	{
		return new PersonneRegistration();
	}
	
	
	
	
	@GetMapping
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("personne")PersonneRegistration personneregistration)
	{
		personneservice.save(personneregistration);
		return "redirect:/registration?success";
	}
	

}
