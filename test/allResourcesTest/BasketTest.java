package allResourcesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.Basket;
import resources.Resource;

public class BasketTest extends ResourceTest {

	
	@Override
	public Resource createResource() {
		return new Basket();
	}
	
	@Test
	public void testDescription() {
		assertEquals("this is a basket", resource.description());
	}

}
