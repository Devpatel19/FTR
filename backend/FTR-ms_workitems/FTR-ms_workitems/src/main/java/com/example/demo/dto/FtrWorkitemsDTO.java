package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

import com.example.demo.entity.FtrVehicleWorkitem;
import com.example.demo.entity.FtrWorkitemTerminal;
import com.example.demo.entity.FtrWorkitems;

public class FtrWorkitemsDTO {
	
	private Long userId;

	private String workitemId;

	private String itemName;

	private String itemType;

	private String itemDescription;

	private String messageToRecipient;

	private String quantity;

	private String sourceCountry;

	private String destinationCountry;
	
	
	private String originHarborLocation;
	
	private String selectedHarborLocation;
	@JsonFormat(pattern="dd-MMM-yyyy",shape=JsonFormat.Shape.STRING)
	private LocalDate shippingDate;

	private Integer amount;
	
	@JsonIgnore
	private  FtrWorkitemTerminal  ftrWorkitemTerminal;
	@JsonIgnore
	private FtrVehicleWorkitem ftrVehicleWorkitem;
	

	
	
	public FtrWorkitemsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public FtrWorkitemsDTO(Long userId, String workitemId, String itemName, String itemType, String itemDescription,
			String messageToRecipient, String quantity, String sourceCountry, String destinationCountry,
			String originHarborLocation, String selectedHarborLocation, LocalDate shippingDate, Integer amount) {
		super();
		this.userId = userId;
		this.workitemId = workitemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.messageToRecipient = messageToRecipient;
		this.quantity = quantity;
		this.sourceCountry = sourceCountry;
		this.destinationCountry = destinationCountry;
		this.originHarborLocation = originHarborLocation;
		this.selectedHarborLocation = selectedHarborLocation;
		this.shippingDate = shippingDate;
		this.amount = amount;
	}




	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getWorkitemId() {
		return workitemId;
	}


	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public String getMessageToRecipient() {
		return messageToRecipient;
	}


	public void setMessageToRecipient(String messageToRecipient) {
		this.messageToRecipient = messageToRecipient;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getSourceCountry() {
		return sourceCountry;
	}


	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}


	public String getDestinationCountry() {
		return destinationCountry;
	}


	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}


	public String getOriginHarborLocation() {
		return originHarborLocation;
	}


	public void setOriginHarborLocation(String originHarborLocation) {
		this.originHarborLocation = originHarborLocation;
	}


	public String getSelectedHarborLocation() {
		return selectedHarborLocation;
	}


	public void setSelectedHarborLocation(String selectedHarborLocation) {
		this.selectedHarborLocation = selectedHarborLocation;
	}


	public LocalDate getShippingDate() {
		return shippingDate;
	}


	public void setShippingDate(LocalDate shippingDate) {
		this.shippingDate = shippingDate;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
	public FtrWorkitemTerminal getFtrWorkitemTerminal() {
		return ftrWorkitemTerminal;
	}




	public void setFtrWorkitemTerminal(FtrWorkitemTerminal ftrWorkitemTerminal) {
		this.ftrWorkitemTerminal = ftrWorkitemTerminal;
	}




	public FtrVehicleWorkitem getFtrVehicleWorkitem() {
		return ftrVehicleWorkitem;
	}




	public void setFtrVehicleWorkitem(FtrVehicleWorkitem ftrVehicleWorkitem) {
		this.ftrVehicleWorkitem = ftrVehicleWorkitem;
	}




	public static FtrWorkitems prepareFtrWorkitems(FtrWorkitemsDTO ftrWorkitemsDTO) {
		FtrWorkitems ftrWorkitems = new FtrWorkitems();
		
		ftrWorkitems.setUserId(ftrWorkitemsDTO.getUserId());
		ftrWorkitems.setWorkitemId(ftrWorkitemsDTO.getWorkitemId());
		ftrWorkitems.setItemName(ftrWorkitemsDTO.getItemName());
		ftrWorkitems.setItemType(ftrWorkitemsDTO.getItemType());
		ftrWorkitems.setItemDescription(ftrWorkitemsDTO.getItemDescription());
		ftrWorkitems.setMessageToRecipient(ftrWorkitemsDTO.getMessageToRecipient());
		ftrWorkitems.setQuantity(ftrWorkitemsDTO.getQuantity());
		ftrWorkitems.setSourceCountry(ftrWorkitemsDTO.getSourceCountry());
		ftrWorkitems.setDestinationCountry(ftrWorkitemsDTO.getDestinationCountry());
		ftrWorkitems.setOriginHarborLocation(ftrWorkitemsDTO.getOriginHarborLocation());
		ftrWorkitems.setSelectedHarborLocation(ftrWorkitemsDTO.getSelectedHarborLocation());
		ftrWorkitems.setShippingDate(ftrWorkitemsDTO.getShippingDate());
		ftrWorkitems.setAmount(ftrWorkitemsDTO.getAmount());
		
		ftrWorkitems.setFtrWorkitemTerminal(ftrWorkitemsDTO.getFtrWorkitemTerminal());
		ftrWorkitems.setFtrVehicleWorkitem(ftrWorkitemsDTO.getFtrVehicleWorkitem());
		
		return ftrWorkitems;
		
	}

}
