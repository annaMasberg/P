package com.example.demo1.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo1.Model.Business;
import com.example.demo1.Model.Tip;
import com.example.demo1.Repository.BusinessRepository;
import com.example.demo1.Repository.TipRepository;
import com.example.demo1.Service.BusinessService;

@Controller
//@RequestMapping(value="/businessTable")
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
	    List<String> cities = businessService.findDistinctCities();
		for(Business business : list) {
			business.setPriceRange(businessService.priceRangefinder(business));
		}
		model.addAttribute("data", list);
	    model.addAttribute("cities", cities);
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
	public String searchForFilteredBusinesses(Model model, @RequestParam String name, @RequestParam String city, @RequestParam String state) {
		List<Business> data = businessService.filterBusiness(name, city, state);
				model.addAttribute("data", data);
		return "BusinessTable";	
	}
	
	@RequestMapping(value = "creditCardViability", method = RequestMethod.POST)
	public String creditCardViability(Model model, @RequestParam String viability) {
		switch(viability){
			case "yes" : model.addAttribute("data", businessService.acceptCreditCard()); break;
			case "no" : model.addAttribute("data", businessService.acceptNoCreditCard()); break;
			default: break;
		}
		return "BusinessTable";	
	}
	
	@RequestMapping(value = "hasAttribute", method = RequestMethod.POST)
	public String hasAttribute(Model model, @RequestParam List<String> attribute) {
		model.addAttribute("data", businessService.hasAttribute(attribute));
		return "BusinessTable";	
	}
	
	
	@RequestMapping(value = "foodOrigin", method = RequestMethod.POST)
	public String originLandfinder(Model model, @RequestParam String type) {
			model.addAttribute("data", businessService.originLand(type));
		return "BusinessTable";	
	}
	
	@RequestMapping(value = "foodType", method = RequestMethod.POST)
	public String foodTypefinder(Model model, @RequestParam String type) {
			model.addAttribute("data", businessService.foodType(type));
		return "BusinessTable";	
	}
	
	@RequestMapping(value = "drinkType", method = RequestMethod.POST)
	public String drinkTypefinder(Model model, @RequestParam String type) {
			model.addAttribute("data", businessService.drinkType(type));
		return "BusinessTable";	
	}
	
	@RequestMapping(value = "hasCategorie", method = RequestMethod.POST)
	public String isVegetarian(Model model, @RequestParam String categorie) {
		switch(categorie){
		case "Vegetarian" : model.addAttribute("data", businessService.isVegetarian()); break;
		case "Vegan" : model.addAttribute("data", businessService.isVegan()); break;
		default: break;
	}
		return "BusinessTable";	
	}
	
	
	@GetMapping(value = "/indexPaginate")
	public String showIndexPaginate(Model model, Pageable page) {
		Page<Business> list = businessService.searchAll(page);
		model.addAttribute("data", list);
		return "businessTable";
	}
	
	@GetMapping(value = "/toCharts")
	public String toCHarts() {
		return "Charts";
				}
	
}
