package com.ProyectoSpring.backendProyect.service;

import java.util.List;

import com.ProyectoSpring.backendProyect.model.SubjectModel;

public interface SubjectService {

	public abstract SubjectModel addSubject(SubjectModel subjectModel);

	public abstract List<SubjectModel> listAllSubject();

	public abstract void removeSubject(long id);

	public abstract SubjectModel findSubjectModelById(long id);
}
