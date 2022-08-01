package com.example.demo.dto;




import java.util.List;

import com.example.demo.entity.FtrHarbor;





public class FtrHarborDTO {
	
	private String country;

	private String availableHarborLocations;
	
	public FtrHarborDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FtrHarborDTO(String country, String availableHarborLocations) {
		super();
		this.country = country;
		this.availableHarborLocations = availableHarborLocations;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAvailableHarborLocations() {
		return availableHarborLocations;
	}
	
	
	public void setAvailableHarborLocations(String availableHarborLocations) {
		this.availableHarborLocations = availableHarborLocations;
	}
	public static FtrHarbor prepareFtrHarbor(FtrHarborDTO ftrHarborDTO) {
		FtrHarbor ftrHarbor = new FtrHarbor();
		
		ftrHarbor.setAvailableHarborLocations(ftrHarborDTO.getAvailableHarborLocations());
		ftrHarbor.setCountry(ftrHarborDTO.getCountry());
		
		return ftrHarbor;
	}
	

}
