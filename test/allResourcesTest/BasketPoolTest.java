package allResourcesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.BasketPool;
import resources.ResourcePool;

public class BasketPoolTest extends ResourcePoolTest {

	@Test
	public void testDescription() {
		resources = createPool(10);
		assertEquals("trying to take resource from pool basket... ", resources.description());
	}

	@Override
	protected ResourcePool<?> createPool(int nbResources) {
		return new BasketPool(nbResources);
	}

}
