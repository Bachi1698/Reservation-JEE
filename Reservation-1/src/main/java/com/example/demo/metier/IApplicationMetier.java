package com.example.demo.metier;

import java.util.List;

import com.example.demo.entities.Event;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.User;

public interface IApplicationMetier {
	
	
	// Rechercher un évènement par type
	public Event searchevent (Long id);
	

	// Rechercher un client  par login
	public User searchuser (Long id);
	
	
	public List<Reservation> findAll(String type, String login);

	public void reserver(Long type, Long login);
	
}
