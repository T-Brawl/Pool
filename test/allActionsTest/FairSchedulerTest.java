/**
 * 
 */
package allActionsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ActionFinishedException;
import actions.FairScheduler;
import actions.ForeseeableAction;
import actions.Scheduler;

public class FairSchedulerTest extends SchedulerTest {
	protected Scheduler createScheduler(){
		return new FairScheduler();
	}


	@Test
	public void testRemoveAction() {
		scheduler = createScheduler();
		assertTrue(scheduler.getActions().isEmpty());
		scheduler.addAction(new ForeseeableAction(1, "mockup"));
		assertFalse(scheduler.getActions().isEmpty());
		while(!scheduler.isFinished()){
			try {
				scheduler.doStep();
			} catch (ActionFinishedException e) {
				fail("should never happen");
			}
		}
		assertTrue(scheduler.getActions().isEmpty());
	}
}
