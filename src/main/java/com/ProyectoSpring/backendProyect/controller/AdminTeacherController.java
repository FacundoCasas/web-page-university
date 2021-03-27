package com.ProyectoSpring.backendProyect.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProyectoSpring.backendProyect.constant.ViewConstant;
import com.ProyectoSpring.backendProyect.model.TeacherModel;
import com.ProyectoSpring.backendProyect.service.TeacherService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/teachers")
public class AdminTeacherController {

	private static final Log LOG = LogFactory.getLog(StudentController.class);

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	@GetMapping("/teacherform")
	public String redirectTeacherForm(@RequestParam(name = "id", required = false) int id, Model model) {
		TeacherModel teacherModel = new TeacherModel();
		if (id != 0) {
			teacherModel = teacherService.findTeacherModelById(id);
		}
		model.addAttribute("teacherModel", teacherModel);
		return ViewConstant.TEACHER_FORM;
	}

	@PostMapping("/addteacher")
	public String addTeacher(@ModelAttribute(name = "teacherModel") TeacherModel teacherModel, Model model) {
		LOG.info("METHOD: addSubject() -- PARAMS: " + teacherModel.toString());
		if (teacherModel.getName().equals("") || teacherModel.getLast_name().equals("") || teacherModel.getId() <= 0) {
			return ViewConstant.TEACHER_FORM;
		} else if (null != teacherService.addTeacher(teacherModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/subjects/showsubjects";
	}

	@GetMapping("/removeteacher")
	public String removeSubject(@RequestParam(name = "id", required = true) long id) {
		teacherService.removeTeacher(id);
		return "redirect:/subjects/showsubjects";
	}
}
