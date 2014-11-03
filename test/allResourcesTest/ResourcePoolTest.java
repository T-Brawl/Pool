package allResourcesTest;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import exceptions.ActionFinishedException;
import resources.Resource;
import resources.ResourcePool;

public abstract class ResourcePoolTest {

	protected ResourcePool<?> resources;
	
	protected abstract ResourcePool<?> createPool(int nbResources);
	
	@Before
	public void setUp(){
		resources = createPool(10);
	}

	@Test
	public void testProvideResourceSuccess() {
		try {
			Resource result = resources.provideResource();
			assertTrue(result!=null);
		} catch (NoSuchElementException e) {
			fail("should never happen");
		}
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testProvideResourceFailure() throws NoSuchElementException {
		while(true){
			resources.provideResource();
		}
	}

	@Test
	public void testFreeResourceSuccess() {
		resources = createPool(10);
		try {
			Resource res = resources.provideResource();
			resources.freeResource(res);
		} catch (NoSuchElementException e) {
			fail("should never happen");
		} catch (ActionFinishedException e) {
			fail("should not happen");
		}
	}

	@Test(expected=ActionFinishedException.class)
	public void testFreeResourceFailure() throws InterruptedException, ActionFinishedException {
		resources = createPool(10);
		Resource res = resources.provideResource();
		resources.freeResource(res);
		resources.freeResource(res);
		
	}

}
