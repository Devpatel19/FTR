package com.ftr.terminal.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ftr.terminal.entity.Terminal;

public class TerminalDTO {

	private String terminalId;
	
	@NotNull(message = "{terminal.terminalName.must}")
	@Size(min = 3,max = 20,message = "{terminal.terminalName.invalid}")
	private String terminalName;
	

	@NotNull(message = "{terminal.country.must}")
	@Size(min = 3,max = 20,message = "{terminal.country.invalid}")
	private String Country;
	

	@NotNull(message = "{terminal.itemType.must}")
	@Size(min = 4,max = 30,message = "{terminal.itemType.invalid}")
	private String itemType;
	
	@NotNull(message = "{terminal.terminalDescription.must}")
	@Size(max = 25,message = "{terminal.terminalDescriptionLength.invalid}")
	private String terminalDescription;

	@NotNull(message = "{terminal.capacity.must}")
	@Max(value = 99999,message = "{terminal.capacity.invalid}")
	private Integer capacity;
	
	@NotNull(message = "{terminal.status.must}")
	private String status;
	private String harborLocation;
	private Integer availableCapacity;
	
	public TerminalDTO() {
		
	}
	public TerminalDTO(String terminalId, String terminalName, String country, String itemType,
			String terminalDescription, Integer capacity, String status, String harborLocation,
			Integer availableCapacity) {
		super();
		this.terminalId = terminalId;
		this.terminalName = terminalName;
		this.Country = country;
		this.itemType = itemType;
		this.terminalDescription = terminalDescription;
		this.capacity = capacity;
		this.status = status;
		this.harborLocation = harborLocation;
		this.availableCapacity = availableCapacity;
	}
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
	
	public Terminal convertToEntity()
	{
		Terminal terminal = new Terminal();
		terminal.setAvailableCapacity(availableCapacity);
		terminal.setCapacity(capacity);
		terminal.setCountry(Country);
		terminal.setItemType(itemType);
		terminal.setStatus(status);
		terminal.setTerminalDescription(terminalDescription);
		terminal.setTerminalName(terminalName);
		terminal.setHarborLocation(harborLocation);
		
		return terminal;
	}
}
