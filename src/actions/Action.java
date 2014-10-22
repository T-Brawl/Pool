package actions;

import exceptions.ActionFinishedException;

public abstract class Action {

	private boolean ready;
	
	public Action() {
		this.ready = true;
	}
	
	
	public boolean isReady() {
		return this.ready;
	}
	
	public boolean isInProgress() {
		return (!this.isReady() && !this.isFinished());
	}
	
	public abstract boolean isFinished();
	
	
	public void doStep() throws ActionFinishedException {
		if(this.isFinished()) throw new ActionFinishedException();
		this.doRealStep();
		this.ready = false;
	}
	
	protected abstract void doRealStep();	
	
	public String toString(){
		return "Action "+ready;
		
	}
	
}
