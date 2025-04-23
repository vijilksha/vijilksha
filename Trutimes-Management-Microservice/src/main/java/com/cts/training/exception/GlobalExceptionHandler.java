package com.cts.training.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;
/**
 * This is the Global Exception Handler Used to handle All the other Exception
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This is the override method for Message Not Readable
	 */
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new ApiErrorResponse(status, "Malformed JSON request", ex), status);
	}
	/**
	 * For Handling CustomerTrutimeNotFoundException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(CustomerTrutimeNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleCustomerTrutimeNotFoundException(CustomerTrutimeNotFoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * For Handling TrutimeNotFoundException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(TrutimeNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleTrutimeNotFoundException(TrutimeNotFoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * For Handling CollateralTypeNotFoundException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(CollateralTypeNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleCollateralTypeNotFoundException(CollateralTypeNotFoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * For handling FeignException
	 * @param ex
	 * @param response
	 * @return
	 */
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ApiErrorResponse> handleFeignStatusException(FeignException ex,
			HttpServletResponse response) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}