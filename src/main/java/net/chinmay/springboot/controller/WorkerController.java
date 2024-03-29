package net.chinmay.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.chinmay.springboot.model.Worker;
import net.chinmay.springboot.services.WorkerService;

@Controller
public class WorkerController {
	
	// Display	list of employees
	@Autowired
	private WorkerService workerService;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listWorkers", workerService.getAllWorkers());
		
		
		
		
		List<Worker> worker = workerService.getAllWorkers();
		System.out.println(worker.toString());
		System.out.println(workerService.toString() + "Chinmay This is op");
		return "index";
	}
	@GetMapping("/showNewWorkerForm")
	public String showNewWorkerForm(Model model) {
		Worker worker = new Worker();
		model.addAttribute("worker", worker);
		return "new_worker";
	}
	
	@PostMapping("/saveWorker")
	public String saveWorker(@ModelAttribute("worker") Worker worker) {
		workerService.saveWorker(worker);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		Worker worker = workerService.getWorkerById(id);
		model.addAttribute("worker",worker);
		return "update_worker";
	}
	
	@GetMapping("/deleteWorker/{id}")
	public String deleteWorker(@PathVariable (value = "id") long id) {
		this.workerService.deleteWorkerById(id);
		return "redirect:/";
	}
	
}
