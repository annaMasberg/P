package com.example.demo1.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Model.Business;
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

}


