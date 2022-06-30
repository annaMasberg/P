package com.example.demo1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tip {

	@Id
	public String userId;

	public String businessId;

	public String tipReview;

	public String tipDate;

	public int complimentCount;

	public String getTipReview() {
		return tipReview;
	}

	public void setTipReview(String tipReview) {
		this.tipReview = tipReview;
	}

	public String getTipDate() {
		return tipDate;
	}

	public void setTipDate(String tipDate) {
		this.tipDate = tipDate;
	}

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

	public int getComplimentCount() {
		return complimentCount;
	}

	public void setComplimentCount(int complimentCount) {
		this.complimentCount = complimentCount;
	}

}
