package com.example.demo1.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo1.Model.Business;

public class BusinessSpecifications implements Specification<Business>{
	
	private SearchCriteria criteria;

	public BusinessSpecifications(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Business> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue().toString()));
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	public SearchCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	

	
	  
	}
