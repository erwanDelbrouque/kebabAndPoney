package model.exceptions;

/**
* This exception is thrown when we try to execute a finished action
* 
* @see Exception
*/
public class ActionFinishedException extends Exception {

	/**
	 * The serial version UID of this class
	 */
	private static final long serialVersionUID = 4238353180390440533L;

	/**
	 * The default constructor with no message
	 */
	public ActionFinishedException() {
		super();
	}
	
	/**
	 * The constructor with a message to display 
	 * @param message
	 */
	public ActionFinishedException(String message) {
		super(message);
	}
	
	

}
