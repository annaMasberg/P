package com.example.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo1.Repository.BusinessRepository;

@Controller
public class BusinessController {

	@Autowired
	private BusinessRepository businessRepo;
	
	@RequestMapping("/BusinessTable")
	public Model showData(Model model) {
		
		model.addAttribute("data", businessRepo.findAll());
		
		return model;
	}
}
