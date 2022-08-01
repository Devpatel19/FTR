package com.example.demo.dto;

import com.example.demo.entity.FtrVehicleWorkitem;

public class FtrVehicleWorkitemDTO {
	
	private String vehicleNumber;

	private String workitemId;
	
	private String assignedWorkitemStatus;
	
	public FtrVehicleWorkitemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FtrVehicleWorkitemDTO(String vehicleNumber, String workitemId,String assignedWorkitemStatus) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.workitemId = workitemId;
		this.assignedWorkitemStatus=assignedWorkitemStatus;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getWorkitemId() {
		return workitemId;
	}

	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}
	
	
	public String getAssignedWorkitemStatus() {
		return assignedWorkitemStatus;
	}

	public void setAssignedWorkitemStatus(String assignedWorkitemStatus) {
		this.assignedWorkitemStatus = assignedWorkitemStatus;
	}

	public static FtrVehicleWorkitem prepareFtrVehicleWorkitem(FtrVehicleWorkitemDTO ftrVehicleWorkitemDTO) {
		FtrVehicleWorkitem ftrVehicleWorkitem = new FtrVehicleWorkitem();
		
		ftrVehicleWorkitem.setVehicleNumber(ftrVehicleWorkitemDTO.getVehicleNumber());
		ftrVehicleWorkitem.setWorkitemId(ftrVehicleWorkitemDTO.getVehicleNumber());
		ftrVehicleWorkitem.setAssignedWorkitemStatus(ftrVehicleWorkitemDTO.getAssignedWorkitemStatus());
		return ftrVehicleWorkitem;
	}
	
}
