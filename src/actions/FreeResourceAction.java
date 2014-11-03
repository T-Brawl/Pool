package actions;

import exceptions.ActionFinishedException;
import resources.*;

/**
 * <b>FreeResourceAction in a concrete action.</b>
 * <p>
 * It frees a resource from a ResourcefulUser to get it back in the resourcePool.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class FreeResourceAction extends Action {
	ResourcefulUser<Resource> resource;
	ResourcePool<?> resourcePool;
	
	/**
	 * 
	 * @param resource the ResourcefulUser encapsulating the resource wanted.
	 * @param resourcePool the ResourcePool where the resource is going to be when it's freed.
	 */
	public FreeResourceAction(ResourcefulUser<Resource> resource,
			ResourcePool<?> resourcePool) {
		super();
		this.resourcePool = resourcePool;
		this.resource = resource;
	}

	/**
	 * @return true when the resource is free, false else.
	 */
	@Override
	public boolean isFinished() {
		return (resource==null);
	}
	
	@Override
	public String toString() {
		return "FreeResourceAction [resource=" + resource + ", resourcePool="
				+ resourcePool + ", isFree=" + isFinished() + "]";
	}

	/**
	 * Frees the resource in the ResourcefulUser and get it back in the ResourcePool.
	 */
	@Override
	protected void doRealStep() {
		try {
			resourcePool.freeResource(resource.getResource());
			System.out.println("freeing resource from " + resourcePool.toString());
		} catch (ActionFinishedException e) {
			System.err.println("resource is already free");
		}
		resource=null;
	}

}
