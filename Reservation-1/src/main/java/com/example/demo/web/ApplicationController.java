package com.example.demo.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.entities.Event;
import com.example.demo.entities.Personne;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.User;
import com.example.demo.metier.IApplicationMetier;
import com.example.demo.services.EventService;
import com.example.demo.services.PersonneService;

@Controller
public class ApplicationController {

	//pour l'injection des dépendances on utilise Autowired
	
	@Autowired
	private EventService services;
	
	@Autowired
	private PersonneRepository personne;
	
	@Autowired
	private IApplicationMetier iApplicationMetier;
	
	
	//créer une méthode qui retourne une vue
	/*
	@RequestMapping("/events")
	public String index()
	{
		System.out.print("Création de la pade event");
		return "events";
	}*/
	
	@RequestMapping("/")
	public String viewHomePage(Model model,@Param("keyword") String keyword) {
	    List<Event> listEvent = services.listAll(keyword);
	    model.addAttribute("listEvent", listEvent);
	    model.addAttribute("keyword", keyword);
	     
	    return "tables";
	}
	
	
	@RequestMapping("/new")
	public String showNewEventPage(Model model) {
	    Event event = new Event();
	    model.addAttribute("event", event);
	     
	    return "new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("event") Event event) {
	    services.save(event);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{idevent}")
	public ModelAndView showEditEventPage(@PathVariable(name = "idevent") int idevent) {
	    ModelAndView mav = new ModelAndView("edit");
	    Event event = services.get(idevent);
	    mav.addObject("event", event);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{idevent}")
	public String deleteEvent(@PathVariable(name = "idevent") int idevent) {
	    services.delete(idevent);
	    return "redirect:/";       
	}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
		
	}
	
	
	/*@RequestMapping("/reserver")
	public String newEventPage1(Model model) {
		Event event=new Event();
		Date thisDate = new Date();
		model.addAttribute(event);
		return "reserver";
	}*/
	
	
	@RequestMapping("/addreservation/{idevent}")
     public ModelAndView Reserver(@PathVariable(name ="idevent") int idevent)
     {
		 ModelAndView mav = new ModelAndView("resevation");
		    Event event = services.get(idevent);
		    mav.addObject("event", event);
		     
		    return mav;
		
     }
	
	
	@RequestMapping(value = "/confirmer", method = RequestMethod.POST)
	public String confirmReservation(Model model,Long idevent,@ModelAttribute("event") Event event) 
	{
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String id1 = "null";
		Personne user= new User();
		
		Event events = iApplicationMetier.searchevent(event.getIdevent());
		
        
		
		if(authentication != null)
		{
			if(authentication.getPrincipal() instanceof UserDetails)
			{
				id1 = ((UserDetails)authentication.getPrincipal()).getUsername();
			    user = (User) personne.findByLogin(id1);
			}
			    
			else if (authentication.getPrincipal() instanceof String)
				  id1 = (String) authentication.getPrincipal();
			
			//System.out.println("--------------"+"ID Evenement"+event.getIdevent());
			System.out.println("--------------"+"Username"+id1);
			
			
			
		}
		
		iApplicationMetier.reserver(idevent, user.getIdpers());
	    
	     
	    return "redirect:/billet";
	}
	
	@RequestMapping("/billet")
	public String billet()
	{
		return "billet";
		
	}
	
	
	
	/*
	 * SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String id1 = "null";
		User user;
		if(authentication != null)
		{
			if(authentication.getPrincipal() instanceof UserDetails)
			{
				id1 = ((UserDetails)authentication.getPrincipal()).getUsername();
			    user = (User) personne.findByLogin(id1);
			}
			    
			else if (authentication.getPrincipal() instanceof String)
				  id1 = (String) authentication.getPrincipal();
			
			System.out.println("--------------"+"ID Evenement"+idevent);
			System.out.println("--------------"+"Username"+id1);
			
			
			
		}
		
		
	 * 
	 */
	  
}
