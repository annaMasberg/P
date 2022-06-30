package com.example.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo1.Model.Tip;

public interface TipRepository extends JpaSpecificationExecutor<Tip>, JpaRepository<Tip, Long> {

}
