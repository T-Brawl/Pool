package resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class ResourcePool<T extends Resource> {
	protected List<T> resources;
	protected Set<T> occupiedResources;
	
	public ResourcePool(int nbResources) {
		this.resources = new ArrayList<T>();
		this.occupiedResources = new HashSet<T>();
		this.createPool(nbResources);
	}
	
	public T provideResource() throws InterruptedException{
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
	
	@SuppressWarnings("unchecked")
	public void freeResource(Resource resource){
		if(occupiedResources.contains(resource)){
			resources.add((T) resource);
			occupiedResources.remove(resource);
			
		}else{
			throw new IllegalStateException("Resource is already free");
		}
	}
	public abstract String description();
	protected abstract void createPool(int nbResources);


}
