package com.example.demo.metier;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EventRepository;
import com.example.demo.dao.ReservationRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Event;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.User;

@Service
@Transactional
public class ApplicationMetierImpl implements IApplicationMetier {

	@Autowired
	private EventRepository eventrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private ReservationRepository reservationrepository;
	
	@Override
	public Event searchevent(Long type) {
		// TODO Auto-generated method stub
		
		
		Event ev1 = eventrepository.findById(type).orElse(null);
		if (ev1 ==  null) throw new RuntimeException("Pas de réservation de ce type"); 
	    
		return ev1;
	}

	@Override
	public void reserver(Long type, Long login) {
	
		Event e1 = searchevent(type);
		User u1 = searchuser(login);
		Reservation r1 = new Reservation(new Date(), u1, e1, true);
		reservationrepository.save(r1);
		e1.setNbplace(e1.getNbplace()-1);
	    eventrepository.save(e1);
		
	}

	@Override
	public User searchuser(Long login) {
		// TODO Auto-generated method stub
	    User u1 = userrepository.findById(login).orElse(null);
       if (u1 ==  null) throw new RuntimeException("Pas de user avec ce login"); 
	    
		return u1;
	}

	@Override
	public List<Reservation> findAll(String type, String login) {
		
		return findAll(type, login);
	}

	

}
