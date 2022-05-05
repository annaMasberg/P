package com.example.demo1.Model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Business {
	
	public Business() {
	}
	
	@Id
	@Column(name = "business_id")
	public String businessId;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "address")
	public String address;
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "state")
	public String state;
	
	@Column(name = "postal_code")
	public int postal_code;
	
	@Column(name = "latitude")
	public String latitude;
	
	@Column(name = "longitude")
	public String longitude;
	
	@Column(name = "stars")
	public double stars;
	
	@Column(name = "review_count")
	public double review_count;
	
	@Column(name = "is_open")
	public boolean is_open;
	
	
	@Column(name = "attributes")
	public String attributes;				// ArrayList
	
	@Column(name = "categories")			// HashMap
	public String categories;
	
	@Column(name = "hours")
	public String hours;
}
