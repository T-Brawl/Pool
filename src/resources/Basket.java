package resources;

/**
 * <b>Basket is an implementation of Resource, it represents a resource to be basket.</b>
 * <p>
 * It only has a description.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class Basket implements Resource{

	@Override
	public String toString() {
		return "Basket";
	}

	public Basket() {
	}

	@Override
	public String description() {
		return "this is a basket";
	}

}
