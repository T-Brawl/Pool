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
		/*it = super.actions.iterator();
		if(it.hasNext()){
			return it.next();
		}
		else(§it.hasNext()){
			throw new IllegalStateException("Liste vide");
		}
		return it.next();*/
		if(!super.actions.isEmpty())
				return super.actions.get(0);
		throw new IllegalStateException("Liste vide");
	}
	
}
