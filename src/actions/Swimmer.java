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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BasketPool getBasket() {
		return basket;
	}

	public void setBasket(BasketPool basket) {
		this.basket = basket;
	}

	public CubiclePool getCubicle() {
		return cubicle;
	}

	public void setCubicle(CubiclePool cubicle) {
		this.cubicle = cubicle;
	}

	public int getTimeUndressed() {
		return timeUndressed;
	}

	public void setTimeUndressed(int timeUndressed) {
		this.timeUndressed = timeUndressed;
	}

	public int getTimeSwim() {
		return timeSwim;
	}

	public void setTimeSwim(int timeSwim) {
		this.timeSwim = timeSwim;
	}

	public int getTimeDressed() {
		return timeDressed;
	}

	public void setTimeDressed(int timeDressed) {
		this.timeDressed = timeDressed;
	}
}
