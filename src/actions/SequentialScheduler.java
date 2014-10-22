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
	
	protected void removeAction() {
		getActions().remove(0);
		System.out.println("Suppression ");
	}

	@Override
	protected Action nextAction() {
		return super.actions.get(0);
	}

}
