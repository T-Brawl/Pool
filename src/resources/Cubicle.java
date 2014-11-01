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
public class Cubicle implements Resource {

	@Override
	public String toString() {
		return "Cubicle";
	}

	public Cubicle() {
	}

	@Override
	public String description() {
		return "this is a cubicle";
	}

}
