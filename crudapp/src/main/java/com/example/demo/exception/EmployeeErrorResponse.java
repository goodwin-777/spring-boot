package com.example.demo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeErrorResponse {

	private long time;
	private int status;
	private String message;
}
