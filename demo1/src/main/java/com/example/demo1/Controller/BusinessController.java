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

@Controller
public class BusinessController {

	@Autowired
	private BusinessRepository businessRepo;
	
	@Autowired
	private TipRepository tipRepo;
	
	@RequestMapping("/businessTable")
	public Model showData(Model model) {
		List<Business> list = businessRepo.findAll();
		model.addAttribute("data", list);
		return model;
	}
	
	@RequestMapping(value = "toBusinessTips", method = RequestMethod.POST)
	public String toBusinessTips(Model model, @RequestParam String business_id) {
		
		List<Tip> tipList = tipRepo.findAll();
		
		ArrayList<Tip> businessTipList = new ArrayList<>();
		
		for (Tip e : tipList) {
			if(business_id.equals(e.business_id)) {
				businessTipList.add(e);
			}
		}
		
		model.addAttribute("data", businessTipList);
		return "businessTipsTable";
		
	}
	
}
