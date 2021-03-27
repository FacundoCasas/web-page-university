package com.ProyectoSpring.backendProyect.model;

public class TeacherModel {

	private long id;

	private String name;

	private String last_name;

	private boolean active;

	public TeacherModel() {}

	public TeacherModel(long id, String name, String last_name, boolean active) {
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
