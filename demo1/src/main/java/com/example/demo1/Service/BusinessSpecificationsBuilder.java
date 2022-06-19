package com.example.demo1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo1.Model.Business;

public class BusinessSpecificationsBuilder {

	private final List<SearchCriteria> params;
	
	public BusinessSpecificationsBuilder () {
		params = new ArrayList<SearchCriteria>();
	}
	
	public BusinessSpecificationsBuilder with(String key, Object value, String operation) {
		params.add(new SearchCriteria(key, value, operation));
		return this;
	}
	
	public final BusinessSpecificationsBuilder with(BusinessSpecifications spec) {
		params.add(spec.getCriteria());
		return this;
	}

	public Specification<Business> build() {
		if(params.size() == 0) {
			return null;
		}
		
		List<Specification> specs = params.stream().map(BusinessSpecifications::new).collect(Collectors.toList());
		
		Specification result = specs.get(0);
		
		for(int i = 1; i < params.size() ; i++) {
			result = Specification.where(result).and(specs.get(i));
		}
		return result;
	}
}
