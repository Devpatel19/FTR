package com.example.demo.dto;


public class TerminalDTO {

	private String terminalId;
	private String terminalName;
	private String Country;
	private String itemType;
	private String terminalDescription;
	private Integer capacity;
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
	
}
