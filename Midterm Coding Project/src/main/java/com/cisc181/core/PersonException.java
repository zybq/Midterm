package com.cisc181.core;

public class PersonException extends Exception {
	Person student1;

	   public PersonException(Person student1, String message) {
		super(message);
		this.student1 = student1;
	}

}
