package com.Service.Goals.Users.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserEmptyNullException extends RuntimeException{


	public UserEmptyNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
