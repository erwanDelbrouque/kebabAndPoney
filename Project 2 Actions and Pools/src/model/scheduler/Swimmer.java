package model.scheduler;

import model.actions.DressAction;
import model.actions.FreeBasketAction;
import model.actions.FreeCubicleAction;
import model.actions.TakeBasketAction;
import model.actions.TakeBathAction;
import model.actions.UndressAction;
import model.ressources.Basket;
import model.ressources.BasketPool;
import model.ressources.Cubicle;
import model.ressources.CubiclePool;
import model.ressources.Resource;
import model.ressources.ResourcefulUser;

public class Swimmer extends SequentialScheduler {
	
	protected ResourcefulUser<Basket> bastketUser;
	protected ResourcefulUser<Cubicle> cubiclesUser;
	
	public Swimmer(String name,BasketPool<Basket> baskets ,CubiclePool cubicles,int timeToDress,int timeToBathe, int timeToUndress){
		super(name);
		createActions(baskets,cubicles, timeToDress,timeToBathe,timeToUndress);
	}

	public void createActions(BasketPool<Basket> baskets, CubiclePool cubicles, int timeToDress, int timeToBathe, int timeToUndress) {
		this.addAction(new TakeBasketAction(baskets, bastketUser));
		this.addAction(new FindCubicleAction(cubicles, cubiclesUser));
		this.addAction(new UndressAction(timeToUndress));
		this.addAction(new FreeCubicleAction(cubicles, cubiclesUser));
		this.addAction(new TakeBathAction(timeToBathe));
		this.addAction(new FindCubicleAction(cubicles, cubiclesUser));
		this.addAction(new DressAction(timeToDress));
		this.addAction(new FreeCubicleAction(cubicles, cubiclesUser));
		this.addAction(new FreeBasketAction(baskets, bastketUser));
	}

}
