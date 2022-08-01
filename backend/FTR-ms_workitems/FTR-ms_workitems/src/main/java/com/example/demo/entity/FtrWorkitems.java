package com.example.demo.entity;



//import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

import com.example.demo.dto.FtrWorkitemsDTO;
//import com.example.demo.util.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;

@Table(name="ftr_workitems")
@Entity
public class FtrWorkitems {
	

//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workid_seq")
//    @GenericGenerator(
//        name = "workid_seq", 
//        strategy = "org.thoughts.on.java.generators.StringPrefixedSequenceIdGenerator", 
//        parameters = {
//            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
//            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "J"),
//            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%34d") })
//	@Column(name="workitem_id")
	
	@Id
	@Size(max=5)
	private String workitemId;
	
	@NotNull(message="{workitem.userId.must}")
	@Min(value=0,message="{workitem.userId.invalid}")
	@Max(value=99999,message= "{workitem.userId.invalid}")
	@Column(name="user_id")
	private Long userId;
	
	@NotBlank(message="{workitem.itemName.must}")
	@Size(min=3,max=25,message= "{workitem.itemName.invalid}")
	@Column(name="item_name")
	private String itemName;
	
	@NotBlank(message="{workitem.itemType.must}")
	@Size(min=4,max=25,message= "{workitem.itemType.invalid}")
	@Column(name="itemType")
	private String itemType;
	
	@NotBlank(message="{workitem.itemDescription.must}")
	@Size(min=10,max=45,message= "{workitem.itemDescription.invalid}")
	@Column(name="item_description")
	private String itemDescription;
	
	@NotBlank(message="{workitem.messageToRecipient.must}")
	@Size(min=10,max=50,message= "{workitem.messageToRecipient.invalid}")
	@Column(name="message_to_recipient")
	private String messageToRecipient;
	
	@NotBlank(message= "{workitem.quantity.must}")
	@Column(name="quantity")
	private String quantity;
	
	@NotBlank(message="{workitem.sourceCountry.must}")
	@Size(min=5,max=25,message= "{workitem.sourceCountry.invalid}")
	@Column(name="source_country")
	private String sourceCountry;
	
	@NotBlank(message="{workitem.destinationCountry.must}")
	@Size(min=5,max=25,message= "{workitem.destinationCountry.invalid}")
	@Column(name="destination_country")
	private String destinationCountry;
	
	@Column(name="originHarborLocation")
	private String originHarborLocation;
	
	@NotBlank(message="{workitem.selectedHarborLocation.must}")
	@Size(min=5,max=25,message= "{workitem.selectedHarborLocation.invalid}")
	@Column(name="selected_harbor_location")
	private String selectedHarborLocation;
	
	@NotNull(message="{workitem.shippingDate.must}")
	@Column(name="shipping_date")
	@JsonFormat(pattern="dd-MMM-yyyy",shape=JsonFormat.Shape.STRING)
	private LocalDate shippingDate;
	
	
	@Column(name="amount")
	private Integer amount;
	

	  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "workitem_id", referencedColumnName = "workitem_id")
	private FtrWorkitemTerminal ftrWorkitemTerminal;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "workitem_id", referencedColumnName = "workitem_id")
		private FtrVehicleWorkitem ftrVehicleWorkitem;
//	  
//	  @OneToOne(cascade = CascadeType.ALL)
//	  @JoinColumn(name = "country",nullable=true,insertable=false,updatable=false)
//		private FtrHarbor ftrHarbor;
//	  
	  
	
	
	public FtrWorkitems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public FtrWorkitems(Long userId, String workitemId, String itemName, String itemType, String itemDescription,
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




	public static FtrWorkitemsDTO prepareFtrWorkitemsDTO(FtrWorkitems ftrWorkitems) {
		FtrWorkitemsDTO ftrWorkitemsDTO = new FtrWorkitemsDTO();
		
		ftrWorkitemsDTO.setUserId(ftrWorkitems.getUserId());
		ftrWorkitemsDTO.setWorkitemId(ftrWorkitems.getWorkitemId());
		ftrWorkitemsDTO.setItemName(ftrWorkitems.getItemName());
		ftrWorkitemsDTO.setItemType(ftrWorkitems.getItemType());
		ftrWorkitemsDTO.setItemDescription(ftrWorkitems.getItemDescription());
		ftrWorkitemsDTO.setMessageToRecipient(ftrWorkitems.getMessageToRecipient());
		ftrWorkitemsDTO.setQuantity(ftrWorkitems.getQuantity());
		ftrWorkitemsDTO.setSourceCountry(ftrWorkitems.getSourceCountry());
		ftrWorkitemsDTO.setDestinationCountry(ftrWorkitems.getDestinationCountry());
		ftrWorkitemsDTO.setOriginHarborLocation(ftrWorkitems.getOriginHarborLocation());
		ftrWorkitemsDTO.setSelectedHarborLocation(ftrWorkitems.getSelectedHarborLocation());
		ftrWorkitemsDTO.setShippingDate(ftrWorkitems.getShippingDate());
		ftrWorkitemsDTO.setAmount(ftrWorkitems.getAmount());
		
		ftrWorkitemsDTO.setFtrWorkitemTerminal(ftrWorkitems.getFtrWorkitemTerminal());
		ftrWorkitemsDTO.setFtrVehicleWorkitem(ftrWorkitems.getFtrVehicleWorkitem());

		
		return ftrWorkitemsDTO;
		
	}
	
	
	
	
	
	

}
