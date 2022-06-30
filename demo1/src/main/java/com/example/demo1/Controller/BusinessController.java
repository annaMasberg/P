package com.example.demo1.Controller;

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
import com.example.demo1.Repository.BusinessRepository;
import com.example.demo1.Service.BusinessService;

@Controller
public class BusinessController {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private BusinessRepository businessRepository;

	@GetMapping("/businessTable/{page}")
	public String showData(Model model, @PathVariable("page") Integer page) {

		Pageable pageable = PageRequest.of(page, 10);

		Page<Business> list = businessRepository.findAll(pageable);

		for (Business business : list) {
			business.attributesRestaurantspricerange = businessService.priceRangefinder(business);
			business.attributesAmbience = businessService.ambienceChanger(business);
			business.attributesBestnights = businessService.bestNightsChanger(business);
			business.attributesBusinessparking = businessService.parkingChanger(business);
			business.attributesDietaryrestrictions = businessService.dietrestrictionsChanger(business);
			business.attributesGoodformeal = businessService.mealChanger(business);
			business.attributesHairspecializesin = businessService.hairChanger(business);
			business.attributesMusic = businessService.musicChanger(business);
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

	@RequestMapping(value = "searchForFilteredBusinessByStats/{page}", method = RequestMethod.POST)
	public String searchForFilteredBusinessByStats(@PathVariable("page") Integer page, Model model,
			@RequestParam String name, @RequestParam String city, @RequestParam String state,
			@RequestParam String postalCode) {

		Pageable pageable = PageRequest.of(page, 10);

		Page<Business> data = businessService.findBusinessByStats(name, state, city, postalCode, pageable);

		model.addAttribute("data", data);
		model.addAttribute("currentPage", 10);
		model.addAttribute("totalPages", 10);
		return "BusinessTable";
	}

	@GetMapping(value = "/toCharts")
	public String toCHarts() {
		return "Charts";
	}

	@RequestMapping(value = "filterBusiness/{page}", method = RequestMethod.POST)
	public String searchForFilteredBusinesses(@PathVariable("page") Integer page, Model model,
			@RequestParam(required = false) String takesBusinessCard,
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
			@RequestParam(required = false) String city, @RequestParam(required = false) String state,
			@RequestParam(required = false) String postalCode, @RequestParam(required = false) String pubs,
			@RequestParam(required = false) String bars, @RequestParam(required = false) String restaurants,
			@RequestParam(required = false) String clubs, @RequestParam(required = false) String hotels,
			@RequestParam(required = false) String buffets, @RequestParam(required = false) String salons,
			@RequestParam(required = false) String apartments, @RequestParam(required = false) String gyms,
			@RequestParam(required = false) String bookstores, @RequestParam(required = false) String shopping,
			@RequestParam(required = false) String stores, @RequestParam(required = false) String entertainments,
			@RequestParam(required = false) String arts, @RequestParam(required = false) String lounges,
			@RequestParam(required = false) String doctors, @RequestParam(required = false) String dentists,
			@RequestParam(required = false) String chiropractors, @RequestParam(required = false) String pet,
			@RequestParam(required = false) String automotive, @RequestParam(required = false) String homeServices,
			@RequestParam(required = false) String banks, @RequestParam(required = false) String spas,
			@RequestParam(required = false) String education, @RequestParam(required = false) String fitness,
			@RequestParam(required = false) String glutenFree) {

		Pageable pageable = PageRequest.of(page, 10);

		Page<Business> data = businessService.businessFilter(pageable, takesBusinessCard, attributesOpen24hours,
				attributesRestaurantstakeout, attributesWheelchairaccessible, attributesRestaurantstableservice,
				attributesRestaurantsreservations, attributesRestaurantsgoodforgroups, attributesRestaurantsdelivery,
				attributesRestaurantscounterservice, attributesOutdoorseating, attributesHastv, attributesHappyhour,
				attributesGoodforkids, attributesGoodfordancing, attributesDrivethru, attributesDogsallowed,
				attributesCoatcheck, attributesCaters, attributesByappointmentonly, attributesBusinessacceptsbitcoin,
				attributesBikeparking, attributesByob, attributesAcceptsinsurance, foodType, foodOrigin, drinkType,
				vegan, vegetarian, name, city, state, postalCode, pubs, bars, restaurants, clubs, hotels, buffets,
				salons, apartments, gyms, bookstores, shopping, stores, entertainments, arts, lounges, doctors,
				dentists, chiropractors, pet, automotive, homeServices, banks, spas, education, fitness, glutenFree);
		model.addAttribute("data", data);
		model.addAttribute("currentPage", page);

		model.addAttribute("totalPages", data.getTotalPages());
		return "BusinessTable";
	}

	@RequestMapping(value = "filterBusinessInTable/{page}", method = RequestMethod.POST)
	public String searchForFilteredBusinessesInTable(@PathVariable("page") Integer page, Model model,
			@RequestParam(required = false) String takesBusinessCard,
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
			@RequestParam(required = false) String city, @RequestParam(required = false) String state,
			@RequestParam(required = false) String postalCode, @RequestParam(required = false) String pubs,
			@RequestParam(required = false) String bars, @RequestParam(required = false) String restaurants,
			@RequestParam(required = false) String clubs, @RequestParam(required = false) String hotels,
			@RequestParam(required = false) String buffets, @RequestParam(required = false) String salons,
			@RequestParam(required = false) String apartments, @RequestParam(required = false) String gyms,
			@RequestParam(required = false) String bookstores, @RequestParam(required = false) String shopping,
			@RequestParam(required = false) String stores, @RequestParam(required = false) String entertainments,
			@RequestParam(required = false) String arts, @RequestParam(required = false) String lounges,
			@RequestParam(required = false) String doctors, @RequestParam(required = false) String dentists,
			@RequestParam(required = false) String chiropractors, @RequestParam(required = false) String pet,
			@RequestParam(required = false) String automotive, @RequestParam(required = false) String homeServices,
			@RequestParam(required = false) String banks, @RequestParam(required = false) String spas,
			@RequestParam(required = false) String education, @RequestParam(required = false) String fitness,
			@RequestParam(required = false) String glutenFree) {

		Pageable pageable = PageRequest.of(page, 10);

		Page<Business> data = businessService.businessFilter(pageable, takesBusinessCard, attributesOpen24hours,
				attributesRestaurantstakeout, attributesWheelchairaccessible, attributesRestaurantstableservice,
				attributesRestaurantsreservations, attributesRestaurantsgoodforgroups, attributesRestaurantsdelivery,
				attributesRestaurantscounterservice, attributesOutdoorseating, attributesHastv, attributesHappyhour,
				attributesGoodforkids, attributesGoodfordancing, attributesDrivethru, attributesDogsallowed,
				attributesCoatcheck, attributesCaters, attributesByappointmentonly, attributesBusinessacceptsbitcoin,
				attributesBikeparking, attributesByob, attributesAcceptsinsurance, foodType, foodOrigin, drinkType,
				vegan, vegetarian, name, city, state, postalCode, pubs, bars, restaurants, clubs, hotels, buffets,
				salons, apartments, gyms, bookstores, shopping, stores, entertainments, arts, lounges, doctors,
				dentists, chiropractors, pet, automotive, homeServices, banks, spas, education, fitness, glutenFree);
		model.addAttribute("data", data);
		model.addAttribute("currentPage", 10);
		model.addAttribute("totalPages", 10);
		return "BusinessRealTable";
	}
}
