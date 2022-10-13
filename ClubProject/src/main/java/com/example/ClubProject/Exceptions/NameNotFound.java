package com.example.ClubProject.Exceptions;

public class NameNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	public NameNotFound() {
		super("Not found");
	}
}
