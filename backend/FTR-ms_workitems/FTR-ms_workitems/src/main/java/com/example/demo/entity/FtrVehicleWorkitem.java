package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.dto.FtrVehicleWorkitemDTO;

@Table(name="ftr_vehicle_workitem")
@Entity
public class FtrVehicleWorkitem {
	
	@Id
	@Column(name="workitem_id")
	private String workitemId;
	
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@Column(name="assigned_workitem_status")
	private String assignedWorkitemStatus;
	
//	@OneToOne(mappedBy="ftrVehicleWorkitem")
//	private FtrWorkitems ftrWorkitems;
	
	public FtrVehicleWorkitem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FtrVehicleWorkitem(String vehicleNumber, String workitemId,String assignedWorkitemStatus) {
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

	public static FtrVehicleWorkitemDTO prepareFtrVehicleWorkitemDTO(FtrVehicleWorkitem ftrVehicleWorkitem) {
		FtrVehicleWorkitemDTO ftrVehicleWorkitemDTO = new FtrVehicleWorkitemDTO();
		
		ftrVehicleWorkitemDTO.setVehicleNumber(ftrVehicleWorkitem.getVehicleNumber());
		ftrVehicleWorkitemDTO.setWorkitemId(ftrVehicleWorkitem.getVehicleNumber());
		ftrVehicleWorkitemDTO.setAssignedWorkitemStatus(ftrVehicleWorkitem.getAssignedWorkitemStatus());
		
		return ftrVehicleWorkitemDTO;
	}
	
	
	

}
