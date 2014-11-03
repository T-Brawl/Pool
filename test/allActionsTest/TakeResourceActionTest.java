package allActionsTest;
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ActionFinishedException;
import resources.BasketPool;
import resources.Resource;
import resources.ResourcefulUser;
import actions.Action;
import actions.TakeResourceAction;


public class TakeResourceActionTest extends ActionTest
{
	
	ResourcefulUser<Resource> resourcefullUser;
	BasketPool baskets;
	
	protected Action createAction()
	{
		baskets = new BasketPool(6);
		resourcefullUser  = new ResourcefulUser<Resource>();

		return new TakeResourceAction(baskets, resourcefullUser);
	}

	@Test
	public void testIsReady() 
	{
		action = createAction();
		assertFalse(action.isFinished());
		assertFalse(action.isInProgress());
		assertTrue(action.isReady());
	}
	
	@Test
	public void testGetResource(){
		action = createAction();
		assertFalse(action.isFinished());
		assertEquals(null, ((TakeResourceAction) action).getResource());
		
	}
	
	@Test
	public void doAStepAndFinish() 
	{
		action = createAction();
		assertFalse(action.isFinished());
		while(!action.isFinished()){
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("should never happen");
			}
		}
		assertTrue(action.isFinished());
	}
}
