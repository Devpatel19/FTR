package com.ftr.terminal.exception;

public class TerminalNotFoundException extends Exception{
	public TerminalNotFoundException(String id)
	{
		super(id);
	}
}
