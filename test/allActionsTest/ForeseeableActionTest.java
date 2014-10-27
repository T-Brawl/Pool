package allActionsTest;
import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import actions.ForeseeableAction;

import exceptions.ActionFinishedException;




public class ForeseeableActionTest extends ActionTest {
	
	private static final int NB_STEPS = 2;
	
	protected Action createAction() {
		return new ForeseeableAction(NB_STEPS, "TEST");
	}
	
	@Test
	public void doStepsCorrectly() {
		Action action = this.createAction();
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		for (int i = 1; i < NB_STEPS ; i++) {
			try {action.doStep();}
			catch (ActionFinishedException e){fail("It was not supposed to happen");}
			assertFalse(action.isReady());
			assertTrue(action.isInProgress());
			assertFalse(action.isFinished());
		}
		try {action.doStep();}
		catch (ActionFinishedException e){fail("It was not supposed to happen");}
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
	@Test(expected=IllegalArgumentException.class)
	public void IntegerNegative()  {
		new ForeseeableAction(-5, "TEST");
	}

}
