package actions;
import resources.*;
/**
 * <b>TakeResourceAction in a concrete action.</b>
 * <p>
 * It takes a resource from a ResourcePool to get it in the ResourcefulUser .
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class TakeResourceAction extends Action {
	private ResourcePool<?> resourcePool;
	private Resource resource;
	private ResourcefulUser<Resource> user;
	
	/**
	 * @param resourcePool the ResourcePool where the resource is at the beginning.
	 * @param resource the ResourcefulUser encapsulating the resource when it's taken.
	 */
	public TakeResourceAction(ResourcePool<?> resourcePool, ResourcefulUser<Resource> user) {
		super();
		this.user = user;
		this.resourcePool = resourcePool;
	}
	
	
	/**
	 * 
	 * @return the ResourcePool
	 */
	public ResourcePool<?> getResourcePool() {
		return resourcePool;
	}
	
	/**
	 * 
	 * @param resourcePool the new ResourcePool
	 */
	public void setResourcePool(ResourcePool<Resource> resourcePool) {
		this.resourcePool = resourcePool;
	}
	
	/**
	 * 
	 * @return the used resource
	 */
	public Resource getResource() {
		
		return this.resource;
	}
	/**
	 * @return true if the resource is in the ResourcefulUser, false else.
	 */
	public boolean isFinished() {
		return (getResource() != null);
	}

	/**
	 * Takes the resource in the ResourcePool and get it in the ResourcefulUser.
	 */
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
