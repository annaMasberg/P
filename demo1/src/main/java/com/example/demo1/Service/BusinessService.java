package com.example.demo1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Model.Business;
import com.example.demo1.Model.Location;
import com.example.demo1.Repository.BusinessRepository;

@Service
public class BusinessService {

	@Autowired
	BusinessRepository businessRepository;
	
	public ArrayList<Business> findBusiness(String text, String type) {
		ArrayList<Business> businessList = new ArrayList<Business>();
		switch(type) {
		case "name" : businessList = (ArrayList<Business>) businessRepository.findByName(text);
		break;
		case "city" : businessList = (ArrayList<Business>) businessRepository.findByCity(text);
		break;
		case "state" : businessList = (ArrayList<Business>) businessRepository.findByState(text);
		break;
		case "postalCode" : businessList = (ArrayList<Business>) businessRepository.findByPostalCode(Integer.valueOf(text));
		break;
		case "stars" : businessList = (ArrayList<Business>) businessRepository.findByStars(Double.parseDouble(text));
		default:
		break;
		}
		return businessList;
	}
	
	
	public List<Location> coolLocations(String businessId) {
		List<Business> list = businessRepository.findByBusinessId(businessId);
		ArrayList<Location> coordinations = new ArrayList<Location>();
		for(Business business : list) {
			int i1 = business.longitude.indexOf(".");
			int i2 = business.latitude.indexOf(".");
			coordinations.add(new Location(new double[] {Double.parseDouble(business.longitude.substring(0, i1 + 1) + business.longitude.substring(i1).replaceAll("\\.", "")),Double.parseDouble(business.latitude.substring(0, i2 + 1) + business.latitude.substring(i2).replaceAll("\\.", ""))}, business.name));
		}
			return coordinations;
		}
	
	public List<Location> filteredLocations(String text, String type){
		ArrayList<String> businessIds = new ArrayList<>();
		ArrayList<Location> locations = new ArrayList<>();
		ArrayList<Business> businessList = new ArrayList<>();
		
		for(Business business : findBusiness(text, type)) {
			businessIds.add(business.businessId);
		}
		
		for(String businessId : businessIds) {
		businessList.add(businessRepository.findOneByBusinessId(businessId));
		}
		

		for(Business business : businessList) {
			int i1 = business.longitude.indexOf(".");
			int i2 = business.latitude.indexOf(".");
			locations.add(new Location(new double[] {Double.parseDouble(business.longitude.substring(0, i1 + 1) + business.longitude.substring(i1).replaceAll("\\.", "")),Double.parseDouble(business.latitude.substring(0, i2 + 1) + business.latitude.substring(i2).replaceAll("\\.", ""))}, business.name));
		}
		return locations;
	}
		
	}




