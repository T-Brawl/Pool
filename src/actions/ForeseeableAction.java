package actions;

/**
 * <b>ForeseeableAction is a simple implementation of Action.</b>
 * <p>
 * It is an Action which is characterized by the fact that there's a known number of steps to do.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */


public class ForeseeableAction extends Action {

	private int steps_begin;
	private int steps_actual;
	private String name;
	/**
	 * 
	 * @param steps the number of steps needed to finish the action
	 * @param name the name of the action
	 */
	public ForeseeableAction(int steps, String name) {
		super();
		if (steps <= 0) throw new IllegalArgumentException("Integer must be positive");
		this.steps_begin = steps;
		this.steps_actual = 0;
		this.name = name;
	}
	
	/**
	 * @return true if the action has done enough steps, false else.
	 */
	public boolean isFinished() {
		return (this.steps_begin == steps_actual);
	}

	/**
	 * increments the number of steps done.
	 */
	protected void doRealStep() {
		this.steps_actual ++;
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return name + " (" + steps_actual+"/"+steps_begin + ")";
	}
}
