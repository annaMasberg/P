package com.example.demo1.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo1.Model.Business;
import com.example.demo1.Repository.BusinessRepository;
import com.example.demo1.Service.BusinessService;

@Controller
public class GraphController {

	@Autowired
	BusinessRepository businessRepository;

	@Autowired
	BusinessService businessService;

	@GetMapping("/barChart")
	public String creditCardbarChart(Model model) {
		String title = "Businesses who accept Credit Cart Payment vs who dont";
		String xAxeText = "Businesses";
		String yAxeText = "Number of Businesses";
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		List<Business> listCreditCard = businessService.acceptCreditCard();
		List<Business> listNoCreditCard = businessService.acceptNoCreditCard();

		data.put("Credit Card", listCreditCard.size());
		data.put("No Credit Card", listNoCreditCard.size());

		model.addAttribute("keySet", data.keySet());
		model.addAttribute("values", data.values());
		model.addAttribute("xAxeText", xAxeText);
		model.addAttribute("yAxeText", yAxeText);
		model.addAttribute("title", title);
		return "barChart";
	}
	
	@RequestMapping(value = "majorCitiesOrStatebarChart", method = RequestMethod.POST)
	public String majorCitiesOrStatebarChart(Model model, @RequestParam String word) {
		String title = "Top 10 " + word + " with the highest Business Count";
		String xAxeText = word;
		String yAxeText = "Number of Businesses";
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		List<String> list;
		switch(word){
			case "city" : 
						list = businessService.cityCalculator();
						for(String city : list) {
							int counter = 0;
							for(Business business : businessRepository.findAll()) {
								if(city.equals(business.city)) {
									counter++;
										}
												}
								data.put(city, counter);
												}
			break;
			case "state" : list = businessService.stateCalculator();
						   for(String state : list) {
							  int counter = 0;
							  for(Business business : businessRepository.findAll()) {
								  if(state.equals(business.state)) {
									  counter++;
								  	}
									}
							  	data.put(state, counter);
									}
			break;
				
		}

		model.addAttribute("keySet", data.keySet());
		model.addAttribute("values", data.values());
		model.addAttribute("xAxeText", xAxeText);
		model.addAttribute("yAxeText", yAxeText);
		model.addAttribute("title", title);

		return "barChart";
	}
	
	@RequestMapping(value = "topReviewsCount", method = RequestMethod.POST)
	public String topReviewsCount(Model model) {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		String title = "Top 10 most reviewed Businesses";
		String xAxeText = "Business";
		String yAxeText = "Number of Reviews";
				
		List<String> list = businessService.topReviewedBusinesses();
		for(String businessName : list) {
				data.put(businessName, businessRepository.findOneByName(businessName).reviewCount);
								}
		model.addAttribute("keySet", data.keySet());
		model.addAttribute("values", data.values());
		model.addAttribute("xAxeText", xAxeText);
		model.addAttribute("yAxeText", yAxeText);
		model.addAttribute("title", title);

		return "barChart";
	}
	
	

	@GetMapping("/pieChart")
	public String pieChart(Model model) {
		
			model.addAttribute("American", businessService.originLand("American").size()*100/businessRepository.count());
			model.addAttribute("Italian", businessService.originLand("Italian").size()*100/businessRepository.count());
			model.addAttribute("Vietnamese", businessService.originLand("Vitnamese").size()*100/businessRepository.count());
			model.addAttribute("Korean", businessService.originLand("Korean").size()*100/businessRepository.count());
			model.addAttribute("Chinese", businessService.originLand("Chinese").size()*100/businessRepository.count());
			model.addAttribute("Japanese", businessService.originLand("Japanese").size()*100/businessRepository.count());
			model.addAttribute("Moroccan", businessService.originLand("Moroccan").size()*100/businessRepository.count());
			model.addAttribute("Mexican", businessService.originLand("Mexican").size()*100/businessRepository.count());
			model.addAttribute("French", businessService.originLand("French").size()*100/businessRepository.count());
			model.addAttribute("Filipino", businessService.originLand("Filipino").size()*100/businessRepository.count());
			model.addAttribute("Irish", businessService.originLand("Irish").size()*100/businessRepository.count());
			model.addAttribute("Caribbean", businessService.originLand("Caribbean").size()*100/businessRepository.count());
			model.addAttribute("Thai", businessService.originLand("Thai").size()*100/businessRepository.count());
			model.addAttribute("Pakistani", businessService.originLand("Pakistani").size()*100/businessRepository.count());
			model.addAttribute("Indian", businessService.originLand("Indian").size()*100/businessRepository.count());
			model.addAttribute("Middle Eastern", businessService.originLand("Middle Eastern").size()*100/businessRepository.count());
			model.addAttribute("Puerto Rican", businessService.originLand("Puerto Rican").size()*100/businessRepository.count());
			model.addAttribute("Spanish", businessService.originLand("Spanish").size()*100/businessRepository.count());
			model.addAttribute("Greek", businessService.originLand("Greek").size()*100/businessRepository.count());
			model.addAttribute("African", businessService.originLand("African").size()*100/businessRepository.count());
			model.addAttribute("Turkish", businessService.originLand("Turkish").size()*100/businessRepository.count());
			model.addAttribute("Lebanese", businessService.originLand("Lebanese").size()*100/businessRepository.count());
			
		return "pieChart";
	}

}
