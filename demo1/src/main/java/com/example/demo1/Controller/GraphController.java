package com.example.demo1.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

	
	@GetMapping("/barChart")
	public String barChart(Model model) {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		data.put("test", 30);
		data.put("a", 30);
		data.put("b", 80);
		data.put("c", 10);
		data.put("d", 25);
		
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
