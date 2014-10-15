package resources;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int nbResources) {
		super(nbResources);
	}

	@Override
	protected void createPool(int nbResources) {
		for(int i=0; i<nbResources; i++){
			this.resources.add(new Basket());
		}
	}

}
