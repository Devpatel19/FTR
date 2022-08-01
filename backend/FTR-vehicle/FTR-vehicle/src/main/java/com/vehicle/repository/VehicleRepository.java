package com.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vehicle.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> 
{
	public List<Vehicle> findByVehicleName(String vehicleName);
}
