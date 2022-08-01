package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FtrWorkitemTerminal;

@Repository
public interface FtrWorkitemTerminalRepository extends JpaRepository<FtrWorkitemTerminal,String> {

}
