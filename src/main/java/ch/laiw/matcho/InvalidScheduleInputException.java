package ch.laiw.matcho;

public class InvalidScheduleInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5266359254453035007L;

	public InvalidScheduleInputException() {
		super();
	}
	
	public InvalidScheduleInputException(String message) {
		super(message);
	}
	
	public InvalidScheduleInputException(Throwable cause) {
		super(cause);
	}
	
	public InvalidScheduleInputException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
