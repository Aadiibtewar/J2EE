package com.qsp.employee_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.employee_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception) {
		ResponseStructure<String>structure= new ResponseStructure<String>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Id not Found!");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoDataFoundException(NoDataFoundException exception) {
		
		ResponseStructure<String>structure= new ResponseStructure<String>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Data Not Found!");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PhoneNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlePhoneNotFoundException(PhoneNotFoundException exception) {
		
		ResponseStructure<String>structure= new ResponseStructure<String>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("phone Not Found!");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailNotFoundException(NoDataFoundException exception) {
		
		ResponseStructure<String>structure= new ResponseStructure<String>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Data Not Found!");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
