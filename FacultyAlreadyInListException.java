package lab12;

public class FacultyAlreadyInListException extends Exception {
	public FacultyAlreadyInListException() {
		
	}
	
	public FacultyAlreadyInListException(String message){
		super(message);		
	}
	
	public FacultyAlreadyInListException(Throwable cause) {
		super(cause);
	}
	
	public FacultyAlreadyInListException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
