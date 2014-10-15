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
	
	public T provideResource(){
		if(resources.isEmpty()){
			throw new NoSuchElementException("no resource available");
		}
		T resource = resources.get(0);
		occupiedResources.add(resource);
		resources.remove(resource);
		return resource;
	}
	
	public void freeResource(T resource){
		if(occupiedResources.contains(resource)){
			occupiedResources.remove(resource);
		}else{
			throw new IllegalStateException("Resource is already free");
		}
	}

	protected abstract void createPool(int nbResources);

}
