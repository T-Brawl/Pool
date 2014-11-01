package resources;

/**
 * <b>ResourcefulUser is a resource holder while it is being used.</b>
 * <p>
 * It contains the resource.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class ResourcefulUser<R extends Resource> {

	protected R resource;
	
	/**
	 * 
	 * @return the resource
	 */
	public R getResource() {
		return resource;
	}
	
	/**
	 * 
	 * @param resource the new resource
	 */
	public void setResource(R resource){
		this.resource = resource;
	}
	
	/**
	 * resets the resource, usually when it is freed.
	 */
	public void resetResource() {
		this.resource = null;
	}

	@Override
	public String toString() {
		return "";
	}

}
