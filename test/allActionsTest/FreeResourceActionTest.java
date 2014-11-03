package allActionsTest;
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ActionFinishedException;
import resources.BasketPool;
import resources.Resource;
import resources.ResourcefulUser;
import actions.Action;
import actions.FreeResourceAction;
import actions.TakeResourceAction;


public class FreeResourceActionTest extends ActionTest
{
	
	ResourcefulUser<Resource> resourcefullUser;
	TakeResourceAction tra;
	BasketPool baskets;
	
	protected Action createAction()
	{
		baskets = new BasketPool(6);
		resourcefullUser  = new ResourcefulUser<Resource>();

		tra = new TakeResourceAction(baskets, resourcefullUser);
		try {
			tra.doStep();
		} catch (ActionFinishedException e) {
			e.printStackTrace();
		}
		return new FreeResourceAction(resourcefullUser, baskets);
	}

	@Test
	public void notFinished() 
	{
		action = (FreeResourceAction) createAction();
		assertFalse(action.isFinished());
	}
	
	@Test
	public void finished() 
	{
		action = (FreeResourceAction) createAction();
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
