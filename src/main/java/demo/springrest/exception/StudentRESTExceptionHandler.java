package demo.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRESTExceptionHandler {
	
	// Add exception handling code
	
	// Add an exception Handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
				
		// Create a new StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		//return ResponseEntity
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND); // (body, Status Code)
	}
			
	// Add another exception Handler.. to catch any type of exception that is thrown (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
				
		// Create a new StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
				
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		// error.setMessage(e.getMessage()); // Default Message of Java
		error.setMessage("Do not enter anything unrelated"); // Custom MEssage that will be displayed
		error.setTimeStamp(System.currentTimeMillis());
						
		//return ResponseEntity
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST); // (body, Status Code)
	}
}
