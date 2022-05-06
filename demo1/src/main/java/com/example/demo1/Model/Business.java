package com.example.demo1.Model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Business {
	
	public Business() {
	}
	
	@Id
	@Column(name = "business_id")
	public String business_id;
	
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
	public int review_count;
	
	@Column(name = "is_open")
	public boolean is_open;
	
	
	@Column(name = "attributes")
	public String attributes;				// ArrayList
	
	@Column(name = "categories")			// HashMap
	public String categories;
	
	@Column(name = "hours")
	public String hours;

	public String getBusinessId() {
		return business_id;
	}

	public void setBusinessId(String businessId) {
		this.business_id = business_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public boolean isIs_open() {
		return is_open;
	}

	public void setIs_open(boolean is_open) {
		this.is_open = is_open;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}
	
	
	
}
