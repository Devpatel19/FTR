package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.example.demo.dto.FtrWorkitemTerminalDTO;

@Table(name="ftr_workitem_terminal")
@Entity
public class FtrWorkitemTerminal {
	
	@Id
	@Column(name="workitem_id")
	private String workitemId;
	@Column(name="terminal_id")
	private String terminalId;
	
//	@OneToOne(mappedBy="ftrWorkitemTerminal")
//	private FtrWorkitems ftrWorkitems;
	
	public FtrWorkitemTerminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FtrWorkitemTerminal(String workitemId, String terminalId) {
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
	
	public static FtrWorkitemTerminalDTO prepareFtrWorkitemTerminalDTO(FtrWorkitemTerminal ftrWorkitemTerminal) {
		FtrWorkitemTerminalDTO ftrWorkitemTerminalDTO = new FtrWorkitemTerminalDTO();
		ftrWorkitemTerminalDTO.setWorkitemId(ftrWorkitemTerminal.getWorkitemId());
		ftrWorkitemTerminalDTO.setTerminalId(ftrWorkitemTerminal.getTerminalId());
		return ftrWorkitemTerminalDTO;
	}
	
	

}
