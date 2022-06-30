package com.example.demo1.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo1.Model.Business;
import com.example.demo1.Repository.BusinessRepository;

public class GraphService {

	@Autowired
	BusinessRepository businessRepository;

}
