package actions;

/**
 * <b>SequentialScheduler is a concrete implementation of Scheduler.</b>
 * <p>
 * It executes all the steps in the first action of the list, then removes it to do it again. That's why it is called sequential.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class SequentialScheduler extends Scheduler {

	public SequentialScheduler(){
		super();
	}
	
	/**
	 * Removes the first action in the list.
	 */
	protected void removeAction() {
		getActions().remove(0);
	}

	/**
	 * Selects the first actions in the list.
	 */
	@Override
	protected Action nextAction() {
		return super.actions.get(0);
	}
}
