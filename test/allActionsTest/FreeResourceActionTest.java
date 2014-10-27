package allActionsTest;
import static org.junit.Assert.*;

import org.junit.Test;

import resources.BasketPool;
import resources.Resource;
import resources.ResourcefulUser;
import actions.Action;
import actions.FreeResourceAction;
import actions.TakeResourceAction;


public abstract class FreeResourceActionTest extends ActionTest
{
	
	ResourcefulUser<Resource> resourcefullUser;
	TakeResourceAction tra;
	BasketPool baskets;
	
	protected Action createAction()
	{
		baskets = new BasketPool(6);
		resourcefullUser  = new ResourcefulUser<Resource>();

		tra = new TakeResourceAction(baskets, resourcefullUser);
		return new FreeResourceAction(resourcefullUser, baskets);
	}
	@Test
	public void testRemoveAction() {
	//	fail("Not yet implemented");
	}
	@Test
	public void notFinished() 
	{
		FreeResourceAction fr = (FreeResourceAction) createAction();
		assertFalse(fr.isFinished());
	}
	@Test
	public void finished() 
	{
		FreeResourceAction fr = (FreeResourceAction) createAction();
		try
		{
			tra.doStep();
			fr.doStep();
		}
		catch(Exception e)
		{}
		assertFalse(fr.isFinished());
	}
}
