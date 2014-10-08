/**
 * 
 */
package actions;

/**
 * @author moevi
 *
 */
public class SequentialScheduler extends Scheduler {

	public SequentialScheduler(){
		super();
	}
	
	@Override
	protected void removeAction(Action a) {
		super.actions.remove(0);
	}

	@Override
	protected Action nextAction() {
		return super.actions.get(0);
	}

}
