package com.sa.paniwala.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String studentName = request.getParameter("studentName");
		model.addAttribute("message", "Yo :" + studentName.toUpperCase());
		return "helloworld";
	}
	
	@PostMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam("studentName") String studentName, Model model) {
		
		model.addAttribute("message", "Yo :" + studentName.toUpperCase());
		return "helloworld";
	}

}
