package com.example.demo1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/aboutUs")
	public String aboutUs() {
	return "aboutUs";
	
}
}