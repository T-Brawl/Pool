package actions;



public class ForeseeableAction extends Action {

	private int steps_begin;
	private int steps_actual;
	private String name;
	public ForeseeableAction(int steps, String name) {
		super();
		if (steps <= 0) throw new IllegalArgumentException("Integer must be positive");
		this.steps_begin = steps;
		this.name = name;
	}
	
	public boolean isFinished() {
		return (this.steps_begin == steps_actual);
	}

	protected void doRealStep() {
		this.steps_actual ++;
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return name + " (" + steps_actual+"/"+steps_begin + ")";
	}
}
