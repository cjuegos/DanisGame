package com.cjuegos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 1, message = "Username must be atleast 1 charecter in length")
	@Column(name = "name", nullable = false, length = 15)
	private String name;
	
	@Column(name = "questions", nullable = false)
	private int questions = 0;

	@Column(name = "sesion", nullable = false)
	private int sesion = 0;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestions() {
		return questions;
	}

	public void setQuestions(int questions) {
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSesion() {
		return sesion;
	}

	public void setSesion(int sesion) {
		this.sesion = sesion;
	}
	
}
