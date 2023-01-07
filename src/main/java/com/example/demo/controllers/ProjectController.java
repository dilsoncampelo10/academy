package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	@GetMapping("/project/create")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/project_insert");
		return mv;
	}
}
