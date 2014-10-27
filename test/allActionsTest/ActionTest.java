package allActionsTest;
import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import exceptions.ActionFinishedException;


public abstract class ActionTest {
	
	protected abstract Action createAction();

	@Test(expected = ActionFinishedException.class)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException {
		Action action = createAction();
		while(!action.isFinished()) {
			try {action.doStep();}
			catch (ActionFinishedException e) {fail("It was not supposed to happen");}
		}
		
		assertTrue(action.isFinished());
		action.doStep();
	}
	
	@Test
	public void oneStepAtTheTime() {
		Action action = createAction();
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		while(!action.isFinished()) {
			try {action.doStep();}
			catch (ActionFinishedException e) {fail("It was not supposed to happen");}
			assertFalse(action.isReady());
			assertTrue(action.isInProgress() != action.isFinished());
		}
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}


}
