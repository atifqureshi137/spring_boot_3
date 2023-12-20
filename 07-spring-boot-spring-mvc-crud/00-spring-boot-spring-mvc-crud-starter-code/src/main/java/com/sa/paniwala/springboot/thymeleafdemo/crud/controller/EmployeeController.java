package com.sa.paniwala.springboot.thymeleafdemo.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sa.paniwala.springboot.thymeleafdemo.crud.entity.Employee;
import com.sa.paniwala.springboot.thymeleafdemo.crud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// get the employee from the db
		List<Employee> employees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormToUpdate")
	public String updateEmployee(@RequestParam("employeeId") int employeeId, Model model) {
		Employee employee = employeeService.findById(employeeId);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
		employeeService.deleteById(employeeId);
		
		return "redirect:/employees/list";
	}
}
