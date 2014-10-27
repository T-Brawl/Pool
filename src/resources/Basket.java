package resources;

public class Basket implements Resource{

	@Override
	public String toString() {
		return "Basket";
	}

	public Basket() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String description() {
		return "this is a basket";
	}

}
