package com.example.demo.entities;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//@Inheritance(strategy= InheritanceType.JOINED)
/*public abstract class Personne {*/

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Personne {
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
		private Long idpers;
		private String nom;
		private String prenom;
		private String email;
		private int age;
		private String adresse;
		private String telephone;
		private String login;
		private String password;
		
		@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(
				name = "users_roles",
	        	joinColumns = @JoinColumn(
			        	name = "user_id", referencedColumnName = "idpers"),
	        	inverseJoinColumns = @JoinColumn(
	        			      name= "role_id", referencedColumnName = "id"))
		private Collection<Role> roles;
		
		
		public Personne() {
			
		}
		
		public Personne(String nom, String prenom, String email, int age, String adresse, String telephone,
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
		

         
		public Personne(String nom, String prenom, String email, int age, String adresse, String telephone,
				String login, String password, Collection<Role> roles) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.age = age;
			this.adresse = adresse;
			this.telephone = telephone;
			this.login = login;
			this.password = password;
			this.roles = roles;
		}
		
		

		public Collection<Role> getRoles() {
			return roles;
		}

		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
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

		
		public Long getIdpers() {
			return idpers;
		}

		public void setIdpers(Long idpers) {
			this.idpers = idpers;
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
		
		
		
		

}
