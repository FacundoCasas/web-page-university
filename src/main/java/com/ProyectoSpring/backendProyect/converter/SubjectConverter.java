package com.ProyectoSpring.backendProyect.converter;

import org.springframework.stereotype.Component;

import com.ProyectoSpring.backendProyect.entity.StudentSubject;
import com.ProyectoSpring.backendProyect.entity.Subject;
import com.ProyectoSpring.backendProyect.model.SubjectModel;

@Component("subjectConverter")
public class SubjectConverter {

	public Subject convertSubjectModel2Subject(SubjectModel subjectModel) {
		Subject subject = new Subject();
		subject.setId(subjectModel.getId());
		subject.setName(subjectModel.getName());
		subject.setHours(subjectModel.getHours());
		subject.setTeacher(subjectModel.getTeacher());
		subject.setMax_students(subjectModel.getMax_students());
		subject.setDescription(subjectModel.getDescription());
		return subject;
	}

	public SubjectModel convertSubject2SubjectModel(Subject subject) {
		SubjectModel subjectModel = new SubjectModel();
		subjectModel.setId(subject.getId());
		subjectModel.setName(subject.getName());
		subjectModel.setHours(subject.getHours());
		subjectModel.setTeacher(subject.getTeacher());
		subjectModel.setMax_students(subject.getMax_students());
		subjectModel.setDescription(subject.getDescription());
		return subjectModel;
	}

	public StudentSubject convertSubjectModel2StudentSubject(SubjectModel subjectModel) {
		StudentSubject studentSubject = new StudentSubject();
		studentSubject.setId(subjectModel.getId());
		studentSubject.setName(subjectModel.getName());
		studentSubject.setHours(subjectModel.getHours());
		studentSubject.setTeacher(subjectModel.getTeacher());
		studentSubject.setMax_students(subjectModel.getMax_students());
		studentSubject.setDescription(subjectModel.getDescription());
		return studentSubject;
	}

	public SubjectModel convertStudentSubject2SubjectModel(StudentSubject studentSubject) {
		SubjectModel subjectModel = new SubjectModel();
		subjectModel.setId(studentSubject.getId());
		subjectModel.setName(studentSubject.getName());
		subjectModel.setHours(studentSubject.getHours());
		subjectModel.setTeacher(studentSubject.getTeacher());
		subjectModel.setMax_students(studentSubject.getMax_students());
		subjectModel.setDescription(studentSubject.getDescription());
		return subjectModel;
	}
}
