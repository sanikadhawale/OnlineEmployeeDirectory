package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		//In Spring MVC, the model works a container that contains the data of the application.
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
		
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		//get the employee from the service
		Employee thEmployee = employeeService.findById(theId);
		
		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee", thEmployee);
		
		return "/employees/employee-form";
		
		
		
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {
		
		employeeService.save(thEmployee);
		
		//use the redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		
		//use the redirect to /employee/list
		return "redirect:/employees/list";
	}
}









