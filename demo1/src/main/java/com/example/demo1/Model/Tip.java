package com.example.demo1.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Tip {

	@Id
	@Column(name = "user_id")
	public String user_id;
	
	@Column(name = "business_id")
	public String business_id;
	
	@Column(name = "text")
	public String text;
	
	@Column(name = "date")
	public String date; 			//DATETIME
	
	@Column(name = "compliment_count")
	public int compliment_count;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
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

	public int getCompliment_count() {
		return compliment_count;
	}

	public void setCompliment_count(int compliment_count) {
		this.compliment_count = compliment_count;
	}
	
	
}
