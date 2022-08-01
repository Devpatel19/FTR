package com.ftr.terminal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ftr.terminal.dto.TerminalDTO;

@Entity
@Table(name = "ftr_terminals")
public class Terminal {
	
	@Id
	@GenericGenerator(name = "custom_gen", strategy = "com.ftr.terminal.generator.TerminalIdGenerator") 
	@GeneratedValue(generator = "custom_gen") 
	private String terminalId;
	private String terminalName;
	private String Country;
	private String itemType;
	private String terminalDescription;
	private Integer capacity;
	private String status;
	
	@Column(name = "harborLocation")
	private String harborLocation;
	private Integer availableCapacity;
	
	
	
	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTerminalDescription() {
		return terminalDescription;
	}

	public void setTerminalDescription(String terminalDescription) {
		this.terminalDescription = terminalDescription;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}

	public Integer getAvailableCapacity() {
		return availableCapacity;
	}

	public void setAvailableCapacity(Integer availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public TerminalDTO convertToDTO()
	{
		TerminalDTO terminalDTO = new TerminalDTO(terminalId,terminalName,Country,itemType,terminalDescription,capacity,status,harborLocation,availableCapacity);
		return terminalDTO;
	}
	
}
