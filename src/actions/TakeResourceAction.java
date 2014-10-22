package actions;
import resources.*;
public class TakeResourceAction extends Action {
	private ResourcePool<?> resourcePool;
	private Resource resource;
	public TakeResourceAction(ResourcePool<?> resourcePool) {
		super();
		this.resourcePool = resourcePool;
		// TODO Auto-generated constructor stub
	}
	public ResourcePool<?> getResourcePool() {
		return resourcePool;
	}
	public void setResourcePool(ResourcePool<Resource> resourcePool) {
		this.resourcePool = resourcePool;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return (this.resource != null);
	}

	@Override
	protected void doRealStep() {
		try
		{
			this.resource = resourcePool.provideResource();
		}
		catch(Exception e)
		{
		}
	}

}
