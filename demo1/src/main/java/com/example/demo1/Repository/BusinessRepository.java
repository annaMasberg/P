package com.example.demo1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	
	@Query(value="SELECT name FROM business ORDER BY review_count DESC limit 10", nativeQuery = true)
	List<String> findTopReviewName();
	
	@Query(value="SELECT review_count FROM business ORDER BY review_count DESC limit 10", nativeQuery = true)
	List<Integer> findTopReviews();
	
	@Query(value="SELECT count(name) FROM business WHERE attributes_businessacceptscreditcards = 1", nativeQuery = true)
	Integer findBusinessCreditCardCount();
	
	@Query(value="SELECT count(name) FROM business WHERE attributes_businessacceptscreditcards = 0", nativeQuery = true)
	Integer findBusinessNOCreditCardCount();
	
	@Query(value = "SELECT count(name) from business where categories like CONCAT('%',:keyword,'%');", nativeQuery = true)
	Integer findByOriginLand(@Param("keyword") String keyword);
	
	@Query(value="SELECT state FROM business GROUP BY state ORDER BY COUNT(state) DESC limit 10", nativeQuery = true)
	List<String> findTopStates();
	
	@Query(value="SELECT count(state) FROM business GROUP BY state ORDER BY COUNT(state) DESC limit 10", nativeQuery = true)
	List<Integer> findTopStatesCount();
	
	@Query(value="SELECT city FROM business WHERE state = CONCAT('%',:keyword,'%') GROUP BY city ORDER BY COUNT(city) DESC limit 10", nativeQuery = true)
	List<String> findTopCities(@Param("keyword") String keyword);
	
	@Query(value="SELECT count(city) FROM business WHERE state = CONCAT('%',:keyword,'%') GROUP BY city ORDER BY COUNT(city) DESC limit 10", nativeQuery = true)
	List<Integer> findTopCitiesCount(@Param("keyword") String keyword);
	
}
