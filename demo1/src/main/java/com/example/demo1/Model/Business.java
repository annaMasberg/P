package com.example.demo1.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Business {

	public long id;
	public String businessId;
	public String name;
	public String address;
	public String city;
	public String state;
	public int postalCode;
	public double latitude;
	public double longitude;
	public int stars;
	public int reviewCount;
	public boolean isOpen;
	public HashMap<String, Boolean> attributes;
	public ArrayList<String> categories;
	public ArrayList<OpeningTimes> hours;

	
}
