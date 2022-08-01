package com.ftr.terminal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftr.terminal.dto.TerminalDTO;
import com.ftr.terminal.entity.Terminal;
import com.ftr.terminal.exception.CapacityExceededException;
import com.ftr.terminal.exception.ItemTypeNotFoundException;
import com.ftr.terminal.exception.TerminalEmptyException;
import com.ftr.terminal.exception.TerminalNotFoundException;
import com.ftr.terminal.repository.TerminalRepository;

@Service
public class TerminalService {
	
	Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	TerminalRepository terminalRepository;

	public TerminalDTO insertNewTerminal(TerminalDTO terminalDTO)
	{
		logger.info("Service Method : insertNewTerminal");
		Terminal terminal = terminalRepository.save(terminalDTO.convertToEntity());
		return terminal.convertToDTO();
		
	}
	
	public List<TerminalDTO> fetchFTRTerminals() throws TerminalEmptyException
	{
		logger.info("Service Method : fetchFTRTerminals");
		List<Terminal> terminals = terminalRepository.findAll();
		List<TerminalDTO> terminalsDTO = new ArrayList<>();
		for(Terminal t : terminals)
		{
			terminalsDTO.add(t.convertToDTO());
		}
		if(terminalsDTO.isEmpty())
		{
			throw new TerminalEmptyException();
		}
		else
		{
			return terminalsDTO;
		}
		
	}
	
	public TerminalDTO  fetchFTRTerminalByTerminalId(String terminalId) throws TerminalNotFoundException
	{
		logger.info("Service Method : fetchFTRTerminalByTerminalId");
		Optional<Terminal> optionalTerminal = terminalRepository.findById(terminalId);
		if(optionalTerminal.isPresent())
		{
			return optionalTerminal.get().convertToDTO();
		}
		else {
			throw new TerminalNotFoundException(terminalId);
		}
	
	}

	public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws ItemTypeNotFoundException{
		logger.info("Service Method : fetchTerminalsByItemType");
		List<Terminal> terminals = terminalRepository.findByItemType(itemType);
		List<TerminalDTO> terminalsDTO = new ArrayList<>();
		for(Terminal t : terminals)
		{
			terminalsDTO.add(t.convertToDTO());
		}
		if(terminalsDTO.isEmpty())
		{
			throw new ItemTypeNotFoundException();
		}
		else
		{
			return terminalsDTO;
		}
		
	}

	public String removeTerminal(String terminalId) throws TerminalNotFoundException {
		logger.info("Service Method : removeTerminal");
		Optional<Terminal> optionalTerminal = terminalRepository.findById(terminalId);
		if(optionalTerminal.isPresent())
		{
			terminalRepository.deleteById(terminalId);
			return "Terminal details are deleted successfully.";
			
		}
		else
		{
			throw new TerminalNotFoundException(terminalId);
		}
		
	}

	public String updateTerminal(String terminalId, Integer newCapacity) throws CapacityExceededException,TerminalNotFoundException{
		logger.info("Service Method : updateTerminal");
		Optional<Terminal> optionalTerminal = terminalRepository.findById(terminalId);
		if(optionalTerminal.isPresent())
		{
			Terminal terminal = optionalTerminal.get();
			if(terminal.getAvailableCapacity() > newCapacity)
			{
				terminal.setAvailableCapacity(terminal.getAvailableCapacity() - newCapacity);
				terminalRepository.save(terminal);
				return "Terminal capacity is successfully reduced for ID :" + terminalId;
			}
			else if(terminal.getAvailableCapacity() < newCapacity)
			{
				throw new CapacityExceededException();
            }
			else
			{
				terminal.setAvailableCapacity(0);
				terminal.setStatus("UNAVAILABLE");
				terminalRepository.save(terminal);
				return "Terminal capacity is successfully reduced for ID :" + terminalId;
			}
			
		}
		else 
		{
			throw new TerminalNotFoundException(terminalId);
		}
	}

	public String updateTerminalInc(String terminalId, Integer newCapacity) throws TerminalNotFoundException {
		logger.info("Service Method : updateTerminalInc");
		Optional<Terminal> optionalTerminal = terminalRepository.findById(terminalId);
		if(optionalTerminal.isPresent())
		{
			Terminal terminal = optionalTerminal.get();
			terminal.setAvailableCapacity(terminal.getAvailableCapacity() + newCapacity);
			terminal.setStatus("AVAILABLE");
			terminalRepository.save(terminal);
			return "Terminal capacity is successfully increased for ID :" + terminalId;
			
		}
		else {
			throw new TerminalNotFoundException(terminalId);
		}
		
	}
}
