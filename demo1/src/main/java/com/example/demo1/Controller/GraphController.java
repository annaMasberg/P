package com.example.demo1.Controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo1.Repository.BusinessRepository;
import com.example.demo1.Service.BusinessService;

@Controller
public class GraphController {

	@Autowired
	BusinessRepository businessRepository;

	@Autowired
	BusinessService businessService;

	@RequestMapping(value = "Graphs", method = RequestMethod.POST)
	public String chartSender(Model model) {
		Map<String, Integer> graphDataForReviews = new TreeMap<>();

		List<String> names = businessService.topReviewedBusinessesName();
		List<Integer> count = businessService.topReviewedBusinesses();

		for (int i = 0; i < 10; i++) {
			graphDataForReviews.put(names.get(i), count.get(i));
		}

		Map<String, Integer> graphDataForFoodOrigin = new TreeMap<>();
		graphDataForFoodOrigin.put("American", businessService.originLand("American"));
		graphDataForFoodOrigin.put("Italian", businessService.originLand("Italian"));
		graphDataForFoodOrigin.put("Vietnamese", businessService.originLand("Vitnamese"));
		graphDataForFoodOrigin.put("Korean", businessService.originLand("Korean"));
		graphDataForFoodOrigin.put("Chinese", businessService.originLand("Chinese"));
		graphDataForFoodOrigin.put("Japanese", businessService.originLand("Japanese"));
		graphDataForFoodOrigin.put("Moroccan", businessService.originLand("Moroccan"));
		graphDataForFoodOrigin.put("Mexican", businessService.originLand("Mexican"));
		graphDataForFoodOrigin.put("French", businessService.originLand("French"));
		graphDataForFoodOrigin.put("Filipino", businessService.originLand("Filipino"));
		graphDataForFoodOrigin.put("Irish", businessService.originLand("Irish"));
		graphDataForFoodOrigin.put("Caribbean", businessService.originLand("Caribbean"));
		graphDataForFoodOrigin.put("Thai", businessService.originLand("Thai"));
		graphDataForFoodOrigin.put("Pakistani", businessService.originLand("Pakistani"));
		graphDataForFoodOrigin.put("Indian", businessService.originLand("Indian"));
		graphDataForFoodOrigin.put("Middle Eastern", businessService.originLand("Middle Eastern"));
		graphDataForFoodOrigin.put("Puerto Rican", businessService.originLand("Puerto Rican"));
		graphDataForFoodOrigin.put("Spanish", businessService.originLand("Spanish"));
		graphDataForFoodOrigin.put("Greek", businessService.originLand("Greek"));
		graphDataForFoodOrigin.put("African", businessService.originLand("African"));
		graphDataForFoodOrigin.put("Turkish", businessService.originLand("Turkish"));
		graphDataForFoodOrigin.put("Lebanese", businessService.originLand("Lebanese"));

		Map<String, Integer> graphDataForCreditCard = new TreeMap<>();
		graphDataForCreditCard.put("Credit Card", businessService.acceptCreditCard());
		graphDataForCreditCard.put("No Credit Card", businessService.acceptNoCreditCard());

		Map<String, Integer> graphTopStates = new TreeMap<>();

		List<String> stateName = businessService.topStates();
		List<Integer> stateCount = businessService.topStatesCount();
		for (int i = 0; i < 10; i++) {
			graphTopStates.put(stateName.get(i), stateCount.get(i));
		}
		
		model.addAttribute("graphDataForFoodOrigin", graphDataForFoodOrigin);
		model.addAttribute("graphDataForReviews", graphDataForReviews);
		model.addAttribute("graphDataForCreditCard", graphDataForCreditCard);
		model.addAttribute("graphTopStates", graphTopStates);

		model.addAttribute("titleForReviews", "Businesses with the most review Count");
		model.addAttribute("titleForFoodOrigin", "Proportion of Food Origins");
		model.addAttribute("titleForCreditCard", "Businesses who take Credit Card vs who dont");
		model.addAttribute("titleForTopStates", "Top 10 States with the most Businesses");

		model.addAttribute("xAxeTextForReviews", "Business");
		model.addAttribute("yAxeTextForReviews", "Review Count");

		model.addAttribute("xAxeTextForCreditCard", "Business");
		model.addAttribute("yAxeTextForCreditCard", "Credit Card Count");

		model.addAttribute("xAxeTextForTopStates", "Business");
		model.addAttribute("yAxeTextForTopStates", "Number of Businesses");
		return "chart";
	}
	
	@RequestMapping(value = "chartsCities", method = RequestMethod.POST)
	public String topCities(Model model, @RequestBody String state) {
		Map<String, Integer> graphTopCities = new TreeMap<>();

		List<String> cityName = businessService.topCities(state);
		List<Integer> cityCount = businessService.topCitiesCount(state);
		
		for (int i = 0; i < cityName.size(); i++) {
			graphTopCities.put(cityName.get(i), cityCount.get(i));
		}
		
		model.addAttribute("graphTopCities", graphTopCities);
		model.addAttribute("titleForTopCities", "Top 10 Cities with the most Businesses");
		model.addAttribute("xAxeTextForTopCities", "Business");
		model.addAttribute("yAxeTextForTopCities", "Number of Businesses");


		
		return "testChart";
		
	}
	
	
	
}
