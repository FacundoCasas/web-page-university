package com.ProyectoSpring.backendProyect.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoSpring.backendProyect.entity.Subject;

@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<Subject, Serializable> {

	public abstract Subject findById(long id);
}
