package com.vehicle.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vehicle.dto.VehicleDTO;


import org.springframework.cloud.client.ServiceInstance;
import com.vehicle.service.VehicleService;



@RestController
@CrossOrigin
@RequestMapping("/ftr")
@Validated
public class VehicleController
{
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	DiscoveryClient discoveryclient;
	
	@PostMapping(value="/vehicles") 
	public ResponseEntity<String> insertNewVehicle(@Valid @RequestBody VehicleDTO dto)throws Exception
	{
		String message=vehicleService.insertNewVehicle(dto);
		ResponseEntity<String> entity=new ResponseEntity<>(message,HttpStatus.ACCEPTED);
		return entity;

	}
	
	@GetMapping(value="/vehicles")
	public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws Exception
	{
		List<VehicleDTO> ldto=vehicleService.fetchAvailableVehicles();
		ResponseEntity<List<VehicleDTO>> entity=new ResponseEntity<>(ldto,HttpStatus.ACCEPTED);
		return entity;

	}
	
	@GetMapping(value="vehicles/managed-name/{vehicleName}")
	public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable("vehicleName") 	@Size(max=30,message="{vehicle.vehicleName.invalid}") String vehicleName) throws Exception
	{
		return ResponseEntity.ok(vehicleService.fetchVehicleDetailsByVehicleName(vehicleName));
	}	
	
	@GetMapping(value="vehicles/managed-number/{vehicleNumber}")
	public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable("vehicleNumber") @Pattern(regexp="(([A-Za-z]{2})[0-9]{4})",message="{vehicle.vehicleNumber.invalid}") String vehicleNumber) throws Exception
	{
		return ResponseEntity.ok(vehicleService.fetchVehicleDetailsByVehicleNumber(vehicleNumber));
	}	
	
	@PutMapping(value="/vehicles/{vehicleNumber}")
	public ResponseEntity<String> updateVehicleStatus(@PathVariable("vehicleNumber") @Pattern(regexp="(([A-Za-z]{2})[0-9]{4})",message="{vehicle.vehicleNumber.invalid}") String vehicleNum,@RequestBody VehicleDTO dto) throws Exception
	{

		String message=vehicleService.updateVehicleStatus(vehicleNum, dto);
		ResponseEntity<String> entity=new ResponseEntity<>(message,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@DeleteMapping(value="/vehicles/{vehicleNumber}")
	public ResponseEntity<String> removeVehicle(@PathVariable("vehicleNumber") @Pattern(regexp="(([A-Za-z]{2})[0-9]{4})",message="{vehicle.vehicleNumber.invalid}") String vehicleNum) throws Exception
	{
		List<ServiceInstance> serviceInstance=discoveryclient.getInstances("WorkItemsMS");
		String workitemUri = null;
		if (serviceInstance!= null && !serviceInstance.isEmpty()) {
			workitemUri = serviceInstance.get(0).getUri().toString();
		}
		String value=new RestTemplate().getForObject(workitemUri+"/ftr/workitems/managed-vehicle/"+vehicleNum,String.class);
		if(!value.isEmpty())
		{
			return ResponseEntity.ok(vehicleService.removeVehicle(vehicleNum));	
			
		}
		throw new Exception("Oops! something went wrong, please try again!");
		
	}
}
