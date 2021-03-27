package com.ProyectoSpring.backendProyect.service;

import java.util.List;

import com.ProyectoSpring.backendProyect.model.TeacherModel;

public interface TeacherService {
	
	public abstract TeacherModel addTeacher(TeacherModel teacherModel);
	
	public abstract List<TeacherModel> listAllTeachers();
	
	public abstract List<TeacherModel> listActiveTeachers();
	
	public abstract void removeTeacher(long id);
	
	public abstract TeacherModel findTeacherModelById(long id);
}
