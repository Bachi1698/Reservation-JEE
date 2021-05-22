package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EventRepository;
import com.example.demo.entities.Event;

@Service
@Transactional
public class EventService
{
	  @Autowired
	    private EventRepository repo;
	     
	    public List<Event> listAll(String keyword) {
	    	 if (keyword != null) {
	             return repo.search(keyword);
	         }
	        return repo.findAll();
	    }
	     
	    public void save(Event event) {
	        repo.save(event);
	    }
	     
	    public Event get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }

}
