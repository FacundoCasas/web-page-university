package com.ProyectoSpring.backendProyect.service;

import java.util.List;

import com.ProyectoSpring.backendProyect.entity.User;
import com.ProyectoSpring.backendProyect.model.SubjectModel;

public interface StudentSubjectService {

	public abstract List<SubjectModel> listAvailableSubjects(User user);

	public abstract List<SubjectModel> listStudentSubjects(User user);

	public abstract SubjectModel addStudentSubject(SubjectModel subjectModel, User user);

	public abstract SubjectModel findSubjectModelById(long id);

	public abstract SubjectModel addStudentSubject(SubjectModel subjectModel);
}
