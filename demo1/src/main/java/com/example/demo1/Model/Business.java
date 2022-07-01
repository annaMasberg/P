package com.example.demo1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Business {

	public Business() {
	}

	@Id
	public String businessId;

	public String name;

	public String address;

	public String city;

	public String state;

	public String postalCode;

	public double stars;

	public int reviewCount;

	public String categories;

	public String latitude;

	public String longitude;

	public boolean isOpen;

	public String hoursMonday;
	public String hoursTuesday;
	public String hoursWednesday;
	public String hoursThursday;
	public String hoursFriday;
	public String hoursSaturday;
	public String hoursSunday;

	// ------------------------------------------------------------- HOURS

	// ------------------------------------------------------------- ATTRIBUTES
	public boolean attributesAcceptsinsurance;
	public boolean attributesByob;
	public boolean attributesBikeparking;
	public boolean attributesBusinessacceptsbitcoin;
	public boolean attributesBusinessacceptscreditcards;
	public boolean attributesByappointmentonly;
	public boolean attributesCaters;
	public boolean attributesCoatcheck;
	public boolean attributesCorkage;
	public boolean attributesDogsallowed;
	public boolean attributesDrivethru;
	public boolean attributesGoodfordancing;
	public boolean attributesGoodforkids;
	public boolean attributesHappyhour;
	public boolean attributesHastv;
	public boolean attributesOutdoorseating;
	public boolean attributesRestaurantscounterservice;
	public boolean attributesRestaurantsdelivery;
	public boolean attributesRestaurantsgoodforgroups;
	public boolean attributesRestaurantsreservations;
	public boolean attributesRestaurantstableservice;
	public boolean attributesRestaurantstakeout;
	public boolean attributesWheelchairaccessible;
	public boolean attributesOpen24hours;

	public String attributesAgesallowed;
	public String attributesAlcohol;
	public String attributesByobcorkage;
	public String attributesNoiselevel;
	public String attributesRestaurantsattire;
	public String attributesSmoking;
	public String attributesWifi;
	public String attributesAmbience;
	public String attributesBestnights;
	public String attributesBusinessparking;
	public String attributesRestaurantspricerange;
	public String attributesDietaryrestrictions;
	public String attributesGoodformeal;
	public String attributesHairspecializesin;
	public String attributesMusic;

}
