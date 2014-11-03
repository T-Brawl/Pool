package allActionsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ActionFinishedException;
import actions.Action;
import actions.ForeseeableAction;
import actions.Scheduler;

public abstract class SchedulerTest {
	
	/**
	 * Creates an empty scheduler
	 * @return an empty scheduler
	 */
	protected abstract Scheduler createScheduler();
	
	protected Scheduler scheduler;
	

	@Test
	public void testAdd() {
		scheduler = createScheduler();
		scheduler.addAction(new ForeseeableAction(1, "test"));
		assertFalse(scheduler.getActions().isEmpty());
		assertEquals(1, scheduler.getActions().size());
		
	}
	
	@Test
	public void testIsFinished() {
		scheduler = createScheduler();
		scheduler.addAction(new ForeseeableAction(10, "test"));
		assertFalse(scheduler.isFinished());
		while(!scheduler.isFinished()){
			try {
				scheduler.doStep();
			} catch (ActionFinishedException e) {
			}
		}
		assertTrue(scheduler.isFinished());
	}

	@Test
	public void testDoRealStep() {
		scheduler = createScheduler();
		scheduler.addAction(new ForeseeableAction(10, "test"));
		assertTrue(scheduler.isReady());
		try {
			scheduler.doStep();
		} catch (ActionFinishedException e) {
			fail("Should not happen");
		}
		assertFalse(scheduler.isReady());
		assertTrue(scheduler.isInProgress());
	}
	
	@Test
	public void testGetActions() {
		scheduler = createScheduler();
		Action mock1 = new ForeseeableAction(10, "test");
		Action mock2 = new ForeseeableAction(10, "test2");

		scheduler.addAction(mock1);
		scheduler.addAction(mock2);

		assertEquals(mock1, scheduler.getActions().get(0));
		assertEquals(mock2, scheduler.getActions().get(1));
		
	}


}
