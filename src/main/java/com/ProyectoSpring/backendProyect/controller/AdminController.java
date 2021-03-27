package com.ProyectoSpring.backendProyect.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ProyectoSpring.backendProyect.constant.ViewConstant;
import com.ProyectoSpring.backendProyect.model.SubjectModel;
import com.ProyectoSpring.backendProyect.model.TeacherModel;
import com.ProyectoSpring.backendProyect.repository.UserRepository;
import com.ProyectoSpring.backendProyect.service.SubjectService;
import com.ProyectoSpring.backendProyect.service.TeacherService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/subjects")
public class AdminController {

	private static final Log LOG = LogFactory.getLog(StudentController.class);

	@Autowired
	@Qualifier("subjectServiceImpl")
	private SubjectService subjectService;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("teacherServiceImpl")
	private TeacherService teacherService;

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/subjects/showsubjects";
	}

	@GetMapping("/subjectform")
	public String redirectSubjectForm(@RequestParam(name = "id", required = false) int id, Model model) {
		SubjectModel subjectModel = new SubjectModel();
		List<TeacherModel> teachers = new ArrayList<>();
		if (id != 0) {
			subjectModel = subjectService.findSubjectModelById(id);
			teachers = teacherService.listActiveTeachers();
		} else {
			teachers = teacherService.listActiveTeachers();
		}
		model.addAttribute("subjectModel", subjectModel);
		model.addAttribute("teacher", teachers);
		return ViewConstant.SUBJECT_FORM;
	}

	@GetMapping("/validationsubjectform")
	public String redirectValidationSubjectForm(Model model) {
		SubjectModel subjectModel = new SubjectModel();
		List<TeacherModel> teachers = teacherService.listActiveTeachers();
		model.addAttribute("subjectModel", subjectModel);
		model.addAttribute("teacher", teachers);
		return ViewConstant.SUBJECT_FORM;
	}

	@PostMapping("/addsubject")
	public String addSubject(@ModelAttribute(name = "subjectModel") SubjectModel subjectModel, Model model) {
		LOG.info("METHOD: addSubject() -- PARAMS: " + subjectModel.toString());
		if (subjectModel.getName().equals("") || subjectModel.getHours().equals("")
				|| subjectModel.getMax_students() <= 0 || subjectModel.getDescription().equals("")) {
			return "redirect:/subjects/validationsubjectform";
		} else if (null != subjectService.addSubject(subjectModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/subjects/showsubjects";

	}

	@GetMapping("/showsubjects")
	public ModelAndView showSubjects() {
		ModelAndView mav = new ModelAndView(ViewConstant.SUBJECTS_AND_TEACHERS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("subjects", subjectService.listAllSubject());
		mav.addObject("teachers", teacherService.listAllTeachers());
		return mav;
	}

	@GetMapping("/removesubject")
	public ModelAndView removeSubject(@RequestParam(name = "id", required = true) long id) {
		subjectService.removeSubject(id);
		return showSubjects();
	}
}
