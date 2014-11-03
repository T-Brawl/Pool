package allResourcesTest;

import org.junit.Before;

import resources.Resource;


public abstract class ResourceTest {
	protected Resource resource;
	@Before
	public void setUp(){
		resource = createResource();
	}
	public abstract Resource createResource();
	public abstract void testDescription();
}
