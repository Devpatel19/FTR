package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.FtrWorkitems;

@Repository
public interface FtrWorkitemsRepository extends JpaRepository<FtrWorkitems,String>{
	FtrWorkitems findByUserId(Long userId);
	
	
	 public FtrWorkitems findByWorkitemId(String workitemId);

}
