package model.scheduler;

import model.actions.TakeBasketAction;
import model.ressources.BasketPool;
import model.ressources.CubiclePool;
import model.ressources.Resource;
import model.ressources.ResourcefulUser;

public class Swimmer extends SequentialScheduler {
	
	protected ResourcefulUser<Resource> user;
	
	public Swimmer(String name,BasketPool baskets ,CubiclePool cubicles,int timeToDress,int timeToBathe, int timeToUndress){
		super(name);
		createActions(baskets,cubicles, timeToDress,timeToBathe,timeToUndress);
	}

	public void createActions(BasketPool baskets, CubiclePool cubicles, int timeToDress, int timeToBathe, int timeToUndress) {
		this.addAction(new TakeBasketAction(baskets, user));
		this.addAction(new FindCubicleAction(cubicles, user));
		this.addAction(new UndressAction(timeToUndress));
		this.addAction(new FreeCubicle(cubicles, user));
		this.addAction(new TakeBathAction(timeToBathe));
		this.addAction(new FindCubicleAction(cubicles, user));
		this.addAction(new DressAction(timeToDress));
		this.addAction(new FreeCubicle(cubicles, user));
		this.addAction(new FreeBasketAction(baskets, user));
	}

}
