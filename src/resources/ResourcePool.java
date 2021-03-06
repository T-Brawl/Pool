package resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import exceptions.ActionFinishedException;

/**
 * <b>ResourcePool is a pool of resources.</b>
 * <p>
 * The resources are kept here, and are provided or freed here.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public abstract class ResourcePool<T extends Resource> {
	protected List<T> resources;
	protected Set<T> occupiedResources;
	
	/**
	 * 
	 * @param nbResources the number of resources in the pool.
	 */
	public ResourcePool(int nbResources) {
		this.resources = new ArrayList<T>();
		this.occupiedResources = new HashSet<T>();
		this.createPool(nbResources);
	}
	
	/**
	 * 
	 * @return the resource provided
	 * @throws NoSuchElementException when there's no resource left
	 */
	public T provideResource() throws NoSuchElementException{
		if(resources.isEmpty()){
			System.out.println("failed");
			throw new NoSuchElementException("no resource available");
		}
		System.out.println("success");
		T resource = resources.get(0);
		occupiedResources.add(resource);
		resources.remove(resource);
		return resource;
	}
	
	/**
	 * 
	 * @param resource the resource to be freed.
	 * @throws ActionFinishedException when there's nothing to free
	 */
	@SuppressWarnings("unchecked")
	public void freeResource(Resource resource) throws ActionFinishedException{
		if(occupiedResources.contains(resource)){
			resources.add((T) resource);
			occupiedResources.remove(resource);
			
		}else{
			throw new ActionFinishedException("Resource is already free");
		}
	}
	/**
	 * 
	 * @return the description of the ResourcePool
	 */
	public abstract String description();
	
	/**
	 * Actually creates the pool and initialize every resource.
	 * @param nbResources the number of resources needed to create the pool.
	 */
	protected abstract void createPool(int nbResources);


}
