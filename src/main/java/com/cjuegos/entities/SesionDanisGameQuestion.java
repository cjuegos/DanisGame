package com.cjuegos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sesiondani")
public class SesionDanisGameQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "sesion_id", nullable = true)
	private Sesion sesionId;
	
	@ManyToOne
	@JoinColumn(name = "danisgamequestion_id", nullable = true)
	private DanisGameQuestion danisgamequestionId;
	
	@Column(name = "state", nullable = false)
	private boolean state = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sesion getSesionId() {
		return sesionId;
	}

	public void setSesionId(Sesion sesionId) {
		this.sesionId = sesionId;
	}

	public DanisGameQuestion getDanisgamequestionId() {
		return danisgamequestionId;
	}

	public void setDanisgamequestionId(DanisGameQuestion danisgamequestionId) {
		this.danisgamequestionId = danisgamequestionId;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
