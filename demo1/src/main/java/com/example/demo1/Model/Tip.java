package com.example.demo1.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tip {

	@Id
	public String userId;
	
	public String businessId;
	
	public String text;
	
	public String date; 			//DATETIME
	
	public int complimentCount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getComplimentCount() {
		return complimentCount;
	}

	public void setComplimentCount(int complimentCount) {
		this.complimentCount = complimentCount;
	}
	
}
