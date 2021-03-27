package com.ProyectoSpring.backendProyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@Column(name = "dni")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "active")
	private boolean active;

	public Teacher() {
	}

	public Teacher(long id, String name, String last_name, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long dni) {
		this.id = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
