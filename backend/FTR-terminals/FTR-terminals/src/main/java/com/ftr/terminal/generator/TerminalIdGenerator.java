package com.ftr.terminal.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TerminalIdGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "T";
	    Connection connection = session.connection();
	    try {
	        Statement statement=connection.createStatement();
	        ResultSet rs=statement.executeQuery("select MAX(CAST(SUBSTRING(terminal_id FROM 2) AS UNSIGNED)) from ftr_terminals");
	        if(rs.next())
	        {
	            Integer id = rs.getInt(1)+ 1;
	            String generatedId = prefix + id.toString();
	            return generatedId;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
