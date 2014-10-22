package actions;
import resources.*;
import actions.*;

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
		TakeResourceAction traBasket = new TakeResourceAction(basket);
		TakeResourceAction traCubicle = new TakeResourceAction(cubicle);
		actions.add(traBasket);
		actions.add(traCubicle);
		actions.add(new ForeseeableAction(timeUndressed));
		actions.add(new FreeResourceAction(traCubicle.getResource(), cubicle));
		actions.add(new ForeseeableAction(timeSwim));
		traCubicle = new TakeResourceAction(cubicle);
		actions.add(traCubicle);
		actions.add(new ForeseeableAction(timeDressed));
		actions.add(new FreeResourceAction(traCubicle.getResource(), cubicle));
		actions.add(new FreeResourceAction(traBasket.getResource(), basket));
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
