package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FtrVehicleWorkitemDTO;
import com.example.demo.dto.FtrWorkitemsDTO;

import com.example.demo.entity.FtrWorkitems;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.FtrVehicleService;
import com.example.demo.service.FtrWorkitemsService;



@Validated
@RequestMapping("/ftr")
@RestController
public class FtrWorkitemsController {
	
	@Autowired
	FtrWorkitemsService ftrWorkitemsService;
	
	@Autowired
	FtrVehicleService vehicleService;
	
	
	@PostMapping("/workItems")
	public ResponseEntity<FtrWorkitemsDTO> createWorkItem(@Valid @RequestBody FtrWorkitems ftrWi){
		
		FtrWorkitemsDTO  ftrWiDTO = FtrWorkitems.prepareFtrWorkitemsDTO(ftrWi);
		
		FtrWorkitemsDTO  ftWiDTOResponse = ftrWorkitemsService.createWorkitem(ftrWiDTO);

		ResponseEntity<FtrWorkitemsDTO> entity = new ResponseEntity<>( ftWiDTOResponse,HttpStatus.ACCEPTED);
		return entity;

	}
	
	@GetMapping("/workItems/managed-user/{userId}")
	public ResponseEntity<FtrVehicleWorkitemDTO> trackWorkItemByUser(@PathVariable Long userId) throws UserNotFoundException{
		FtrVehicleWorkitemDTO vehicleDTOResponse = ftrWorkitemsService.getVehicleData(userId);
		
		ResponseEntity<FtrVehicleWorkitemDTO> entity = new ResponseEntity<>( vehicleDTOResponse,HttpStatus.ACCEPTED);
		return entity;
	}
	
//	@PutMapping("/managed-update/{workitemId}")
//	public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workitemId) throws UserNotFoundException{
//		String msg = ftrWorkitemsService.updateWorkItemStatus(workitemId);
//		ResponseEntity<String> entity = new ResponseEntity<>( msg,HttpStatus.ACCEPTED);
//		return entity;
//	}
	
	@GetMapping("/workItems/managed-vehicle/{vehicleNumber}")
	public ResponseEntity<FtrVehicleWorkitemDTO> fetchWorkItemDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws UserNotFoundException{
			FtrVehicleWorkitemDTO vehicleDTO = vehicleService.fetchWorkItemDetailsByVehicleNumber(vehicleNumber);
			ResponseEntity<FtrVehicleWorkitemDTO> entity = new ResponseEntity<>( vehicleDTO,HttpStatus.ACCEPTED);
			return entity;
		}
	
	@PostMapping("/workItems/managed-terminal/{workItemId}")
	public ResponseEntity<String> assignTerminalForWorkItem(@PathVariable String workItemId)throws UserNotFoundException{
		String msg = ftrWorkitemsService.assignTerminalForWorkItem(workItemId);
		ResponseEntity<String> entity = new ResponseEntity<>( msg,HttpStatus.ACCEPTED);
		return entity;
	
	}
	
	@PostMapping("/workItems/managed-vehicle/{workItemId}")
	public ResponseEntity<String> allocateVehicle(@RequestBody FtrVehicleWorkitemDTO vehicleWiDTO,@PathVariable String workItemId) throws UserNotFoundException{
		String msg =  ftrWorkitemsService.allocateVehicle(workItemId,vehicleWiDTO);
		ResponseEntity<String> entity = new ResponseEntity<>( msg,HttpStatus.ACCEPTED);
		return entity;
	}
	@GetMapping("/workItems")
	public ResponseEntity<List<FtrWorkitemsDTO>> fetchWorkitemDetails(){
		List<FtrWorkitemsDTO> dto=ftrWorkitemsService.fetchWorkitemsDetails();
		ResponseEntity<List<FtrWorkitemsDTO>> entity=new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
		return entity;
		
	}
	@GetMapping("/workItems/{country}")
	public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable String country) throws UserNotFoundException{
		List<String> str=ftrWorkitemsService.fetchAvailableHarborLocations(country);
		ResponseEntity<List<String>> entity=new ResponseEntity<>(str,HttpStatus.ACCEPTED);
		return entity;
		
	}
	@GetMapping("/workItems/managed-status/{workItemId}")
	public ResponseEntity<FtrVehicleWorkitemDTO> fetchWorkitemStatus(@PathVariable String workItemId) throws UserNotFoundException{
		FtrVehicleWorkitemDTO dto=ftrWorkitemsService.fetchWorkitemStatus(workItemId);
		ResponseEntity<FtrVehicleWorkitemDTO> entity=new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
		return entity;
	}
	@PutMapping("/workItems/{workItemId}")
	public ResponseEntity<String> updateWorkitem(@PathVariable String workItemId,@RequestBody FtrWorkitemsDTO workitemDTO) throws UserNotFoundException{
		String msg=ftrWorkitemsService.updateWorkitem(workItemId, workitemDTO);
		ResponseEntity<String> entity=new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@PutMapping("/workItems/managed-update/{workItemId}")
	public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workItemId) throws UserNotFoundException{
		String msg = ftrWorkitemsService.updateWorkItemStatus(workItemId);
		ResponseEntity<String> entity = new ResponseEntity<>( msg,HttpStatus.ACCEPTED);
		return entity;
	}

	
}

