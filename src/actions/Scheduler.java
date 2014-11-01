package actions;

import java.util.ArrayList;
import java.util.List;

import exceptions.ActionFinishedException;

/**
 * <b>Scheduler is an abstract class representing a scheduler, which is a list of actions to be done in a to-be-determined order.</b>
 * <p>
 * It contains the principles of the Scheduler in our implementation of the pool problem.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public abstract class Scheduler extends Action {
	protected List<Action> actions;
	
	/**
	 * Creates an empty list of actions
	 */
	public Scheduler(){
		this.actions = new ArrayList<Action>();
	}
	
	/**
	 * Adds an action to the list of actions to do
	 * @param a the action to be added
	 */
	public void addAction(Action a){
		this.actions.add(a);
	}
	
	/**
	 * Checks if the list of actions is empty
	 * @return true if there's no action to do, false else.
	 */
	@Override
	public boolean isFinished() {
		return this.actions.isEmpty();
	}
	
	/**
	 * Does a step on the next action in the scheduler's order.
	 */
	@Override
	protected void doRealStep() {
		Action next;
		try{
			System.out.print(this.toString());
			next = this.nextAction();
			next.doStep();
			if(next.isFinished()){
				this.removeAction();
			}
		}catch(ActionFinishedException e){
			throw new IllegalStateException(e);
		}
	}
	
	/**
	 * 
	 * @return <b>actions</b> the list of actions to do
	 */
	public List<Action> getActions(){
		return this.actions;
	}
	
	/**
	 * remove an action, the "how" is to be determined in a concrete implementation.
	 */
	protected abstract void removeAction();
	
	/**
	 * 
	 * @return the next action which a step will be done.
	 */
	protected abstract Action nextAction();




}
