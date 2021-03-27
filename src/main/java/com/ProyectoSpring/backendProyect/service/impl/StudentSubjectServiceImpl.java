package com.ProyectoSpring.backendProyect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ProyectoSpring.backendProyect.converter.SubjectConverter;
import com.ProyectoSpring.backendProyect.entity.StudentSubject;
import com.ProyectoSpring.backendProyect.entity.User;
import com.ProyectoSpring.backendProyect.model.SubjectModel;
import com.ProyectoSpring.backendProyect.repository.StudentSubjectRepository;
import com.ProyectoSpring.backendProyect.repository.SubjectRepository;
import com.ProyectoSpring.backendProyect.service.StudentSubjectService;
import com.ProyectoSpring.backendProyect.service.SubjectService;

@Service("studentSubjectServiceImpl")
public class StudentSubjectServiceImpl implements StudentSubjectService {

	@Autowired
	@Qualifier("subjectServiceImpl")
	private SubjectService subjectService;

	@Autowired
	@Qualifier("studentSubjectRepository")
	private StudentSubjectRepository studentSubjectRepository;

	@Autowired
	@Qualifier("subjectConverter")
	private SubjectConverter subjectConverter;

	@Autowired
	@Qualifier("subjectRepository")
	private SubjectRepository subjectRepository;

	@Override
	public List<SubjectModel> listAvailableSubjects(User user) {
		List<SubjectModel> allSubjects = subjectService.listAllSubject();
		List<SubjectModel> studentSubjects = listStudentSubjects(user);
		allSubjects.removeAll(studentSubjects);
		return allSubjects;
	}

	@Override
	public List<SubjectModel> listStudentSubjects(User user) {
		List<StudentSubject> studentSubjects = studentSubjectRepository.findAll();
		List<SubjectModel> subjectModels = new ArrayList<>();
		for (StudentSubject studentSubject : studentSubjects) {
			for (User usersubject : studentSubject.getUsers()) {
				if (user.getUsername().equals(usersubject.getUsername())) {
					subjectModels.add(subjectConverter.convertStudentSubject2SubjectModel(studentSubject));
				}
			}
		}
		return subjectModels;
	}

	@Override
	public SubjectModel addStudentSubject(SubjectModel subjectModel, User user) {
		StudentSubject studentSubject = subjectConverter.convertSubjectModel2StudentSubject(subjectModel);
		user.getStudentSubject().add(studentSubject);
		studentSubject.addUser(user);
		studentSubjectRepository.save(studentSubject);
		return subjectConverter.convertStudentSubject2SubjectModel(studentSubject);
	}

	@Override
	public SubjectModel addStudentSubject(SubjectModel subjectModel) {
		StudentSubject studentSubject = subjectConverter.convertSubjectModel2StudentSubject(subjectModel);
		studentSubjectRepository.save(studentSubject);
		return subjectConverter.convertStudentSubject2SubjectModel(studentSubject);
	}

	@Override
	public SubjectModel findSubjectModelById(long id) {
		return subjectConverter.convertSubject2SubjectModel(subjectRepository.findById(id));
	}

}
