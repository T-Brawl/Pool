package actions;

import resources.*;

public class FreeResourceAction extends Action{
	ResourcefulUser<Resource> resource;
	ResourcePool<?> resourcePool;
	boolean isFree;
	public FreeResourceAction(ResourcefulUser<Resource> resource, ResourcePool<?> resourcePool) {
		super();
		this.resourcePool = resourcePool;
		this.resource = resource;
		this.isFree = false;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return isFree;
	}

	@Override
	public String toString() {
		return "FreeResourceAction [resource=" + resource + ", resourcePool="
				+ resourcePool + ", isFree=" + isFree + "]";
	}

	@Override
	protected void doRealStep() {
		// TODO Auto-generated method stub
		System.out.println("freeing resource from " + resourcePool.toString());
			resourcePool.freeResource(resource.getResource());
			isFree = true;
	}

}
