package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable{

	@Id @GeneratedValue
	private Long ID_Reservation;
	@ManyToOne
	@JoinColumn(name="Id_User")
	private User user;
	@ManyToOne
	@JoinColumn(name="Id_Event")
	private Event event;
	
	private Date date_reservation;
	private Boolean conf;
	
	
	public Reservation() {
		
	}
	
	public Reservation(Date date_reservation, User user, Event event,Boolean conf) {
		
		this.date_reservation = date_reservation;
		this.user = user;
		this.event = event;
		this.conf = conf;
	}

	public Long getID_Reservation() {
		return ID_Reservation;
	}
	public void setID_Reservation(Long iD_Reservation) {
		ID_Reservation = iD_Reservation;
	}
	public Date getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	public Boolean getConf() {
		return conf;
	}

	public void setConf(Boolean conf) {
		this.conf = conf;
	}
	
	
	
	
}
