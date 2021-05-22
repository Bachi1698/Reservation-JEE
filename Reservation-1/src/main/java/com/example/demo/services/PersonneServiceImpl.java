package com.example.demo.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.entities.Personne;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.web.dto.PersonneRegistration;

@Service
public class PersonneServiceImpl implements PersonneService
{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private PersonneRepository personnerepository;
	public PersonneServiceImpl(PersonneRepository personnerepository) {
		super();
		this.personnerepository = personnerepository;
	}


	@Override
	public Personne save(PersonneRegistration registration) {
		/* String nom, String prenom, String email, int age, String adresse, String telephone,
				String login, String password, Collection<Role> roles*/
		Personne personne = new User(registration.getNom(),registration.getPrenom(),registration.getEmail(),registration.getAge(),
				                          registration.getAdresse(),registration.getTelephone(), registration.getLogin(),
				                          passwordEncoder.encode(registration.getPassword()),Arrays.asList(new Role("USER")));
		
		
		
		
		return personnerepository.save(personne);
	}
	
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Personne personne = personnerepository.findByLogin(username);
		if(personne == null)
		{
			throw new UsernameNotFoundException("Invalide username or password");
			
		}
		return new org.springframework.security.core.userdetails.User(personne.getLogin(), personne.getPassword(),mapRolesToAuthorities(personne.getRoles())); 
	}
	
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles)
    {
    	return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    
    	
    }
	

}
