package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.TerminalDTO;

@FeignClient(name="TerminalMS",url="http://localhost:9000/")
public interface TerminalCustFeign {
	
	@RequestMapping("ftr/terminals/fetchTerminalByItemType/{itemType}")
	public List<TerminalDTO> fetchListOfTerminals(@PathVariable String itemType);
	
	@RequestMapping("ftr/terminals/{terminalId}/{capacity}")
	public String updateTerminal(@PathVariable String terminalId, @PathVariable Integer capacity);
	
	@RequestMapping(value="ftr/terminals/inc/{terminalId}/{capacity}", method=RequestMethod.PUT)
	public String incTerminalCapacity(@PathVariable String terminalId, @PathVariable Integer capacity);


}