package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin extends Personne implements Serializable
{
	
	
	@OneToMany(mappedBy = "admin" , fetch=FetchType.LAZY)
	private Collection<Event> events;
	
	
	public Admin() {
		super();
	}



	public Admin(String nom, String prenom, String email, int age, String adresse, String telephone, String login,
			String password) {
		super(nom, prenom, email, age, adresse, telephone, login, password);
		
	}
	

	public Admin(String nom, String prenom, String email, int age, String adresse, String telephone, String login,
			String password, Collection<Role> roles) {
		super(nom, prenom, email, age, adresse, telephone, login, password, roles);
		
	}





	public Collection<Event> getEvents() {
		return events;
	}


	public void setEvents(Collection<Event> events) {
		this.events = events;
	}




    
	
	

}
