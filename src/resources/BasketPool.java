package resources;

public class BasketPool extends ResourcePool<Basket> {

	@Override
	public String toString() {
		return "pool basket";
	}

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
