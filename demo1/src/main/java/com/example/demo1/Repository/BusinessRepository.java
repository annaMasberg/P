package com.example.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo1.Model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
