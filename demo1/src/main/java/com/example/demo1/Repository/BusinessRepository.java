package com.example.demo1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo1.Model.Business;

@Repository
public interface BusinessRepository extends JpaSpecificationExecutor<Business>, JpaRepository<Business, Long>{

	List<Business> findByName(String name);
	List<Business> findByCity(String city);
	List<Business> findByState(String state);
	List<Business> findByPostalCode(int postalCode);
	List<Business> findByStars(double stars);
	List<Business> findByBusinessId(String businessId);
	Business findOneByName(String name);
	Business findOneByBusinessId(String businessId);
	
	@Query(value="SELECT city FROM business GROUP BY city ORDER BY COUNT(city) DESC limit 10", nativeQuery = true)
	List<String> findTopCities();
	
	@Query(value="SELECT state FROM business GROUP BY state ORDER BY COUNT(state) DESC limit 10", nativeQuery = true)
	List<String> findTopStates();
	
	@Query(value="SELECT name FROM business ORDER BY review_count DESC limit 10", nativeQuery = true)
	List<String> findTopReview();
}
