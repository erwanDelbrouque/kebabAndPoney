package model.scheduler;

import model.actions.DressAction;
import model.actions.ActionFinishedException;
import model.actions.DressAction;
import model.actions.FindCubicleAction;
import model.actions.FreeBasketAction;
import model.actions.FreeCubicleAction;
import model.actions.TakeBasketAction;
import model.actions.TakeBathAction;
import model.actions.UndressAction;
import model.actions.TakeBathAction;
import model.actions.UndressAction;
import model.ressources.Basket;
import model.ressources.BasketPool;
import model.ressources.Cubicle;
import model.ressources.CubiclePool;
import model.ressources.ResourcefulUser;

public class Swimmer extends SequentialScheduler {
	
	protected ResourcefulUser<Basket> basketUser;
	protected ResourcefulUser<Cubicle> cubiclesUser;
	
	public Swimmer(String name,BasketPool baskets , CubiclePool cubicles,int timeToDress,int timeToBathe, int timeToUndress) throws ActionFinishedException{
		super(name);
		basketUser = new ResourcefulUser<Basket>(this.name);
		cubiclesUser = new ResourcefulUser<Cubicle>(this.name);
		
		createActions(baskets,cubicles, timeToDress,timeToBathe,timeToUndress);
	}

	public void createActions(BasketPool baskets, CubiclePool cubicles, int timeToUndress, int timeToBathe, int timeToDress) throws ActionFinishedException {
		this.addAction(new TakeBasketAction(baskets, basketUser));
		this.addAction(new FindCubicleAction(cubicles, cubiclesUser));
		this.addAction(new UndressAction(timeToUndress));
		this.addAction(new FreeCubicleAction(cubicles, cubiclesUser));
		this.addAction(new TakeBathAction(timeToBathe));
		this.addAction(new FindCubicleAction(cubicles, cubiclesUser));
		this.addAction(new DressAction(timeToDress));
		this.addAction(new FreeCubicleAction(cubicles, cubiclesUser));
		this.addAction(new FreeBasketAction(baskets, basketUser));
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public String getMessageBeforeAction() {
		return name + "'s turn";
	}
	
	@Override
	public String getMessageAfterAction() {
		return "";
	}

}
