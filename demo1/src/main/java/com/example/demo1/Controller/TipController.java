package com.example.demo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo1.Model.Tip;
import com.example.demo1.Service.TipService;

@Controller
public class TipController {

	@Autowired
	TipService tipService;

	@PostMapping("/toTips")
	public String toTipsTable(Model model, @RequestParam String businessId) {
		List<Tip> data = tipService.tipsfinder(businessId);
		model.addAttribute("data", data);
		return "tipTable";
	}

}
