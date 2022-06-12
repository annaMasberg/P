package com.example.demo1.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo1.Model.Business;
import com.example.demo1.Model.Location;
import com.example.demo1.Model.Tip;
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
	
	public ArrayList<Tip> tipsForBusiness(List<Tip> tipList, ArrayList<Tip> businessTipList, String businessId) {
		for (Tip tip : tipList) {
			if(businessId.equals(tip.businessId)) {
				businessTipList.add(tip);	}}
		return businessTipList;
	}
	
	public ArrayList<String> findDistinctStates(){
		ArrayList<String> uniqueStatesList = new ArrayList<>();
		ArrayList<String> states = new ArrayList<>();
		List<Business> businesses = businessRepository.findAll();
		for(Business e : businesses) {
			states.add(e.state);
		}
		
		HashSet<String> uniqueStates = new HashSet<>(states);

		for (String state : uniqueStates) {
			uniqueStatesList.add(state);
		}
		
		return uniqueStatesList;
	}
	
	public ArrayList<String> findDistinctCities(){
		ArrayList<String> uniqueCitiesList = new ArrayList<>();
		ArrayList<String> cities = new ArrayList<>();
		List<Business> businesses = businessRepository.findAll();
		for(Business e : businesses) {
			cities.add(e.city);
		}
		
		HashSet<String> uniqueCities = new HashSet<>(cities);

		for (String city : uniqueCities) {
			uniqueCitiesList.add(city);
		}
		
		return uniqueCitiesList;
	}
	
	public List<Business> filterBusiness(String name, String city, String state){
		
		BusinessSpecificationsBuilder builder = new BusinessSpecificationsBuilder();
						
		if(name != null && !name.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria( "name", name );	
			BusinessSpecifications spec1 = new BusinessSpecifications(searchCriteria);
			builder.with(spec1);
		}
		if(state != null && !state.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria( "state", state );	
			BusinessSpecifications spec2 = new BusinessSpecifications(searchCriteria);
			builder.with(spec2);	
		}
		if(city != null && !state.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria( "city", city );	
			BusinessSpecifications spec3 = new BusinessSpecifications(searchCriteria);
			builder.with(spec3);
		}
		Specification<Business> specs = builder.build();
		List<Business> businesses = businessRepository.findAll(specs);
		return businesses;
		
	}
	
	public Page<Business> searchAll(Pageable page) {
		return  businessRepository.findAll(page);
	}
	
	
	public List<Business> acceptCreditCard(){
		List<Business> businesses = businessRepository.findAll();
		List<Business> businessWithCard = new ArrayList<Business>();
		
		for(Business business : businesses) {
			if(business.attributes.contains("'BusinessAcceptsCreditCards': 'True'")) {
				businessWithCard.add(business);
			}
		}
		return businessWithCard;
	}
	
	public List<Business> acceptNoCreditCard(){
		List<Business> businesses = businessRepository.findAll();
		List<Business> businessWithNoCard = new ArrayList<Business>();

		for(Business business : businesses) {
		if(business.attributes.contains("'BusinessAcceptsCreditCards': 'False'")) {
			businessWithNoCard.add(business);
		}
		}
		return businessWithNoCard;
	}
	
	public List<Business> hasAttribute(List<String> attribute){
		List<Business> businesses = businessRepository.findAll();
		List<Business> sortedBusiness = new ArrayList<Business>();

		for(Business business : businesses) {
		if(attribute.stream().anyMatch(business.categories::contains)) {
			sortedBusiness.add(business);
		}
		}
		return sortedBusiness;
	}
	
	
	public List<Business> originLand(String land){
		List<Business> businesses = businessRepository.findAll();
		List<Business> originLand = new ArrayList<Business>();

		for(Business business : businesses) {
		if(business.categories.contains(land)) {
			originLand.add(business);
		}
		}
		return originLand;
	}
	
	
	public List<Business> foodType(String type){
		List<Business> businesses = businessRepository.findAll();
		List<Business> foodType = new ArrayList<Business>();

		for(Business business : businesses) {
		if(business.categories.contains(type)) {
			foodType.add(business);
		}
		}
		return foodType;
	}
	
	public List<Business> drinkType(String type){
		List<Business> businesses = businessRepository.findAll();
		List<Business> drinkType = new ArrayList<Business>();

		for(Business business : businesses) {
		if(business.categories.contains(type)) {
			drinkType.add(business);
		}
		}
		return drinkType;
	}
	
	public List<Business> isVegetarian(){
		List<Business> businesses = businessRepository.findAll();
		List<Business> isVegetarian = new ArrayList<Business>();

		for(Business business : businesses) {
		if(business.categories.contains("Vegetarian") ) {
			isVegetarian.add(business);
		}
		}
		return isVegetarian;
	}
	
	public List<Business> isVegan(){
		List<Business> businesses = businessRepository.findAll();
		List<Business> isVegan = new ArrayList<Business>();

		for(Business business : businesses) {
		if(business.categories.contains("Vegan")) {
			isVegan.add(business);
		}
		}
		return isVegan;
	}
	
	public List<String> cityCalculator(){
		return businessRepository.findTopCities();
	}
	
	public List<String> stateCalculator(){
		return businessRepository.findTopStates();
		}
	
	public List<String> topReviewedBusinesses(){
		return businessRepository.findTopReview();
	}
		
	}
