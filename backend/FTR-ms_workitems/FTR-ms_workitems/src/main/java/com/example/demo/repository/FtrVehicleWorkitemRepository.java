package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FtrVehicleWorkitem;

@Repository
public interface FtrVehicleWorkitemRepository extends JpaRepository<FtrVehicleWorkitem,String>{
	
	FtrVehicleWorkitem getByVehicleNumber(String vehicleNumber);
	
	FtrVehicleWorkitem findByWorkitemId(String id);

}
