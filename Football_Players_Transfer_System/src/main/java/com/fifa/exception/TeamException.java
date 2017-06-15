package com.fifa.exception;

public class TeamException extends Exception
{
	public TeamException(String message)
	{
		super("TeamException-"+ message);
	}
	
	public TeamException(String message, Throwable cause)
	{
		super("TeamException-"+ message,cause);
	}
}