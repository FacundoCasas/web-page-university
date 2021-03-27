package com.ProyectoSpring.backendProyect.model;

public class SubjectModel {

	private long id;

	private String name;

	private String hours;

	private String teacher;

	private long max_students;

	private String description;

	public SubjectModel(long id, String name, String hours, String teacher, long max_students, String description) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
		this.teacher = teacher;
		this.max_students = max_students;
		this.description = description;
	}

	public SubjectModel() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime * result + (int) (max_students ^ (max_students >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectModel other = (SubjectModel) obj;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours))
			return false;
		if (max_students != other.max_students)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectModel [id=" + id + ", name=" + name + ", hours=" + hours + ", teacher=" + teacher
				+ ", max_students=" + max_students + ", description=" + description + "]";
	}
}
