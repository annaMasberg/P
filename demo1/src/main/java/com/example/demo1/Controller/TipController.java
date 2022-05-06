package com.example.demo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo1.Model.Tip;
import com.example.demo1.Repository.TipRepository;

@Controller
public class TipController {

	@Autowired
	private TipRepository tipRepo;
	
	@RequestMapping("/tipTable")
	public Model showData(Model model) {
		List<Tip> list = tipRepo.findAll();
		model.addAttribute("data", list);
		return model;
	}
	
	
}
