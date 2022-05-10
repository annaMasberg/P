package com.example.demo1.Controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo1.Model.Business;
import com.example.demo1.Repository.BusinessRepository;

@Controller
public class MapController {
	
	@Autowired
	BusinessRepository businessRepository;
	
	 @Value("${tomtom.apikey}")
	 private String tomTomApiKey;
	 
	 
	 private static class Location {
		 private final double[] lnglat;
		 private final String description;
		 public Location(double[] lnglat, String description) {
		   this.lnglat = lnglat;
		   this.description = description;
		 }

		 public double[] getLnglat() {
		   return lnglat;
		 }

		 public String getDescription() {
		   return description;
		 }

		}
	 
	 private List<Location> coolLocations() {
		List<Business> list = businessRepository.findAll();
		ArrayList<Location> coordinations = new ArrayList<Location>();
		for (Business business : list) {
			/*business.longitude = business.longitude.replace(".", "");
			business.latitude = business.latitude.replace(".", "");
			*/
			int i1 = business.longitude.indexOf(".");
			int i2 = business.latitude.indexOf(".");
			coordinations.add(new Location(new double[] {Double.parseDouble(business.longitude.substring(0, i1 + 1) + business.longitude.substring(i1).replaceAll("\\.", "")),Double.parseDouble(business.latitude.substring(0, i2 + 1) + business.latitude.substring(i2).replaceAll("\\.", ""))}, business.name));
		}
		 return coordinations;
		}
	 
	 @GetMapping("/home")
	 public String homePage(Model model) {
	   model.addAttribute("apikey", tomTomApiKey);
	   List<Location> lista = coolLocations();
	   model.addAttribute("coolLocations", lista);
	   return "home";
	 }
	 
}
