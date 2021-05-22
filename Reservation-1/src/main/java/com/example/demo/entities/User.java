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
@Table(name="User")
public class User extends Personne implements Serializable
{
	
	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;

		
	public User() {
	
	}


	public User(String nom, String prenom, String email, int age, String adresse, String telephone, String login,
			String password) {
		super(nom, prenom, email, age, adresse, telephone, login, password);
	}
	
	public User(String nom, String prenom, String email, int age, String adresse, String telephone, String login,
			String password, Collection<Role> roles) {
		super(nom, prenom, email, age, adresse, telephone, login, password, roles);
		
	}


	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	
	
	


	
	

}
