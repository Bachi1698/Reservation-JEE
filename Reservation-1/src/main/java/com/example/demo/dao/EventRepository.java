package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	 @Query("SELECT event FROM Event event WHERE CONCAT(event.nom, ' ', event.type) LIKE %?1%")
	 public List<Event> search(String keyword);

}
