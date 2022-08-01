package com.ftr.terminal.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftr.terminal.aspect.SuccessMessage;
import com.ftr.terminal.dto.TerminalDTO;
import com.ftr.terminal.exception.CapacityExceededException;
import com.ftr.terminal.exception.ItemTypeNotFoundException;
import com.ftr.terminal.exception.TerminalEmptyException;
import com.ftr.terminal.exception.TerminalNotFoundException;
import com.ftr.terminal.service.TerminalService;

@RestController
@RequestMapping("/ftr/terminals")
public class TerminalController {
	
    Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	TerminalService terminalService;
	
	@PostMapping
	public ResponseEntity<TerminalDTO> insertNewTerminal(@Valid @RequestBody TerminalDTO tDTO)
	{
		logger.info("Controller Method : insertNewTerminal");
		TerminalDTO t = terminalService.insertNewTerminal(tDTO);
		return ResponseEntity.ok(t);
	}
	
	@GetMapping
	public ResponseEntity<List<TerminalDTO>> fetchFTRTerminals() throws TerminalEmptyException
	{
		logger.info("Controller Method : fetchFTRTerminals");
		List<TerminalDTO> terminals = terminalService.fetchFTRTerminals();
		return ResponseEntity.ok(terminals);
	}
	
	@GetMapping("/fetchTerminalByTerminalId/{terminalId}")
	public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable String terminalId) throws TerminalNotFoundException
	{
		logger.info("Controller Method : fetchTerminalByTerminalId");
		TerminalDTO terminal = terminalService.fetchFTRTerminalByTerminalId(terminalId);
		return ResponseEntity.ok(terminal);
	}

	@GetMapping("/fetchTerminalByItemType/{itemType}")
	public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(@PathVariable String itemType) throws ItemTypeNotFoundException
	{
		logger.info("Controller Method : fetchTerminalsByItemType");
		List<TerminalDTO> terminals = terminalService.fetchTerminalsByItemType(itemType);
		return ResponseEntity.ok(terminals);
	}

	@PutMapping("/{terminalId}/{newCapacity}")
	public ResponseEntity<SuccessMessage> updateTerminal(@PathVariable String terminalId,@PathVariable Integer newCapacity) throws CapacityExceededException, TerminalNotFoundException
	{
		logger.info("Controller Method : updateTerminal");
		String status = terminalService.updateTerminal(terminalId,newCapacity);
		return ResponseEntity.ok(new SuccessMessage(status));
	}
	
	@PutMapping("/inc/{terminalId}/{newCapacity}")
	public ResponseEntity<SuccessMessage> updateTerminalInc(@PathVariable String terminalId,@PathVariable Integer newCapacity) throws CapacityExceededException, TerminalNotFoundException
	{
		logger.info("Controller Method : updateTerminalInc");
		String status = terminalService.updateTerminalInc(terminalId,newCapacity);
		return ResponseEntity.ok(new SuccessMessage(status));
	}
	
	@DeleteMapping("/{terminalId}")
	public ResponseEntity<SuccessMessage> removeTerminal(@PathVariable String terminalId) throws TerminalNotFoundException
	{
		logger.info("Controller Method : removeTerminal");
		String status = terminalService.removeTerminal(terminalId);
		return ResponseEntity.ok(new SuccessMessage(status));
	}

}
