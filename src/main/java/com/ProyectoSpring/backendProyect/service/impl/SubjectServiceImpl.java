package com.ProyectoSpring.backendProyect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ProyectoSpring.backendProyect.converter.SubjectConverter;
import com.ProyectoSpring.backendProyect.entity.Subject;
import com.ProyectoSpring.backendProyect.model.SubjectModel;
import com.ProyectoSpring.backendProyect.repository.StudentSubjectRepository;
import com.ProyectoSpring.backendProyect.repository.SubjectRepository;
import com.ProyectoSpring.backendProyect.service.SubjectService;

@Service("subjectServiceImpl")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	@Qualifier("subjectRepository")
	private SubjectRepository subjectRepository;

	@Autowired
	@Qualifier("subjectConverter")
	private SubjectConverter subjectConverter;

	@Autowired
	@Qualifier("studentSubjectRepository")
	private StudentSubjectRepository studentSubjectRepository;

	@Override
	public SubjectModel addSubject(SubjectModel subjectModel) {
		Subject subject = subjectRepository.save(subjectConverter.convertSubjectModel2Subject(subjectModel));
		return subjectConverter.convertSubject2SubjectModel(subject);
	}

	@Override
	public List<SubjectModel> listAllSubject() {
		List<Subject> subjects = subjectRepository.findAll();
		List<SubjectModel> subjectModels = new ArrayList<>();
		for (Subject subject : subjects) {
			subjectModels.add(subjectConverter.convertSubject2SubjectModel(subject));
		}
		return subjectModels;
	}

	@Override
	public SubjectModel findSubjectModelById(long id) {
		return subjectConverter.convertSubject2SubjectModel(subjectRepository.findById(id));
	}

	@Override
	public void removeSubject(long id) {
		Subject subject = subjectRepository.findById(id);
		if (subject != null) {
			subjectRepository.delete(subject);
		}
	}
}
