package actions;

import exceptions.ActionFinishedException;
/**
 * <b>Action is an abstract class representing an action to do in a scheduler.</b>
 * <p>
 * It contains the principles of the Action in our implementation of the pool problem.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */

public abstract class Action {

	private boolean ready;
	/**
	 * When the action is created, it is ready to be launched
	 */
	public Action() {
		this.ready = true;
	}
	
	/**
	 * 
	 * @return true if the Action is ready to be launched, false else.
	 */
	public boolean isReady() {
		return this.ready;
	}
	
	/**
	 * 
	 * @return true if the action is not ready nor finished, false else.
	 */
	public boolean isInProgress() {
		return (!this.isReady() && !this.isFinished());
	}
	
	/**
	 * 
	 * @return true if the action is finished, false else.
	 */
	public abstract boolean isFinished();
	
	/**
	 * Do a step.
	 * @throws ActionFinishedException if the action tries to do a step while it is finished.
	 */
	public void doStep() throws ActionFinishedException {
		if(this.isFinished()) throw new ActionFinishedException();
		this.doRealStep();
		this.ready = false;
	}
	
	/**
	 * Launch the real process realized by the action. Used only in doStep() to let multiple implementations happen.
	 */
	protected abstract void doRealStep();	
	
	public String toString(){
		return "";
	}
	
}
