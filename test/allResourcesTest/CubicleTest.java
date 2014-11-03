package allResourcesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.Cubicle;
import resources.Resource;

public class CubicleTest extends ResourceTest {

	
	@Override
	public Resource createResource() {
		return new Cubicle();
	}
	
	@Test
	public void testDescription() {
		assertEquals("this is a cubicle", resource.description());
	}

}
