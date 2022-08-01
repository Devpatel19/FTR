package com.vehicle.dto;


import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vehicle.entity.Vehicle;

public class VehicleDTO
{
	
	@NotNull(message="{vehicle.vehicleNumber.must}")
	@Pattern(regexp="(([A-Za-z]{2})[0-9]{4})",message="{vehicle.vehicleNumber.invalid}")
	private String vehicleNumber;
	
	@NotEmpty(message="{vehicle.vehicleName.must}")
	@Size(max=30,message="{vehicle.vehicleName.invalid}")
	private String vehicleName;
	
	@NotNull(message="{vehicle.maxLiftingCapacity.must}")
	private Double maxLiftingCapacity;
	
	@NotNull(message="{vehicle.retireDate.must}")
	@JsonFormat(pattern = "dd-MMM-yyyy",shape = JsonFormat.Shape.STRING)
	private Date retireDate;
	
	@NotNull(message="{vehicle.vehicleStatus.must}")
	private String vehicleStatus;
	
	@Column(name="harborlocation")
	private String harborLocation;
	
	private String country;

	
	public VehicleDTO()
	{
		
	}
	
	public VehicleDTO(String vehicleNumber, String vehicleName, Double maxLiftinCapacity, Date retireDate,
			String vehicleStatus, String harborLocation, String country) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.maxLiftingCapacity = maxLiftinCapacity;
		this.retireDate = retireDate;
		this.vehicleStatus = vehicleStatus;
		this.harborLocation = harborLocation;
		this.country = country;
	}
	

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Double getMaxLiftingCapacity() {
		return maxLiftingCapacity;
	}

	public void setMaxLiftingCapacity(Double maxLiftinCapacity) {
		this.maxLiftingCapacity = maxLiftinCapacity;
	}

	public Date getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Vehicles [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", maxLiftinCapacity="
				+ maxLiftingCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus
				+ ", harborLocation=" + harborLocation + ", country=" + country + "]";
	}
	
	public static Vehicle dtoToEntity(VehicleDTO vehicleDto) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicle.setVehicleName(vehicleDto.getVehicleName());
		vehicle.setMaxLiftingCapacity(vehicleDto.getMaxLiftingCapacity());
		vehicle.setRetireDate(vehicleDto.getRetireDate());
		vehicle.setVehicleStatus(vehicleDto.getVehicleStatus());
		vehicle.setHarborLocation(vehicleDto.getHarborLocation());
		vehicle.setCountry(vehicleDto.getCountry());
		return vehicle;
		}
	public static VehicleDTO EntityToDto(Vehicle vehicle)
	{
		VehicleDTO dto=new VehicleDTO();
		dto.setVehicleNumber(vehicle.getVehicleNumber());
		dto.setVehicleName(vehicle.getVehicleName());
		dto.setCountry(vehicle.getCountry());
		dto.setHarborLocation(vehicle.getHarborLocation());
		dto.setMaxLiftingCapacity(vehicle.getMaxLiftingCapacity());
		dto.setRetireDate(vehicle.getRetireDate());
		dto.setVehicleStatus(vehicle.getVehicleStatus());
		return dto;
	}
}

