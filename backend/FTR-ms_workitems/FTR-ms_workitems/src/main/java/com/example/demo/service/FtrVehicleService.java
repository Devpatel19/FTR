package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FtrVehicleWorkitemDTO;
import com.example.demo.entity.FtrVehicleWorkitem;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.FtrVehicleWorkitemRepository;

@Service
public class FtrVehicleService {

	@Autowired
	FtrVehicleWorkitemRepository vehicleRepo;
	
	
	public FtrVehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber) throws  UserNotFoundException {
		Optional<FtrVehicleWorkitem> o = Optional.ofNullable(vehicleRepo.getByVehicleNumber(vehicleNumber));
		if(o.isPresent()) {
			return FtrVehicleWorkitem.prepareFtrVehicleWorkitemDTO(o.get());
		}else {
			throw new UserNotFoundException("Vehicle not available.");
		}
		
	}

}
