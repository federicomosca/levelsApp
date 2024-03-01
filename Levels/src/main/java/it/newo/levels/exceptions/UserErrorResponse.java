package it.newo.levels.exceptions;

import lombok.Data;

@Data
public class UserErrorResponse {
	
	private int status;
	private String message;
	private long timestamp;
}
