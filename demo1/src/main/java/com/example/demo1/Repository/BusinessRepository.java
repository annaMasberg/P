package com.example.demo1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.Model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

	List<Business> findByName(String name);
	List<Business> findByCity(String city);
	List<Business> findByState(String state);
	List<Business> findByPostalCode(int postalCode);
	List<Business> findByStars(double stars);



}
