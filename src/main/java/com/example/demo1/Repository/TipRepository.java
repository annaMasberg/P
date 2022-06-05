package com.example.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Model.Tip;

public interface TipRepository extends JpaRepository<Tip, Long> {

}
