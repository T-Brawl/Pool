package actions;
import resources.BasketPool;
import resources.CubiclePool;

public class Swimmer extends SequentialScheduler{

	private String name;
	
	private BasketPool basket;
	
	private CubiclePool cubicle;
	
	private int timeUndressed, timeSwim, timeDressed;
	
	public Swimmer(String name, BasketPool basket, CubiclePool cubicle, int timeUndressed, int timeSwim, int timeDressed) {
		super();
		this.name = name;
		this.basket = basket;
		this.cubicle = cubicle;
		this.timeUndressed = timeUndressed;
		this.timeSwim = timeSwim;
		this.timeDressed = timeDressed;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void doRealStep() {
		// TODO Auto-generated method stub
		
	}
	
}
