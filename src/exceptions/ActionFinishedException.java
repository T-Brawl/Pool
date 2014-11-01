package exceptions;
/**
 * <b>ActionFinishedException is an exception.</b>
 * <p>
 * It happens when an action tries to do a step after it has finished.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
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
