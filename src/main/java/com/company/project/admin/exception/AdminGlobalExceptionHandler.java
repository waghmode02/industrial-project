package com.company.project.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.project.admin.exception.UserNotFoundException;
import com.company.project.dto.ApiErrorResponse;
import com.company.project.exception.kyc.KycException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AdminGlobalExceptionHandler {

    @ExceptionHandler(KycException.class)
    public ResponseEntity<ApiErrorResponse> handleKycException(
            KycException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse();
        response.setStatus("ERROR");
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFoundException(
            UserNotFoundException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse();
        response.setStatus("Failed");
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse();
        response.setStatus("Failed");
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}