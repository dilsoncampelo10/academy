package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProjectDao;
import com.example.demo.models.Project;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectDao projectRepository;

	@GetMapping("/project/create")
	public ModelAndView index(Project project) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/project_insert");
		return mv;
	}
	
	@PostMapping("/project/create")
	public ModelAndView insert(Project project) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:show");
		projectRepository.save(project);
		return mv;
	}
	
	@GetMapping("/project/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/project_show");
		mv.addObject("projects", projectRepository.findAll());
		return mv;
	}
	
	@GetMapping("/project/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/project_edit");
		Project project = projectRepository.getReferenceById(id);
		mv.addObject("project",project);
		
		return mv;
		
	}
	
	@PostMapping("/project/edit")
	public ModelAndView update(Project project) {
		ModelAndView mv = new ModelAndView();
		projectRepository.save(project);
		mv.setViewName("redirect:show");
		return mv;
	}
}
