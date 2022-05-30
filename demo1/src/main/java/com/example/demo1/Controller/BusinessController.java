package com.example.demo1.Controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo1.Model.Business;
import com.example.demo1.Model.Tip;
import com.example.demo1.Repository.BusinessRepository;
import com.example.demo1.Repository.TipRepository;
import com.example.demo1.Service.BusinessService;

@Controller
public class BusinessController {

	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private BusinessService businessService; 
	
	@Autowired
	private TipRepository tipRepository;
	
	@GetMapping("") 
	public String populateList(Model model) {
	    List<String> states = businessService.findDistinctStates();
	    List<String> cities = businessService.findDistinctCities();
	    model.addAttribute("cities", cities);
	    model.addAttribute("states", states);
	    return "index";
	}
	
	@RequestMapping("/businessTable")
	public Model showData(Model model) {
		List<Business> list = businessRepository.findAll();				
		model.addAttribute("data", list);
		return model;
	}
	
	@RequestMapping(value = "toBusinessTips", method = RequestMethod.POST)
	public String toBusinessTips(Model model, @RequestParam String businessId) {
		List<Tip> tipList = tipRepository.findAll();
		ArrayList<Tip> businessTipList = new ArrayList<>();
		model.addAttribute("data", businessService.tipsForBusiness(tipList, businessTipList, businessId));
		return "businessTipsTable";
	}
	
	@RequestMapping(value = "searchForBusiness", method = RequestMethod.POST)
	public String searchForBusiness(Model model, @RequestParam String text, @RequestParam String type) {
		model.addAttribute("data", businessService.findBusiness(text, type));
		return "BusinessTable";	
	}
	
	
	@RequestMapping(value = "searchForFilteredBusiness", method = RequestMethod.POST)
	public String searchForFilteredBusinesses(Model model, @RequestParam String name, @RequestParam String city, @RequestParam String state, @RequestParam Double stars) {
		List<Business> data = businessService.filterBusiness(name, city, state, stars);
				model.addAttribute("data", data);
		return "BusinessTable";	
	}
	
	@GetMapping(value = "/indexPaginate")
	public String showIndexPaginate(Model model, Pageable page) {
		Page<Business> list = businessService.searchAll(page);
		model.addAttribute("data", list);
		return "businessTable";
	}
	
	
	
	
}
