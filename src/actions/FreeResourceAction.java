package actions;

import resources.*;

public class FreeResourceAction extends Action{
	Resource resource;
	ResourcePool<Resource> resourcePool;
	boolean isFree;
	public FreeResourceAction(Resource resource, ResourcePool<Resource> resourcePool) {
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
	protected void doRealStep() {
		// TODO Auto-generated method stub
		try
		{
			resourcePool.freeResource(resource);
			isFree = true;
		}
		catch(Exception e)
		{
			isFree = false;
		}
	}

}
