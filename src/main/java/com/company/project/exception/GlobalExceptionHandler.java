package com.company.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.project.dto.ApiErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // User Not Found Exception
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFound(
            UserNotFoundException ex,
            HttpServletRequest request) {

        return buildResponse(
                ex.getMessage(),
                "USER_404",
                HttpStatus.NOT_FOUND,
                request);
    }

    // KYC Exception
    @ExceptionHandler(KycException.class)
    public ResponseEntity<ApiErrorResponse> handleKycException(
            KycException ex,
            HttpServletRequest request) {

        return buildResponse(
                ex.getMessage(),
                "KYC_001",
                HttpStatus.BAD_REQUEST,
                request);
    }

    // User Profile Already Exists
    @ExceptionHandler(UserProfileAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleProfileAlreadyExist(
            UserProfileAlreadyExistException ex,
            HttpServletRequest request) {

        return buildResponse(
                ex.getMessage(),
                "USER_001",
                HttpStatus.BAD_REQUEST,
                request);
    }

    // Invalid Request
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(
            IllegalArgumentException ex,
            HttpServletRequest request) {

        return buildResponse(
                ex.getMessage(),
                "REQ_001",
                HttpStatus.BAD_REQUEST,
                request);
    }

    // Generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        ex.printStackTrace();

        return buildResponse(
                ex.getMessage(),
                "GEN_500",
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }

    // Common Method
    private ResponseEntity<ApiErrorResponse> buildResponse(
            String message,
            String errorCode,
            HttpStatus status,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse();
        response.setStatus("ERROR");
        response.setMessage(message);
        response.setErrorCode(errorCode);
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, status);
    }
}