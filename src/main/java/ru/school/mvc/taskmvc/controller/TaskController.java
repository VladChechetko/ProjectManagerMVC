package ru.school.mvc.taskmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.school.mvc.taskmvc.entity.Project;
import ru.school.mvc.taskmvc.entity.Task;
import ru.school.mvc.taskmvc.service.ProjectService;
import ru.school.mvc.taskmvc.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model) {
		List<Task> tasks = taskService.getListTask();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model) {
		List<Project> projects = projectService.getListProject();
		model.addAttribute("projectList", projects);
		
		Task task = new Task();
		task.setDateBegin(new Date());
		task.setDateEnd(new Date());
		
		model.addAttribute("task", task);
		return "task_edit";
	}
	
	@RequestMapping(value="/del/{id}", method=RequestMethod.GET)
	public String del(Model model, @PathVariable String id) {
		taskService.removeTaskById(id);
		return "redirect:/tasks";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(Model model, @PathVariable String id) {
		List<Project> projects = projectService.getListProject();
		model.addAttribute("projectList", projects);
		
		Task task = taskService.getTaskById(id);
		if (task.getProject()!=null) {
			task.setProjectId(task.getProject().getId());
		}
		model.addAttribute("task", task);
		return "task_edit";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute Task task, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "redirect:/error";
		}
		taskService.merge(task);
		return "redirect:/tasks";
	}
	
	
}
