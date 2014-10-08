package resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ResourcePool<T extends Resource> {
	List<T> resources;
	Set<T> occupiedResources;
	public ResourcePool(int nbResources) {
		this.resources = new ArrayList<T>();
		this.occupiedResources = new HashSet<T>();
		this.createPool(nbResources);
	}
	
	public T provideResource(){
		if(resources.isEmpty()){
			return null;
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
