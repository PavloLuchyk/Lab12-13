package lab12;

public class NoStudentsException extends Exception {
	
	public NoStudentsException() {
		
	}
	
	public NoStudentsException(String message){
		super(message);		
	}
	
	public NoStudentsException(Throwable cause) {
		super(cause);
	}
	
	public NoStudentsException(String message, Throwable cause) {
		super(message, cause);
	}
	

}
