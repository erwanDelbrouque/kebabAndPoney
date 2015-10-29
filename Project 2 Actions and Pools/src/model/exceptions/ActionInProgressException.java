package model.exceptions;

/**
 * This exception is thrown when we try to add an action in a scheduler in progress
 * 
 * @see Exception
 */
public class ActionInProgressException extends Exception {
	
	/**
	 * The serial version UID of this class
	 */
	private static final long serialVersionUID = -6815475722680257916L;

	/**
	 * The default constructor with no message
	 */
	public ActionInProgressException() {
		super();
	}
	
	/**
	 * The constructor with a message to display 
	 * @param message
	 */
	public ActionInProgressException(String message) {
		super(message);
	}
	

}
