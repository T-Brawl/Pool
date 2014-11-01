package resources;
/**
 * <b>CubiclePool is a ResourcePool of Cubicle.</b>
 * <p>
 * The resources kept here are only cubicles.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	@Override
	public String toString() {
		return "pool cubicle";
	}
	
	/**
	 * 
	 * @param nbResources the number of cubicle wanted.
	 */
	public CubiclePool(int nbResources) {
		super(nbResources);
	}

	@Override
	protected void createPool(int nbResources) {
		for(int i=0; i<nbResources; i++){
			this.resources.add(new Cubicle());
		}
	}
	
	public String description()
	{
		return "trying to take resource from "+this.toString()+"... ";
	}
}
