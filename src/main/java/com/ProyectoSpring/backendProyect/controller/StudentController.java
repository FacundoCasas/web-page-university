package com.ProyectoSpring.backendProyect.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ProyectoSpring.backendProyect.constant.ViewConstant;
import com.ProyectoSpring.backendProyect.model.SubjectModel;
import com.ProyectoSpring.backendProyect.repository.UserRepository;
import com.ProyectoSpring.backendProyect.service.StudentSubjectService;

@Controller
@PreAuthorize("hasRole('ROLE_STUDENT')")
@RequestMapping("/students")
public class StudentController {
	private static final Log LOG = LogFactory.getLog(StudentController.class);

	@Autowired
	@Qualifier("studentSubjectServiceImpl")
	private StudentSubjectService studentSubjectService;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@GetMapping("/cancelstudents")
	public String cancelStudents() {
		return "redirect:/students/showsubjectsforstudent";
	}

	@GetMapping("/showsubjectsforstudent")
	public ModelAndView showSubjectsForStudent() {
		ModelAndView mav = new ModelAndView(ViewConstant.SUBJECTS_FOR_STUDENTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("subjects",
				studentSubjectService.listAvailableSubjects(userRepository.findByUsername(user.getUsername())));
		mav.addObject("subjectsforstudent",
				studentSubjectService.listStudentSubjects(userRepository.findByUsername(user.getUsername())));
		return mav;
	}

	@GetMapping("/subjectinfo")
	public String subjectInfo(@RequestParam(name = "id", required = false) long id, Model model) {
		SubjectModel subjectModel = new SubjectModel();
		if (id != 0) {
			subjectModel = studentSubjectService.findSubjectModelById(id);
		}
		model.addAttribute("subjectModel", subjectModel);
		return ViewConstant.SUBJECTS_INFO;
	}

	@GetMapping("/addsubjectstudent")
	public String addSubjectStudent(@RequestParam(name = "id", required = false) long id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		SubjectModel subjectModel = studentSubjectService.findSubjectModelById(id);
		LOG.info("METHOD: addSubjectStudent() -- PARAMS: " + subjectModel.toString());
		if (null != studentSubjectService.addStudentSubject(subjectModel,
				userRepository.findByUsername(userDetail.getUsername()))) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/students/showsubjectsforstudent";
	}
}
