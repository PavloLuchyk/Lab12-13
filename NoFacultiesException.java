package lab12;

public class NoFacultiesException extends Exception {
	
	public NoFacultiesException() {
		
	}
	
	public NoFacultiesException(String message){
		super(message);		
	}
	
	public NoFacultiesException(Throwable cause) {
		super(cause);
	}
	
	public NoFacultiesException(String message, Throwable cause) {
		super(message, cause);
	}

}
