package resources;

public class CubiclePool extends ResourcePool<Cubicle> {

	@Override
	public String toString() {
		return "pool cubicle";
	}

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
