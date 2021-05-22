package com.example.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entities.Personne;
import com.example.demo.web.dto.PersonneRegistration;

public interface PersonneService extends UserDetailsService
{
	Personne save(PersonneRegistration registration);
	
	
	

}
