package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FtrHarbor;

public interface FtrHarborRepository extends JpaRepository<FtrHarbor,String>{
    
	
	public FtrHarbor findByCountry(String country);
}
