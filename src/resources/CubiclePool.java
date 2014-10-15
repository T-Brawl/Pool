package resources;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int nbResources) {
		super(nbResources);
	}

	@Override
	protected void createPool(int nbResources) {
		for(int i=0; i<nbResources; i++){
			this.resources.add(new Cubicle());
		}
	}

}
