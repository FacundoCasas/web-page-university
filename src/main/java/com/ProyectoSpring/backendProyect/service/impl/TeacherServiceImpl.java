package com.ProyectoSpring.backendProyect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ProyectoSpring.backendProyect.converter.TeacherConverter;
import com.ProyectoSpring.backendProyect.entity.Teacher;
import com.ProyectoSpring.backendProyect.model.TeacherModel;
import com.ProyectoSpring.backendProyect.repository.TeacherRepository;
import com.ProyectoSpring.backendProyect.service.TeacherService;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	@Qualifier("teacherRepository")
	private TeacherRepository teacherRepository;

	@Autowired
	@Qualifier("teacherConverter")
	private TeacherConverter teacherConverter;

	@Override
	public List<TeacherModel> listAllTeachers() {
		List<Teacher> teachers = teacherRepository.findAll();
		List<TeacherModel> teachersModel = new ArrayList<>();
		for (Teacher teacher : teachers) {
			teachersModel.add(teacherConverter.convertTeacher2TeacherModel(teacher));
		}
		return teachersModel;
	}

	@Override
	public List<TeacherModel> listActiveTeachers() {
		List<Teacher> teachers = teacherRepository.findAll();
		List<TeacherModel> teachersModel = new ArrayList<>();
		for (Teacher teacher : teachers) {
			if (teacher.isActive() == true) {
				teachersModel.add(teacherConverter.convertTeacher2TeacherModel(teacher));
			}

		}
		return teachersModel;
	}

	@Override
	public TeacherModel addTeacher(TeacherModel teacherModel) {
		Teacher teacher = teacherConverter.convertTeacherModel2Teacher(teacherModel);
		teacherRepository.save(teacher);
		return teacherConverter.convertTeacher2TeacherModel(teacher);
	}

	@Override
	public TeacherModel findTeacherModelById(long id) {
		return teacherConverter.convertTeacher2TeacherModel(teacherRepository.findById(id));
	}

	@Override
	public void removeTeacher(long id) {
		Teacher teacher = teacherRepository.findById(id);
		if (teacher != null) {
			teacherRepository.delete(teacher);
		}
	}
}
