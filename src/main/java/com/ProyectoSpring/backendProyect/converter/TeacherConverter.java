package com.ProyectoSpring.backendProyect.converter;

import org.springframework.stereotype.Component;

import com.ProyectoSpring.backendProyect.entity.Teacher;
import com.ProyectoSpring.backendProyect.model.TeacherModel;

@Component("teacherConverter")
public class TeacherConverter {

	public Teacher convertTeacherModel2Teacher(TeacherModel teacherModel) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherModel.getId());
		teacher.setName(teacherModel.getName());
		teacher.setLast_name(teacherModel.getLast_name());
		teacher.setActive(teacherModel.isActive());
		return teacher;
	}

	public TeacherModel convertTeacher2TeacherModel(Teacher teacher) {
		TeacherModel teacherModel = new TeacherModel();
		teacherModel.setId(teacher.getId());
		teacherModel.setName(teacher.getName());
		teacherModel.setLast_name(teacher.getLast_name());
		teacherModel.setActive(teacher.isActive());
		return teacherModel;
	}
}
