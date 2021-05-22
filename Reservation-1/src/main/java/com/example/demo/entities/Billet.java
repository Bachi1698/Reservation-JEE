package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Billet implements Serializable
{
	@Id @GeneratedValue
	private Long ID_Ticket;
	
	@OneToOne
	@JoinColumn(name="ID_Reservation",referencedColumnName = "ID_Reservation",nullable = false)
	private Reservation reservation;
	
	
	

	public Billet() {
		super();
	}

	public Billet(Reservation reservation) {
		super();
		this.reservation = reservation;
	}

	public Long getID_Ticket() {
		return ID_Ticket;
	}

	public void setID_Ticket(Long iD_Ticket) {
		ID_Ticket = iD_Ticket;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
	
	
	

}
