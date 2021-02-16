package lab12;

public class StudentAlreadyInListException extends Exception {
	public StudentAlreadyInListException() {
		
	}
	
	public StudentAlreadyInListException(String message){
		super(message);		
	}
	
	public StudentAlreadyInListException(Throwable cause) {
		super(cause);
	}
	
	public StudentAlreadyInListException(String message, Throwable cause) {
		super(message, cause);
	}
}
