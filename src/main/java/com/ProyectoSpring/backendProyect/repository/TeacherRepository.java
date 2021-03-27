package com.ProyectoSpring.backendProyect.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoSpring.backendProyect.entity.Teacher;

@Repository("teacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, Serializable> {

	public abstract Teacher findById(long id);
}
