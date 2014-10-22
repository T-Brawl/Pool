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
		getActions().remove(0);
		System.out.println("Suppression "+a);
	}

	@Override
	protected Action nextAction() {
		return super.actions.get(0);
	}

}
