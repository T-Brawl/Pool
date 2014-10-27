package actions;

import java.util.Iterator;
import java.util.List;


public class FairScheduler extends Scheduler {

	private Iterator<Action> it;
	public FairScheduler() {
		super();
		this.it = actions.iterator();
	}

	@Override
	protected void removeAction() {
		it.remove();
	}
	
	@Override
	protected Action nextAction() {
		if(! it.hasNext())
		{
			this.it = actions.iterator();
		}
		return it.next();
	}

	public void addAction(Action a) {
		actions.add(a);
		this.it = actions.iterator();
	}

	public List<Action> getActions() {
		return actions;
	}
	
}
