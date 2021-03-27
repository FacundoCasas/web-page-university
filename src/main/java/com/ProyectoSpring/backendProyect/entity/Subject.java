package com.ProyectoSpring.backendProyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "hours")
	private String hours;

	@Column(name = "teacher")
	private String teacher;

	@Column(name = "max_students")
	private long max_students;

	@Column(name = "description")
	private String description;

	public Subject(String name, String hours, String teacher, long max_students, String description) {
		super();
		this.name = name;
		this.hours = hours;
		this.teacher = teacher;
		this.max_students = max_students;
		this.description = description;
	}

	public Subject() {
		super();
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

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public long getMax_students() {
		return max_students;
	}

	public void setMax_students(long max_students) {
		this.max_students = max_students;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", hours=" + hours + ", teacher=" + teacher + ", max_students="
				+ max_students + ", description=" + description + "]";
	}
}
