package com.example.demo1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo1.Model.Tip;

public class TipSpecificationsBuilder {
	private final List<SearchCriteria> params;

	public TipSpecificationsBuilder () {
		params = new ArrayList<SearchCriteria>();
	}

	public TipSpecificationsBuilder with(String key, Object value, String operation) {
		params.add(new SearchCriteria(key, value, operation));
		return this;
	}

	public final TipSpecificationsBuilder with(TipSpecifications spec) {
		params.add(spec.getCriteria());
		return this;
	}

	public Specification<Tip> build() {
		if (params.size() == 0) {
			return null;
		}

		List<Specification> specs = params.stream().map(TipSpecifications::new).collect(Collectors.toList());

		Specification result = specs.get(0);

		for (int i = 1; i < params.size(); i++) {
			result = Specification.where(result).and(specs.get(i));
		}
		return result;
	}
}
