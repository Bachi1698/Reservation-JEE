package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event implements Serializable
{
	@Id @GeneratedValue
	private Long idevent;
	@ManyToOne
	@JoinColumn(name = "Id_Admin")
	private Admin admin;
	
	private String nom;
	private String description;
	private String type;
	private int nbplace;
	private String date;
	private String localisation;
	private Double tarif;
	@OneToMany(mappedBy = "event", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	
	
	
	



	public Event() {
		super();
	}



	public Event(Admin admin, String nom, String description, String type, int nbplace, String date, String localisation,
			Double tarif) {
		super();
		this.admin = admin;
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.nbplace = nbplace;
		this.date = date;
		this.localisation = localisation;
		this.tarif = tarif;
	}

	

	public int getNbplace() {
		return nbplace;
	}



	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}



	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	public Long getIdevent() {
		return idevent;
	}



	public void setIdevent(Long idevent) {
		this.idevent = idevent;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	
	 

		
	
	
	
}
//(cascade = CascadeType.ALL)