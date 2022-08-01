package com.ftr.terminal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ftr.terminal.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal,String>{
		
	public List<Terminal> findByItemType(String itemType);
	
	
}
