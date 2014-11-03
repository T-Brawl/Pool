package allActionsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ActionFinishedException;
import resources.BasketPool;
import resources.CubiclePool;
import actions.Swimmer;

public class SwimmerTest extends SequentialSchedulerTest {
	BasketPool baskets;
	CubiclePool cubicles;
	Swimmer swimmer;
	
	@Before
	public void setUp(){
		baskets = new BasketPool(6);
		cubicles = new CubiclePool(3);
		swimmer = new Swimmer("Mockup", baskets, cubicles, 6, 4, 8);
	}
	
	
	@Test
	public void testReady() {
		assertTrue(swimmer.isReady());
		assertFalse(swimmer.isInProgress());
		assertFalse(swimmer.isFinished());
	}
	@Test
	public void testInProgress() {
		try {
			swimmer.doStep();
		} catch (ActionFinishedException e) {
			fail("should not happen");
		}
		assertFalse(swimmer.isReady());
		assertTrue(swimmer.isInProgress());
		assertFalse(swimmer.isFinished());
	}
	@Test
	public void testFinished() {
		while(!swimmer.isFinished()){
			try {
				swimmer.doStep();
			} catch (ActionFinishedException e) {
				fail("should not happen");
			}
		}
		assertFalse(swimmer.isReady());
		assertFalse(swimmer.isInProgress());
		assertTrue(swimmer.isFinished());
	}
}
