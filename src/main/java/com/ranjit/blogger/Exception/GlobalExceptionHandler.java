package com.ranjit.blogger.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ranjit.blogger.dto.ApiResponse;
import com.ranjit.blogger.Exception.*;
 

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ApiResponse> resourseNotFoundException(CategoryNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse> (response,HttpStatus.NOT_FOUND);
	}
}
