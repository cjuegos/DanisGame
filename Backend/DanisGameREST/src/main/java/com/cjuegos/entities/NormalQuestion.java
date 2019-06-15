package com.cjuegos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "normal_questions")
public class NormalQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, message = "Texto debe tener como minimo 3 caracteres")
	@Column(name = "text", nullable = false, length = 150)
	private String text;
	
	@Size(min = 3, message = "Tipo debe tener como minimo 3 caracteres")
	@Column(name = "type", nullable = false, length = 150)
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
