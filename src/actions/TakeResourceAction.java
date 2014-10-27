package actions;
import resources.*;
public class TakeResourceAction extends Action {
	private ResourcePool<?> resourcePool;
	private Resource resource;
	private ResourcefulUser<Resource> user;
	public TakeResourceAction(ResourcePool<?> resourcePool, ResourcefulUser<Resource> user) {
		super();
		this.user = user;
		this.resourcePool = resourcePool;
	}
	public ResourcePool<?> getResourcePool() {
		return resourcePool;
	}
	public void setResourcePool(ResourcePool<Resource> resourcePool) {
		this.resourcePool = resourcePool;
	}
	public Resource getResource() {
		
		return this.resource;
	}
	public boolean isFinished() {
		return (getResource() != null);
	}

	@Override
	protected void doRealStep() {
		System.out.print(resourcePool.description());
		try
		{
			this.resource = resourcePool.provideResource();
			user.setResource(resource);
		}
		catch(Exception e)
		{}
	}

}
