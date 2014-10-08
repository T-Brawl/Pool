package actions;



public class ForeseeableAction extends Action {

	private int steps;
	
	public ForeseeableAction(int steps) {
		super();
		if (steps <= 0) throw new IllegalArgumentException("Integer must be positive");
		this.steps = steps;
	}
	
	public boolean isFinished() {
		return (this.steps == 0);
	}

	protected void doRealStep() {
		this.steps--;		
	}

}
