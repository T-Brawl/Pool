package allResourcesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.CubiclePool;
import resources.ResourcePool;

public class CubiclePoolTest extends ResourcePoolTest {

	@Test
	public void testDescription() {
		resources = createPool(10);
		assertEquals("trying to take resource from pool cubicle... ", resources.description());
	}

	@Override
	protected ResourcePool<?> createPool(int nbResources) {
		return new CubiclePool(nbResources);
	}

}
