package xxu.sx.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xxu.sx.TaskService;
import xxu.sx.entity.Task;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mode", "MODE_HOME");
		return "index";
	}
	@GetMapping("/newTask")
	public String newTask(Model model) {
		model.addAttribute("mode", "MODE_NEW");
		model.addAttribute("task", new Task());
		
		return "index";
	}

	@GetMapping("/listAll")
	public String allTasks(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		return "index";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id, Model model) {
		taskService.delete(id);
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		return "index";
	}

	@GetMapping("/{id}/update")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("task", taskService.findById(id));
		model.addAttribute("mode", "MODE_UPDATE");
		return "index";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Task task, Model model) {

		task.setDateCreated(new Date());
		taskService.save(task);
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		return "index";
	}

}
