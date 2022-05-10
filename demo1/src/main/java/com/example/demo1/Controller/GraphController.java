package com.example.demo1.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo1.Model.Business;
import com.example.demo1.Repository.BusinessRepository;

@Controller
public class GraphController {

	@Autowired
	BusinessRepository businessRep;
	
	@GetMapping("/barChart")
	public String barChart(Model model) {
		Map<String, Double> data = new LinkedHashMap<String, Double>();
		
		List<Business> list = businessRep.findAll();
		
		for( Business e : list) {
			data.put(e.name, e.stars);
		}
		model.addAttribute("keySet", data.keySet());
		model.addAttribute("values", data.values());
		return "barChart";
	}
	
	@GetMapping("/pieChart")
	public String pieChart(Model model) {
		model.addAttribute("pass", 90);
		model.addAttribute("fail", 10);
		
		return "pieChart";
	}
	

	}
