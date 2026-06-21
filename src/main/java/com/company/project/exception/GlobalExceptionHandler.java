package com.company.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.project.dto.ApiErrorResponse;
import com.company.project.dto.user.UserFailureResponse;
import com.company.project.exception.kyc.KycException;
import com.company.project.exception.kyc.UserProfileAlreadyExistException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(KycException.class)
	public ResponseEntity<ApiErrorResponse> handleKycException(KycException ex,HttpServletRequest request){
		ApiErrorResponse response=new ApiErrorResponse();
		response.setStatus("ERROR");
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiErrorResponse> handleGeneric( Exception ex,HttpServletRequest request) {
	        ApiErrorResponse response = new ApiErrorResponse();
	        response.setStatus("ERROR");
	        response.setMessage(ex.getMessage());
	        response.setPath(request.getRequestURI());

	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	 @ExceptionHandler(UserProfileAlreadyExistException.class)
		public ResponseEntity<UserFailureResponse> handleProfileAlreadyExist(Exception ex,HttpServletRequest request){
			UserFailureResponse response=new UserFailureResponse();
			response.setStatus("ERROR");
	        response.setMessage(ex.getMessage());
	        response.setErrorCode("USER_001");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	 
}
