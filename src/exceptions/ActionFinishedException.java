package exceptions;

public class ActionFinishedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionFinishedException() {super();}
	
	public ActionFinishedException(String message) {
		super(message);
	}
	
}
