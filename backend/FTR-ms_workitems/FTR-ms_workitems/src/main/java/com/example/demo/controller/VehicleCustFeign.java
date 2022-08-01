package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.VehicleDTO;

@FeignClient(name="VehicleMS",url="http://localhost:9000/")
public interface VehicleCustFeign {
	
	@RequestMapping("/ftr/vehicles")
	public List<VehicleDTO> fetchAllVehicles();
	
	
	@RequestMapping(value="/ftr/vehicles/{vehicleNumber}",method=RequestMethod.PUT)
	public String updateVehicleStatus(@RequestBody VehicleDTO vDTO);


}