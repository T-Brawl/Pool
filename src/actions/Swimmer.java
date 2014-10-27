package actions;

import exceptions.ActionFinishedException;
import resources.*;

public class Swimmer extends SequentialScheduler{

	private String name;
	private BasketPool basket;
	private CubiclePool cubicle;
	private int timeUndressed, timeSwim, timeDressed;
	private ResourcefulUser<Resource> resourcefullUserBasket;
	private ResourcefulUser<Resource> resourcefullUserCubicle;

	public Swimmer(String name, BasketPool basket, CubiclePool cubicle, int timeUndressed, int timeSwim, int timeDressed) {
		super();
		resourcefullUserBasket  = new ResourcefulUser<Resource>();
		resourcefullUserCubicle= new ResourcefulUser<Resource>();

		this.name = name;
		this.basket = basket;
		this.cubicle = cubicle;
		this.timeUndressed = timeUndressed;
		this.timeSwim = timeSwim;
		this.timeDressed = timeDressed;
		TakeResourceAction traBasket = new TakeResourceAction(basket, resourcefullUserBasket);
		TakeResourceAction traCubicle = new TakeResourceAction(cubicle, resourcefullUserCubicle);
		actions.add(traBasket);
		actions.add(traCubicle);
		actions.add(new ForeseeableAction(timeUndressed, "undressing"));
		actions.add(new FreeResourceAction(resourcefullUserCubicle, cubicle));
		actions.add(new ForeseeableAction(timeSwim, "swimming"));
		traCubicle = new TakeResourceAction(cubicle, resourcefullUserCubicle);
		actions.add(traCubicle);
		actions.add(new ForeseeableAction(timeDressed,"dressing"));
		actions.add(new FreeResourceAction(resourcefullUserCubicle, cubicle));
		actions.add(new FreeResourceAction(resourcefullUserBasket, basket));
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
	@Override
	public String toString() {
		return name +"'s turn\n" + name + " ";
	}
	
	public static void main(String[] args){
		
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		
		s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		s.addAction(new Swimmer("Lois", baskets, cubicles, 2, 10, 4));

		int turn = 0;
		try {
			while(! s.isFinished())
			{
				s.doStep();
				turn ++;
			}
		} catch (ActionFinishedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished in "+turn+ " steps");
	}


	
	
}
