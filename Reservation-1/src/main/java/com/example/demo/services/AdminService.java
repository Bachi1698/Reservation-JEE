package com.example.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entities.Personne;
import com.example.demo.web.dto.PersonneRegistration;

public interface AdminService extends UserDetailsService
{
	
	Personne saveAdmin(PersonneRegistration registration);
	
	

}
