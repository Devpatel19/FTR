package com.example.demo.dto;



import java.util.Date;




public class VehicleDTO
{
	

	private String vehicleNumber;
	

	private String vehicleName;

	private Double maxLiftinCapacity;
	

	private Date retireDate;
	

	private String vehicleStatus;
	

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
		this.maxLiftinCapacity = maxLiftinCapacity;
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

	public Double getMaxLiftinCapacity() {
		return maxLiftinCapacity;
	}

	public void setMaxLiftinCapacity(Double maxLiftinCapacity) {
		this.maxLiftinCapacity = maxLiftinCapacity;
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
				+ maxLiftinCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus
				+ ", harborLocation=" + harborLocation + ", country=" + country + "]";
	}
	

}

