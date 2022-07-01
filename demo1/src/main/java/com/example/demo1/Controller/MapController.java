package com.example.demo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo1.Model.Location;
import com.example.demo1.Repository.BusinessRepository;
import com.example.demo1.Service.BusinessService;
import com.example.demo1.Service.TipService;

@Controller
public class MapController {

	@Autowired
	TipService tipService;

	@Autowired
	BusinessRepository businessRepository;

	@Autowired
	BusinessService businessService;

	@Value("${tomtom.apikey}")
	private String tomTomApiKey;

	@RequestMapping(value = "toMap", method = RequestMethod.POST)
	public String businesstoMap(Model model, @RequestParam String businessId) {
		model.addAttribute("apikey", tomTomApiKey);
		List<Location> locations = businessService.locator(businessId);
		
		model.addAttribute("coolLocations", locations);
		return "map";
	}

	@GetMapping("/filteredMap")
	public String homePage(Model model) {
		model.addAttribute("apikey", tomTomApiKey);
		return "filteredMap";
	}

}
