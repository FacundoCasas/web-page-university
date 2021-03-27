package com.ProyectoSpring.backendProyect.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_subject")
public class StudentSubject {

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

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "studentsubject_student", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "username") })
	private Set<User> users = new HashSet<User>();

	public StudentSubject() {
		super();
	}

	public StudentSubject(long id, String name, String hours, String teacher, long max_students, String description,
			Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
		this.teacher = teacher;
		this.max_students = max_students;
		this.description = description;
		this.users = users;
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

	public void addUser(User user) {
		users.add(user);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "StudentSubject [id=" + id + ", name=" + name + ", hours=" + hours + ", teacher=" + teacher
				+ ", max_students=" + max_students + ", description=" + description + ", users=" + users + "]";
	}
}
