package com.example.demo1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private BusinessService businessService;

	@Autowired
	private TipRepository tipRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@GetMapping("/businessTable/{page}")
	public String showData(Model model, @PathVariable("page") Integer page) {

		Pageable pageable = PageRequest.of(page, 10);

		Page<Business> list = businessRepository.findAll(pageable);
		for (Business business : list) {
			business.attributesRestaurantspricerange = businessService.priceRangefinder(business);
			business.attributesAmbience = businessService.getBusinessAmbience(business);
			business.attributesBestnights = businessService.getBusinessBestNights(business);
			business.attributesBusinessparking = businessService.getBusinessParking(business);
			business.attributesDietaryrestrictions = businessService.getBusinessDietaryrestrictions(business);
			business.attributesGoodformeal = businessService.getBusinessGoodforMeal(business);
			business.attributesHairspecializesin = businessService.getBusinessHairspecializesin(business);
			business.attributesMusic = businessService.getBusinessMusic(business);
		}
		model.addAttribute("data", list);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", list.getTotalPages());

		return "businessTable";
	}
	
	@GetMapping("/businessRealTable/{page}")
	public String showDataInTable(Model model, @PathVariable("page") Integer page) {

		Pageable pageable = PageRequest.of(page, 10);

		Page<Business> list = businessRepository.findAll(pageable);
		for (Business business : list) {
			business.attributesRestaurantspricerange = businessService.priceRangefinder(business);
		}
		model.addAttribute("data", list);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", list.getTotalPages());

		return "businessRealTable";
	}

	@RequestMapping(value = "toBusinessTips", method = RequestMethod.POST)
	public String toBusinessTips(Model model, @RequestParam String businessId) {
		List<Tip> tipList = tipRepository.findAll();
		ArrayList<Tip> businessTipList = new ArrayList<>();
		model.addAttribute("data", businessService.tipsForBusiness(tipList, businessTipList, businessId));
		return "businessTipsTable";
	}

	@RequestMapping(value = "searchForFilteredBusinessByStats", method = RequestMethod.POST)
	public String searchForFilteredBusinessByStats(Model model, @RequestParam String name, @RequestParam String city,
			@RequestParam String state, @RequestParam String postalCode) {

		List<Business> data = businessService.findBusinessByStats(name, city, state, postalCode);

		model.addAttribute("data", data);
		model.addAttribute("currentPage", 10);
		model.addAttribute("totalPages", 10);
		return "BusinessTable";
	}

	@GetMapping(value = "/toCharts")
	public String toCHarts() {
		return "Charts";
	}

	@RequestMapping(value = "filterBusiness", method = RequestMethod.POST)
	public String searchForFilteredBusinesses(Model model, @RequestParam(required = false) String takesBusinessCard,
			@RequestParam(required = false) String attributesOpen24hours,
			@RequestParam(required = false) String attributesRestaurantstakeout,
			@RequestParam(required = false) String attributesWheelchairaccessible,
			@RequestParam(required = false) String attributesRestaurantstableservice,
			@RequestParam(required = false) String attributesRestaurantsreservations,
			@RequestParam(required = false) String attributesRestaurantsgoodforgroups,
			@RequestParam(required = false) String attributesRestaurantsdelivery,
			@RequestParam(required = false) String attributesRestaurantscounterservice,
			@RequestParam(required = false) String attributesOutdoorseating,
			@RequestParam(required = false) String attributesHastv,
			@RequestParam(required = false) String attributesHappyhour,
			@RequestParam(required = false) String attributesGoodforkids,
			@RequestParam(required = false) String attributesGoodfordancing,
			@RequestParam(required = false) String attributesDrivethru,
			@RequestParam(required = false) String attributesDogsallowed,
			@RequestParam(required = false) String attributesCoatcheck,
			@RequestParam(required = false) String attributesCaters,
			@RequestParam(required = false) String attributesByappointmentonly,
			@RequestParam(required = false) String attributesBusinessacceptsbitcoin,
			@RequestParam(required = false) String attributesBikeparking,
			@RequestParam(required = false) String attributesByob,
			@RequestParam(required = false) String attributesAcceptsinsurance,
			@RequestParam(required = false) String foodType, @RequestParam(required = false) String foodOrigin,
			@RequestParam(required = false) String drinkType, @RequestParam(required = false) String vegan,
			@RequestParam(required = false) String vegetarian, @RequestParam(required = false) String name,
			@RequestParam(required = false) String city,@RequestParam(required = false) String state,
			@RequestParam(required = false) String postalCode) {
		List<Business> data = businessService.businessFilter(takesBusinessCard, attributesOpen24hours,
				attributesRestaurantstakeout, attributesWheelchairaccessible, attributesRestaurantstableservice,
				attributesRestaurantsreservations, attributesRestaurantsgoodforgroups, attributesRestaurantsdelivery,
				attributesRestaurantscounterservice, attributesOutdoorseating, attributesHastv, attributesHappyhour,
				attributesGoodforkids, attributesGoodfordancing, attributesDrivethru, attributesDogsallowed,
				attributesCoatcheck, attributesCaters, attributesByappointmentonly, attributesBusinessacceptsbitcoin,
				attributesBikeparking, attributesByob, attributesAcceptsinsurance, foodType, foodOrigin, drinkType,
				vegan, vegetarian, name, city, state, postalCode);
		model.addAttribute("data", data);
		model.addAttribute("currentPage", 10);
		model.addAttribute("totalPages", 10);
		return "BusinessTable";
	}
	
	@RequestMapping(value = "filterBusinessInTable", method = RequestMethod.POST)
	public String searchForFilteredBusinessesInTable(Model model, @RequestParam(required = false) String takesBusinessCard,
			@RequestParam(required = false) String attributesOpen24hours,
			@RequestParam(required = false) String attributesRestaurantstakeout,
			@RequestParam(required = false) String attributesWheelchairaccessible,
			@RequestParam(required = false) String attributesRestaurantstableservice,
			@RequestParam(required = false) String attributesRestaurantsreservations,
			@RequestParam(required = false) String attributesRestaurantsgoodforgroups,
			@RequestParam(required = false) String attributesRestaurantsdelivery,
			@RequestParam(required = false) String attributesRestaurantscounterservice,
			@RequestParam(required = false) String attributesOutdoorseating,
			@RequestParam(required = false) String attributesHastv,
			@RequestParam(required = false) String attributesHappyhour,
			@RequestParam(required = false) String attributesGoodforkids,
			@RequestParam(required = false) String attributesGoodfordancing,
			@RequestParam(required = false) String attributesDrivethru,
			@RequestParam(required = false) String attributesDogsallowed,
			@RequestParam(required = false) String attributesCoatcheck,
			@RequestParam(required = false) String attributesCaters,
			@RequestParam(required = false) String attributesByappointmentonly,
			@RequestParam(required = false) String attributesBusinessacceptsbitcoin,
			@RequestParam(required = false) String attributesBikeparking,
			@RequestParam(required = false) String attributesByob,
			@RequestParam(required = false) String attributesAcceptsinsurance,
			@RequestParam(required = false) String foodType, @RequestParam(required = false) String foodOrigin,
			@RequestParam(required = false) String drinkType, @RequestParam(required = false) String vegan,
			@RequestParam(required = false) String vegetarian, @RequestParam(required = false) String name,
			@RequestParam(required = false) String city,@RequestParam(required = false) String state,
			@RequestParam(required = false) String postalCode) {
		List<Business> data = businessService.businessFilter(takesBusinessCard, attributesOpen24hours,
				attributesRestaurantstakeout, attributesWheelchairaccessible, attributesRestaurantstableservice,
				attributesRestaurantsreservations, attributesRestaurantsgoodforgroups, attributesRestaurantsdelivery,
				attributesRestaurantscounterservice, attributesOutdoorseating, attributesHastv, attributesHappyhour,
				attributesGoodforkids, attributesGoodfordancing, attributesDrivethru, attributesDogsallowed,
				attributesCoatcheck, attributesCaters, attributesByappointmentonly, attributesBusinessacceptsbitcoin,
				attributesBikeparking, attributesByob, attributesAcceptsinsurance, foodType, foodOrigin, drinkType,
				vegan, vegetarian, name, city, state, postalCode);
		model.addAttribute("data", data);
		model.addAttribute("currentPage", 10);
		model.addAttribute("totalPages", 10);
		return "BusinessRealTable";
	}
}
