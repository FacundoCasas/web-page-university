package com.ProyectoSpring.backendProyect.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoSpring.backendProyect.entity.StudentSubject;

@Repository("studentSubjectRepository")
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Serializable> {

	public abstract StudentSubject findById(long id);
}
