package com.example.demo.dto;

import com.example.demo.entity.FtrWorkitemTerminal;

public class FtrWorkitemTerminalDTO{
	
	private String workitemId;
	private String terminalId;

	
	public FtrWorkitemTerminalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FtrWorkitemTerminalDTO(String workitemId, String terminalId) {
		super();
		this.workitemId = workitemId;
		this.terminalId = terminalId;
	}

	public String getWorkitemId() {
		return workitemId;
	}

	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	
	

	public static FtrWorkitemTerminal prepareFtrWorkitemTerminal(FtrWorkitemTerminalDTO ftrWorkitemTerminalDTO) {
		FtrWorkitemTerminal ftrWorkitemTerminal = new FtrWorkitemTerminal();
		ftrWorkitemTerminal.setWorkitemId(ftrWorkitemTerminalDTO.getWorkitemId());
		ftrWorkitemTerminal.setTerminalId(ftrWorkitemTerminalDTO.getTerminalId());
		return ftrWorkitemTerminal;
	}

}
