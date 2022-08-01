package com.vehicle.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dto.VehicleDTO;
import com.vehicle.entity.Vehicle;
import com.vehicle.exception.VehicleNotFoundException;
import com.vehicle.exception.VehicleStatusExistException;
import com.vehicle.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService 
{
	@Autowired 
	VehicleRepository vehicleRepository;
	
	String vehicleName[]={"Tower crane","Fireplace crane","Double treadwheel crane","Crawler crane","Aerial crane","Deck crane"};
	String vehicleStatus[]= {"Active","InProgress","Retired"};
	
	List<String> vehiclename=Arrays.asList(vehicleName);
	List<String> vehiclestatus=Arrays.asList(vehicleStatus);

	public String insertNewVehicle(VehicleDTO vehicleDto) throws Exception
	{
		Vehicle vehicle=new Vehicle();
		if(!vehiclename.contains(vehicleDto.getVehicleName()))
		{
			throw new Exception("Invalid Vehicle name, please check");
		
	    }
		if(!vehiclestatus.contains(vehicleDto.getVehicleStatus()))
		{
			throw new Exception("Vehicle Status should be either Active or InProgress or Retired");
		}
		else
		{
			vehicle=VehicleDTO.dtoToEntity(vehicleDto);
			vehicleRepository.save(vehicle);
		    return "Vehicle details are inserted successfully with vehicle number:"+vehicle.getVehicleNumber();
		}
	}
	
	public List<VehicleDTO> fetchAvailableVehicles() throws Exception
	{
		Optional<List<Vehicle>> vehicle=Optional.of(vehicleRepository.findAll());
		List<VehicleDTO> dto=new ArrayList<>();
		if(vehicle.get().isEmpty())
		{
			throw new Exception("Invalid Data");
		}
		else
		{
	    for(Vehicle v: vehicle.get()){
	    	dto.add(VehicleDTO.EntityToDto(v));
	    }
	    return dto;
		}
	}
	
	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws Exception
	{
		Optional<List<Vehicle>> vehicles=Optional.of(vehicleRepository.findByVehicleName(vehicleName));
		List<VehicleDTO> dto=new ArrayList<>();
		if(vehicles.get().isEmpty())
		{
			throw new Exception("Invalid Data");
		}
		else{
			for(Vehicle v: vehicles.get()){
		    	dto.add(VehicleDTO.EntityToDto(v));
		    }
			return dto;
		}
		
	}
	
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleNotFoundException
	{
		Optional<Vehicle> optional=vehicleRepository.findById(vehicleNumber);
		if(optional.isEmpty())
		{
			throw new VehicleNotFoundException("Vehicle Not Found");
		}
		return VehicleDTO.EntityToDto(optional.get());
	}
	
	public String updateVehicleStatus(String VehicleNum,VehicleDTO dto) throws VehicleNotFoundException,VehicleStatusExistException,Exception
	{
		
		Optional<Vehicle> opt=vehicleRepository.findById(VehicleNum);
		if(opt.isEmpty())
		{
			throw new VehicleNotFoundException("Vehicle details not found");	
		}
		if(!vehiclestatus.contains(dto.getVehicleStatus()))
		{
			throw new Exception("Vehicle Status should be either Active or InProgress or Retired");
		}
		if(opt.get().getVehicleStatus().equals(dto.getVehicleStatus()))
		{
			System.out.println(dto.getVehicleStatus());
			throw new VehicleStatusExistException("Vehicle Status is already Set");
		}
		Vehicle vehicle=VehicleDTO.dtoToEntity(dto);
		vehicleRepository.save(vehicle);
		return "Status of vehicleNumber :"+VehicleNum+"updated successfully";
		
		}

	
	public String removeVehicle(String VehicleNum) throws VehicleNotFoundException
	{
		Optional<Vehicle> opt=vehicleRepository.findById(VehicleNum);
		if(opt.isEmpty())
		{
			throw new VehicleNotFoundException("Vehicle details not found");	
		}
		else
		{
		vehicleRepository.deleteById(VehicleNum);
		return "Vehicle removed successfully";
	    }
		
	}
}

