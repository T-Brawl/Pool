package actions;

import java.util.Iterator;
import java.util.List;

/**
 * <b>FairScheduler is a concrete implementation of Scheduler.</b>
 * <p>
 * It executes all actions, one step of each action is done in a scheduler step.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class FairScheduler extends Scheduler {

	private Iterator<Action> it;
	public FairScheduler() {
		super();
		this.it = actions.iterator();
	}

	/**
	 * Remove the current action
	 */
	@Override
	protected void removeAction() {
		it.remove();
	}
	
	/**
	 * Selects the next action in the list, as it do one action of each step in its own step.
	 */
	@Override
	protected Action nextAction() {
		if(! it.hasNext())
		{
			this.it = actions.iterator();
		}
		return it.next();
	}

	/**
	 * Adds an action. Should not be used after the scheduler's start.
	 */
	public void addAction(Action a) {
		actions.add(a);
		this.it = actions.iterator();
	}

	/**
	 * @return the list of actions in the scheduler
	 */
	public List<Action> getActions() {
		return actions;
	}
	
}
