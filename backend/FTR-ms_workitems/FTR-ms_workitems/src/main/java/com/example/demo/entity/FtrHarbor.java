package com.example.demo.entity;





import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import com.example.demo.dto.FtrHarborDTO;




@Table(name="ftr_harbor")
@Entity
public class FtrHarbor {
	
	@Id
	@Column(name="country")
	private String country;
	@Column(name="available_harbor_locations")
	private String availableHarborLocations;
	
//	@OneToOne(mappedBy="ftrHarbor",fetch=FetchType.LAZY)
//	private FtrWorkitems ftrWorkitems;
//	
	public FtrHarbor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FtrHarbor(String country, String availableHarborLocations) {
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
	
	public static FtrHarborDTO prepareFtrHarborDTO(FtrHarbor ftrHarbor) {
		FtrHarborDTO ftrHarborDTO = new FtrHarborDTO();
		
		ftrHarborDTO.setAvailableHarborLocations(ftrHarbor.getAvailableHarborLocations());
		ftrHarborDTO.setCountry(ftrHarbor.getCountry());
		
		return ftrHarborDTO;
	}

}
