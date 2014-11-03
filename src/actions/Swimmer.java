package actions;

import resources.*;
/**
 * <b>Swimmer is a extension of SequentialScheduler.</b>
 * <p>
 * It represent the process of a person going to the pool, therefore it needs to use resources and to several steps.
 * </p>
 * 
 * 
 * @author Marine Bal & Alexandre Moevi & Theo Plockyn
 */
public class Swimmer extends SequentialScheduler{

	private String name;
	private BasketPool basket;
	private CubiclePool cubicle;
	private int timeUndressed, timeSwim, timeDressed;
	private ResourcefulUser<Resource> resourcefullUserBasket;
	private ResourcefulUser<Resource> resourcefullUserCubicle;

	/**
	 * 
	 * @param name the name of the swimmer
	 * @param basket the pool of resources where the swimmer takes its basket
	 * @param cubicle the pool of resources where the swimmer takes its cubicle
	 * @param timeUndressed the time the swimmer takes to get undressed
	 * @param timeSwim the time the swimmer actually swim
	 * @param timeDressed the time the swimmer takes to get dressed
	 */
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
	
	/**
	 * 
	 * @return the name of the swimmer
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name the new name of the swimmer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the basket pool
	 */
	public BasketPool getBasket() {
		return basket;
	}

	/**
	 * 
	 * @param basket the new basket pool
	 */
	public void setBasket(BasketPool basket) {
		this.basket = basket;
	}

	/**
	 * 
	 * @return the cubicle pool
	 */
	public CubiclePool getCubicle() {
		return cubicle;
	}

	/**
	 * 
	 * @param cubicle the new cubicle pool
	 */
	public void setCubicle(CubiclePool cubicle) {
		this.cubicle = cubicle;
	}

	/**
	 * 
	 * @return the time the swimmer takes to get undressed.
	 */
	public int getTimeUndressed() {
		return timeUndressed;
	}


	/**
	 * 
	 * @param timeUndressed the new time the swimmer takes to get undressed.
	 */
	public void setTimeUndressed(int timeUndressed) {
		this.timeUndressed = timeUndressed;
	}


	/**
	 * 
	 * @return the time the swimmer takes to swim.
	 */
	public int getTimeSwim() {
		return timeSwim;
	}

	/**
	 * 
	 * @param timeSwim the new time the swimmer swims.
	 */
	public void setTimeSwim(int timeSwim) {
		this.timeSwim = timeSwim;
	}

	/**
	 * 
	 * @return the time the swimmer takes to get dressed.
	 */
	public int getTimeDressed() {
		return timeDressed;
	}

	/**
	 * 
	 * @param timeDressed the new time the swimmer takes to get dressed.
	 */
	public void setTimeDressed(int timeDressed) {
		this.timeDressed = timeDressed;
	}
	
	@Override
	public String toString() {
		return name +"'s turn\n" + name + " ";
	}
	
	/*
	 	// the old position of the main method 
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

*/
	
	
}
