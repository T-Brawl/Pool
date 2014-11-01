package resources;
/**
 * <b>BasketPool is a ResourcePool of Basket.</b>
 * <p>
 * The resources kept here are only baskets.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class BasketPool extends ResourcePool<Basket> {

	@Override
	public String toString() {
		return "pool basket";
	}
	/**
	 * 
	 * @param nbResources the number of basket wanted.
	 */
	public BasketPool(int nbResources) {
		super(nbResources);
	}

	@Override
	protected void createPool(int nbResources) {
		for(int i=0; i<nbResources; i++){
			this.resources.add(new Basket());
		}
	}
	public String description()
	{
		return "trying to take resource from " + this.toString() + "... ";
	}

}
