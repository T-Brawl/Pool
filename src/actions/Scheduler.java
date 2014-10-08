/**
 * 
 */
package actions;

import java.util.ArrayList;
import java.util.List;

import exceptions.ActionFinishedException;

/**
 * @author moevi
 *
 */
public abstract class Scheduler extends Action {
	protected List<Action> actions;
	
	public Scheduler(){
		this.actions = new ArrayList<Action>();
	}
	
	public void add(Action a){
		this.actions.add(a);
	}
	
	@Override
	public boolean isFinished() {
		return this.actions.isEmpty();
	}

	@Override
	protected void doRealStep() {
		Action next;
		next = this.nextAction();
		try{
			next.doStep();
		}catch(ActionFinishedException e){
			throw new IllegalStateException();
		}
		if(next.isFinished()){
			this.removeAction(next);
		}
	}

	protected abstract void removeAction(Action a);
	
	protected abstract Action nextAction();

}
