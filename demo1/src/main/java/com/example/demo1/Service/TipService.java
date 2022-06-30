package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo1.Model.Tip;
import com.example.demo1.Repository.TipRepository;

@Service
public class TipService {

	@Autowired
	private TipRepository tipRepository;

	public List<Tip> tipsfinder(String businessId) {

		TipSpecificationsBuilder builder = new TipSpecificationsBuilder();

		SearchCriteria searchCriteria = new SearchCriteria("businessId", businessId, "=");

		TipSpecifications specTips = new TipSpecifications(searchCriteria);

		builder.with(specTips);

		Specification<Tip> specs = builder.build();

		return tipRepository.findAll(specs);
	}

}
