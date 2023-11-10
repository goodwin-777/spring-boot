package com.example.demo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MacbookErrorResponse {

	private long time;
	private int status;
	private String message;
}
