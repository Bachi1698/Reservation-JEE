package com.example.demo.web.dto;

public class PersonneRegistration 
{
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private String adresse;
	private String telephone;
	private String login;
	private String password;
	
	
	
	public PersonneRegistration() {
		
	}

	public PersonneRegistration(String nom, String prenom, String email, int age, String adresse, String telephone,
			String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.adresse = adresse;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
