package com.example.blessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateurs")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "sexe")
	private Boolean sexe;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(long id, String name, String surname, Boolean sexe) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.sexe = sexe;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Boolean getSexe() {
		return sexe;
	}
	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
}
