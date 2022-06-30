package com.example.demo1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo1.Model.Business;
import com.example.demo1.Model.Location;
import com.example.demo1.Repository.BusinessRepository;

@Service
public class BusinessService {

	@Autowired
	BusinessRepository businessRepository;

	public Page<Business> businessFilter(Pageable pageable, String takesBusinessCard, String attributesOpen24hours,
			String attributesRestaurantstakeout, String attributesWheelchairaccessible,
			String attributesRestaurantstableservice, String attributesRestaurantsreservations,
			String attributesRestaurantsgoodforgroups, String attributesRestaurantsdelivery,
			String attributesRestaurantscounterservice, String attributesOutdoorseating, String attributesHastv,
			String attributesHappyhour, String attributesGoodforkids, String attributesGoodfordancing,
			String attributesDrivethru, String attributesDogsallowed, String attributesCoatcheck,
			String attributesCaters, String attributesByappointmentonly, String attributesBusinessacceptsbitcoin,
			String attributesBikeparking, String attributesByob, String attributesAcceptsinsurance, String foodType,
			String foodOrigin, String drinkType, String vegan, String vegetarian, String name, String city,
			String state, String postalCode, String pubs, String bars, String restaurants, String clubs, String hotels,
			String buffets, String salons, String apartments, String gyms, String bookstores, String shopping,
			String stores, String entertainments, String arts, String lounges, String doctors, String dentists,
			String chiropractors, String pet, String automotive, String homeServices, String banks, String spas,
			String education, String fitness, String glutenFree) {

		BusinessSpecificationsBuilder builder = new BusinessSpecificationsBuilder();
//-------------------------------------------------------------------------------------------------------------------------CHECKBOX
		if (takesBusinessCard != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesBusinessacceptscreditcards", true, "=");
			BusinessSpecifications specTakesCreditCard = new BusinessSpecifications(searchCriteria);
			builder.with(specTakesCreditCard);
		}

		if (attributesOpen24hours != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesOpen24hours", true, "=");
			BusinessSpecifications specattributesOpen24hours = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesOpen24hours);
		}

		if (attributesRestaurantstakeout != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesRestaurantstakeout", true, "=");
			BusinessSpecifications specattributesRestaurantstakeout = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesRestaurantstakeout);
		}

		if (attributesWheelchairaccessible != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesWheelchairaccessible", true, "=");
			BusinessSpecifications specattributesWheelchairaccessible = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesWheelchairaccessible);
		}

		if (attributesRestaurantstableservice != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesRestaurantstableservice", true, "=");
			BusinessSpecifications specattributesRestaurantstableservice = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesRestaurantstableservice);
		}

		if (attributesRestaurantsreservations != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesRestaurantsreservations", true, "=");
			BusinessSpecifications specattributesRestaurantsreservations = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesRestaurantsreservations);
		}

		if (attributesRestaurantsgoodforgroups != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesRestaurantsgoodforgroups", true, "=");
			BusinessSpecifications specattributesRestaurantsgoodforgroups = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesRestaurantsgoodforgroups);
		}

		if (attributesRestaurantsdelivery != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesRestaurantsdelivery", true, "=");
			BusinessSpecifications specattributesRestaurantsdelivery = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesRestaurantsdelivery);
		}

		if (attributesRestaurantscounterservice != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesRestaurantscounterservice", true, "=");
			BusinessSpecifications specattributesRestaurantscounterservice = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesRestaurantscounterservice);
		}

		if (attributesOutdoorseating != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesOutdoorseating", true, "=");
			BusinessSpecifications specattributesOutdoorseating = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesOutdoorseating);
		}

		if (attributesHastv != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesHastv", true, "=");
			BusinessSpecifications specattributesHastv = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesHastv);
		}

		if (attributesHappyhour != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesHappyhour", true, "=");
			BusinessSpecifications specattributesHappyhour = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesHappyhour);
		}

		if (attributesGoodforkids != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesGoodforkids", true, "=");
			BusinessSpecifications specattributesGoodforkids = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesGoodforkids);
		}

		if (attributesGoodfordancing != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesGoodfordancing", true, "=");
			BusinessSpecifications specattributesGoodfordancing = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesGoodfordancing);
		}

		if (attributesDrivethru != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesDrivethru", true, "=");
			BusinessSpecifications specattributesDrivethru = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesDrivethru);
		}

		if (attributesDogsallowed != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesDogsallowed", true, "=");
			BusinessSpecifications specattributesDogsallowed = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesDogsallowed);
		}

		if (attributesCoatcheck != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesCoatcheck", true, "=");
			BusinessSpecifications specattributesCoatcheck = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesCoatcheck);
		}

		if (attributesCaters != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesCaters", true, "=");
			BusinessSpecifications specattributesCaters = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesCaters);
		}

		if (attributesByappointmentonly != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesByappointmentonly", true, "=");
			BusinessSpecifications specattributesByappointmentonly = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesByappointmentonly);
		}

		if (attributesBusinessacceptsbitcoin != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesBusinessacceptsbitcoin", true, "=");
			BusinessSpecifications specattributesBusinessacceptsbitcoin = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesBusinessacceptsbitcoin);
		}

		if (attributesBikeparking != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesBikeparking", true, "=");
			BusinessSpecifications specattributesBikeparking = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesBikeparking);
		}

		if (attributesByob != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesByob", true, "=");
			BusinessSpecifications specattributesByob = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesByob);
		}

		if (attributesAcceptsinsurance != null) {
			SearchCriteria searchCriteria = new SearchCriteria("attributesAcceptsinsurance", true, "=");
			BusinessSpecifications specattributesAcceptsinsurance = new BusinessSpecifications(searchCriteria);
			builder.with(specattributesAcceptsinsurance);
		}

		if (vegan != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Vegan", ":");
			BusinessSpecifications specVegan = new BusinessSpecifications(searchCriteria);
			builder.with(specVegan);
		}

		if (vegetarian != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Vegetarian", ":");
			BusinessSpecifications specVegetarian = new BusinessSpecifications(searchCriteria);
			builder.with(specVegetarian);
		}

		if (pubs != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Pubs", ":");
			BusinessSpecifications specPubs = new BusinessSpecifications(searchCriteria);
			builder.with(specPubs);
		}

		if (bars != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Bars", ":");
			BusinessSpecifications specBars = new BusinessSpecifications(searchCriteria);
			builder.with(specBars);
		}

		if (restaurants != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Restaurants", ":");
			BusinessSpecifications specRestaurants = new BusinessSpecifications(searchCriteria);
			builder.with(specRestaurants);
		}

		if (clubs != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Clubs", ":");
			BusinessSpecifications specClubs = new BusinessSpecifications(searchCriteria);
			builder.with(specClubs);
		}

		if (hotels != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Hotels", ":");
			BusinessSpecifications specHotels = new BusinessSpecifications(searchCriteria);
			builder.with(specHotels);
		}

		if (buffets != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Buffets", ":");
			BusinessSpecifications specBuffets = new BusinessSpecifications(searchCriteria);
			builder.with(specBuffets);
		}

		if (salons != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Salons", ":");
			BusinessSpecifications specSalons = new BusinessSpecifications(searchCriteria);
			builder.with(specSalons);
		}
		if (apartments != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Apartments", ":");
			BusinessSpecifications specApartments = new BusinessSpecifications(searchCriteria);
			builder.with(specApartments);
		}

		if (gyms != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Gyms", ":");
			BusinessSpecifications specGyms = new BusinessSpecifications(searchCriteria);
			builder.with(specGyms);
		}

		if (bookstores != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Bookstores", ":");
			BusinessSpecifications specBookstores = new BusinessSpecifications(searchCriteria);
			builder.with(specBookstores);

		}

		if (shopping != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Shopping", ":");
			BusinessSpecifications specShopping = new BusinessSpecifications(searchCriteria);
			builder.with(specShopping);
		}

		if (stores != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Stores", ":");
			BusinessSpecifications specStores = new BusinessSpecifications(searchCriteria);
			builder.with(specStores);
		}
		if (entertainments != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Entertainments", ":");
			BusinessSpecifications specEntertainments = new BusinessSpecifications(searchCriteria);
			builder.with(specEntertainments);
		}
		if (arts != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Arts", ":");
			BusinessSpecifications specArts = new BusinessSpecifications(searchCriteria);
			builder.with(specArts);
		}
		if (lounges != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Lounges", ":");
			BusinessSpecifications specLounges = new BusinessSpecifications(searchCriteria);
			builder.with(specLounges);
		}
		if (doctors != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Doctors", ":");
			BusinessSpecifications specDoctors = new BusinessSpecifications(searchCriteria);
			builder.with(specDoctors);
		}
		if (dentists != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Dentists", ":");
			BusinessSpecifications specDentists = new BusinessSpecifications(searchCriteria);
			builder.with(specDentists);
		}
		if (chiropractors != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Chiropractors", ":");
			BusinessSpecifications specChiropractors = new BusinessSpecifications(searchCriteria);
			builder.with(specChiropractors);
		}
		if (pet != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Pet", ":");
			BusinessSpecifications specPet = new BusinessSpecifications(searchCriteria);
			builder.with(specPet);
		}
		if (automotive != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Automotive", ":");
			BusinessSpecifications specAutomotive = new BusinessSpecifications(searchCriteria);
			builder.with(specAutomotive);
		}
		if (homeServices != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Home Services", ":");
			BusinessSpecifications specHomeServices = new BusinessSpecifications(searchCriteria);
			builder.with(specHomeServices);
		}
		if (banks != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Banks", ":");
			BusinessSpecifications specBanks = new BusinessSpecifications(searchCriteria);
			builder.with(specBanks);
		}
		if (spas != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Spas", ":");
			BusinessSpecifications specSpas = new BusinessSpecifications(searchCriteria);
			builder.with(specSpas);
		}
		if (education != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Education", ":");
			BusinessSpecifications specEducation = new BusinessSpecifications(searchCriteria);
			builder.with(specEducation);
		}
		if (fitness != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Fitness", ":");
			BusinessSpecifications specFitness = new BusinessSpecifications(searchCriteria);
			builder.with(specFitness);
		}
		if (glutenFree != null) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", "Gluten-Free", ":");
			BusinessSpecifications specGlutenFree = new BusinessSpecifications(searchCriteria);
			builder.with(specGlutenFree);
		}

//-------------------------------------------------------------------------------------------------DROPDOWNS
		if (!foodType.equals("0")) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", foodType, ":");
			BusinessSpecifications specFoodType = new BusinessSpecifications(searchCriteria);
			builder.with(specFoodType);
		}

		if (!foodOrigin.equals("0")) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", foodOrigin, ":");
			BusinessSpecifications specFoodOrigin = new BusinessSpecifications(searchCriteria);
			builder.with(specFoodOrigin);
		}

		if (!drinkType.equals("0")) {
			SearchCriteria searchCriteria = new SearchCriteria("categories", drinkType, ":");
			BusinessSpecifications specDrinkType = new BusinessSpecifications(searchCriteria);
			builder.with(specDrinkType);
		}
//--------------------------------------------------------------------------------------------------INPUTS
		if (name != null && !name.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("name", name, "=");
			BusinessSpecifications specName = new BusinessSpecifications(searchCriteria);
			builder.with(specName);
		}

		if (state != null && !state.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("state", state, "=");
			BusinessSpecifications specState = new BusinessSpecifications(searchCriteria);
			builder.with(specState);
		}

		if (city != null && !city.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("city", city, "=");
			BusinessSpecifications specCity = new BusinessSpecifications(searchCriteria);
			builder.with(specCity);
		}
		if (postalCode != null && !postalCode.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("postalCode", postalCode, "=");
			BusinessSpecifications specPostalCode = new BusinessSpecifications(searchCriteria);
			builder.with(specPostalCode);
		}

		Specification<Business> specs = builder.build();

		return businessRepository.findAll(specs, pageable);

	}

	public Page<Business> findBusinessByStats(String name, String state, String city, String postalCode,
			Pageable pageable) {
		BusinessSpecificationsBuilder builder = new BusinessSpecificationsBuilder();

		if (name != null && !name.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("name", name, "=");
			BusinessSpecifications specName = new BusinessSpecifications(searchCriteria);
			builder.with(specName);
		}

		if (state != null && !state.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("state", state, "=");
			BusinessSpecifications specState = new BusinessSpecifications(searchCriteria);
			builder.with(specState);
		}

		if (city != null && !city.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("city", city, "=");
			BusinessSpecifications specCity = new BusinessSpecifications(searchCriteria);
			builder.with(specCity);
		}
		if (postalCode != null && !postalCode.isBlank()) {
			SearchCriteria searchCriteria = new SearchCriteria("postalCode", postalCode, "=");
			BusinessSpecifications specPostalCode = new BusinessSpecifications(searchCriteria);
			builder.with(specPostalCode);
		}

		Specification<Business> specs = builder.build();

		return businessRepository.findAll(specs, pageable);

	}

	public List<Location> locator(String businessId) {
		List<Business> list = businessRepository.findByBusinessId(businessId);
		ArrayList<Location> coordinations = new ArrayList<Location>();
		for (Business business : list) {
			int i1 = business.longitude.indexOf(".");
			int i2 = business.latitude.indexOf(".");
			coordinations.add(new Location(new double[] {
					Double.parseDouble(business.longitude.substring(0, i1 + 1)
							+ business.longitude.substring(i1).replaceAll("\\.", "")),
					Double.parseDouble(business.latitude.substring(0, i2 + 1)
							+ business.latitude.substring(i2).replaceAll("\\.", "")) },
					business.name));
		}
		return coordinations;
	}

	public String priceRangefinder(Business business) {

		if (business.attributesRestaurantspricerange.equals("1")) {
			return "$";
		} else if (business.attributesRestaurantspricerange.equals("2")) {
			return "$$";
		} else if (business.attributesRestaurantspricerange.equals("3")) {
			return "$$$";
		} else
			return "";
	}

	public String ambienceChanger(Business business) {
		String attribute = "";
		if (business.attributesAmbience.contains("'romantic': True")) {
			attribute = attribute + "Romantic · ";
		}
		if (business.attributesAmbience.contains("'intimate': True")) {
			attribute = attribute + "Intimate · ";
		}
		if (business.attributesAmbience.contains("'touristy': True'")) {
			attribute = attribute + "Touristy · ";
		}
		if (business.attributesAmbience.contains("'hipster': True")) {
			attribute = attribute + "Hipster · ";
		}
		if (business.attributesAmbience.contains("'classy': True")) {
			attribute = attribute + "Classy · ";
		}
		if (business.attributesAmbience.contains("'divey': True")) {
			attribute = attribute + "Divey · ";
		}
		if (business.attributesAmbience.contains("'trendy': True")) {
			attribute = attribute + "Trendy · ";
		}
		if (business.attributesAmbience.contains("'upscale': True")) {
			attribute = attribute + "Upscale · ";
		}
		if (business.attributesAmbience.contains("'casual': True")) {
			attribute = attribute + "Casual";
		}
		return attribute;
	}

	public String bestNightsChanger(Business business) {
		String attribute = " | Best Nights: ";
		if (business.attributesBestnights.contains("'monday': True")) {
			attribute = attribute + "Monday · ";
		}
		if (business.attributesBestnights.contains("'tuesday': True")) {
			attribute = attribute + "Tuesday · ";
		}
		if (business.attributesBestnights.contains("'wednesday': True'")) {
			attribute = attribute + "Wednesday · ";
		}
		if (business.attributesBestnights.contains("'thurday': True")) {
			attribute = attribute + "Thursday · ";
		}
		if (business.attributesBestnights.contains("'friday': True")) {
			attribute = attribute + "Friday · ";
		}
		if (business.attributesBestnights.contains("'saturday': True")) {
			attribute = attribute + "Saturday · ";
		}
		if (business.attributesBestnights.contains("'sunday': True")) {
			attribute = attribute + "Sunday";
		}

		if (attribute.equals(" | Best Nights: ")) {
			return "";
		}
		return attribute;
	}

	public String parkingChanger(Business business) {
		String attribute = " | Parking: ";
		if (business.attributesBusinessparking.contains("'garage': True")) {
			attribute = attribute + "Garage · ";
		}
		if (business.attributesBusinessparking.contains("'street': True")) {
			attribute = attribute + "Street · ";
		}
		if (business.attributesBusinessparking.contains("'lot': True")) {
			attribute = attribute + "Lot · ";
		}
		if (business.attributesBusinessparking.contains("'validated': True")) {
			attribute = attribute + "validated · ";
		}
		if (business.attributesBusinessparking.contains("'valet': True")) {
			attribute = attribute + "with Valet";
		}

		if (attribute.equals(" | Parking: ")) {
			return "";
		}
		return attribute;
	}

	public String mealChanger(Business business) {
		String attribute = " | Meal: ";
		if (business.attributesGoodformeal.contains("'dessert': True")) {
			attribute = attribute + "dessert · ";
		}
		if (business.attributesGoodformeal.contains("'latenight': True")) {
			attribute = attribute + "late Night · ";
		}
		if (business.attributesGoodformeal.contains("'lunch': True")) {
			attribute = attribute + "lunch · ";
		}
		if (business.attributesGoodformeal.contains("'dinner': True")) {
			attribute = attribute + "dinner · ";
		}
		if (business.attributesGoodformeal.contains("'brunch': True")) {
			attribute = attribute + "brunch · ";
		}
		if (business.attributesGoodformeal.contains("'breakfast': True")) {
			attribute = attribute + "breakfast · ";
		}
		if (attribute.equals(" | Meal: ")) {
			return "";
		}
		return attribute;
	}

	public String dietrestrictionsChanger(Business business) {
		String attribute = " | Dietary Restrictions: ";
		if (business.attributesDietaryrestrictions.contains("'dairy-free': True")) {
			attribute = attribute + "Dairy-free · ";
		}
		if (business.attributesDietaryrestrictions.contains("'gluten-free': True")) {
			attribute = attribute + "Gluten-free · ";
		}
		if (business.attributesDietaryrestrictions.contains("'vegan': True")) {
			attribute = attribute + "Vegan · ";
		}
		if (business.attributesDietaryrestrictions.contains("'kosher': True")) {
			attribute = attribute + "Kosher · ";
		}
		if (business.attributesDietaryrestrictions.contains("'halal': True")) {
			attribute = attribute + "Halal · ";
		}
		if (business.attributesDietaryrestrictions.contains("'soy-free': True")) {
			attribute = attribute + "Soy-free · ";
		}
		if (business.attributesDietaryrestrictions.contains("'vegetarian': True")) {
			attribute = attribute + "Vegetarian · ";
		}

		if (attribute.equals(" | Dietary Restrictions: ")) {
			return "";
		}
		return attribute;
	}

	public String hairChanger(Business business) {
		String attribute = " | Hair Specialization: ";
		if (business.attributesHairspecializesin.contains("'straightperms': True")) {
			attribute = attribute + "Straight Perms · ";
		}
		if (business.attributesHairspecializesin.contains("'coloring': True")) {
			attribute = attribute + "Coloring · ";
		}
		if (business.attributesHairspecializesin.contains("'extensions': True")) {
			attribute = attribute + "Extensions · ";
		}
		if (business.attributesHairspecializesin.contains("'africanamerican': True")) {
			attribute = attribute + "African American · ";
		}
		if (business.attributesHairspecializesin.contains("'curly': True")) {
			attribute = attribute + "Curly · ";
		}
		if (business.attributesHairspecializesin.contains("'kids': True")) {
			attribute = attribute + "Kids · ";
		}
		if (business.attributesHairspecializesin.contains("'perms': True")) {
			attribute = attribute + "Perms · ";
		}
		if (business.attributesHairspecializesin.contains("'asian': True")) {
			attribute = attribute + "Asian · ";
		}

		if (attribute.equals(" | Hair Specialization: ")) {
			return "";
		}

		return attribute;
	}

	public String musicChanger(Business business) {
		String attribute = " | Music: ";
		if (business.attributesMusic.contains("'dj': True")) {
			attribute = attribute + "DJ · ";
		}
		if (business.attributesMusic.contains("'backgroud_music': True")) {
			attribute = attribute + "Backgroud Music · ";
		}
		if (business.attributesMusic.contains("'no_music': True")) {
			attribute = attribute + "No Music · ";
		}
		if (business.attributesMusic.contains("'jukebox': True")) {
			attribute = attribute + "JukeBox · ";
		}
		if (business.attributesMusic.contains("'live': True")) {
			attribute = attribute + "Live · ";
		}
		if (business.attributesMusic.contains("'video': True")) {
			attribute = attribute + "Video · ";
		}
		if (business.attributesMusic.contains("'karaoke': True")) {
			attribute = attribute + "Karaoke · ";
		}
		if (attribute.equals(" | Music: ")) {
			return "";
		}
		return attribute;
	}

	// ----------------------------------------------------------------------------
	// FOR REPOSITORY

	public List<String> topReviewedBusinessesName() {
		return businessRepository.findTopReviewName();
	}

	public List<Integer> topReviewedBusinesses() {
		return businessRepository.findTopReviews();
	}

	public Integer originLand(String land) {
		return businessRepository.findByOriginLand(land);
	}

	public Integer acceptCreditCard() {
		return businessRepository.findBusinessCreditCardCount();
	}

	public Integer acceptNoCreditCard() {
		return businessRepository.findBusinessNOCreditCardCount();
	}

	public List<String> topCities(String state) {
		return businessRepository.findTopCities(state);
	}
	
	public List<Integer> topCitiesCount(String state) {
		return businessRepository.findTopCitiesCount(state);
	}

	public List<String> topStates() {
		return businessRepository.findTopStates();
	}

	public List<Integer> topStatesCount() {
		return businessRepository.findTopStatesCount();
	}


}
