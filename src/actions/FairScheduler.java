package actions;

import java.util.Iterator;

public class FairScheduler extends Scheduler {

	Iterator<Action> it;
	
	public FairScheduler() {
		super();
		it = super.actions.iterator();
	}

	@Override
	protected void removeAction(Action a) {
		super.actions.remove(a);
	}

	@Override
	protected Action nextAction() {
		if(it.hasNext()){
			return it.next();
		}
		it = super.actions.iterator();
		if(!it.hasNext()){
			throw new IllegalStateException("Liste vide");
		}
		return it.next();
	}
	
}
