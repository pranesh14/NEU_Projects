package com.fifa.exception;

public class PlayerException extends Exception
{
	public PlayerException(String message)
	{
		super("PlayerException-"+ message);
	}
	
	public PlayerException(String message, Throwable cause)
	{
		super("PlayerException-"+ message,cause);
	}
}