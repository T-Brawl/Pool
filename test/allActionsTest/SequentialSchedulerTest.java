package allActionsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import actions.ForeseeableAction;
import actions.Scheduler;
import actions.SequentialScheduler;
import exceptions.ActionFinishedException;

public class SequentialSchedulerTest extends SchedulerTest {
	protected Scheduler createScheduler(){
		return new SequentialScheduler();
	}
	@Before
	public void setUp() throws Exception {
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
