package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.AdminRepository;
import com.example.demo.dao.BilletReposirory;
import com.example.demo.dao.EventRepository;
import com.example.demo.dao.ReservationRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.*;
import com.example.demo.metier.IApplicationMetier;


@SpringBootApplication
public class Reservation1Application implements CommandLineRunner {
	
	@Autowired
    AdminRepository adminRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	BilletReposirory billetReposirory;
	
	@Autowired
	private IApplicationMetier iApplicationMetier;
	

	public static void main(String[] args) {
		 SpringApplication.run(Reservation1Application.class, args);
	 
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Admin a1 = adminRepository.save(new Admin("Gueye", "Bassirou", "gueyebachir98@gmail.com",18,"Fass", "07513146", "bachir", "bachir",12));
		//Admin a2 = adminRepository.save(new Admin("Vanie", "Jean Marc", "vani@gmail.com",18,"Grandmont", "07513167", "jean", "jean",13));
		
		
		
		
		//User u1 = userRepository.save(new User("Gueye", "Bassirou", "gueyebachir98@gmail.com",18,"Fass", "07513146", "bachir", "bachir"));
		
		//Event ev1 = eventRepository.save(new Event(a1, "Gala", "Soiree dansante", "concert", 100,"18/05/2021", "Stade Grandmont", 120.0));
		
		//Reservation r1 = reservationRepository.save(new Reservation(new Date(), u1, ev1, false));
		//Reservation r2 = reservationRepository.save(new Reservation(new Date(), u1, ev1, false));
		
		//Billet b1 = billetReposirory.save(new Billet(r1));
	
		/*iApplicationMetier.reserver(ev1.getIdevent(), u1.getIdpers());
		iApplicationMetier.reserver(ev1.getIdevent(), u1.getIdpers());
		iApplicationMetier.reserver(ev1.getIdevent(), u1.getIdpers());
		iApplicationMetier.reserver(ev1.getIdevent(), u1.getIdpers());*/
				
			          
		
	}

}
