package com.fifa.exception;

public class BidException  extends Exception
{
	public BidException(String message)
	{
		super("BidException-"+ message);
	}
	
	public BidException(String message, Throwable cause)
	{
		super("BidException-"+ message,cause);
	}
}
