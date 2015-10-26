package model.scheduler;

import model.actions.DressAction;
import model.actions.FindCubicleAction;
import model.actions.FreeBasketAction;
import model.actions.FreeCubicleAction;
import model.actions.TakeBasketAction;
import model.actions.TakeBathAction;
import model.actions.UndressAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.ressources.BasketPool;
import model.ressources.BasketResourcefulUser;
import model.ressources.CubiclePool;
import model.ressources.CubicleResourcefulUser;

public class Swimmer extends SequentialScheduler {
	
	protected BasketResourcefulUser basketUser;
	protected CubicleResourcefulUser cubiclesUser;
	protected BasketPool basketsPool;
	protected CubiclePool cubiclesPool;
	
	
	public Swimmer(String name, BasketPool basketsPool, CubiclePool cubiclesPool, int timeToUndress, int timeToBathe, int timeToDress) throws ActionFinishedException, ActionInProgressException{
		super(name);
		this.basketsPool = basketsPool;
		this.cubiclesPool = cubiclesPool;
		basketUser = new BasketResourcefulUser(this.name);
		cubiclesUser = new CubicleResourcefulUser(this.name);
		
		createActions(basketsPool, cubiclesPool, timeToUndress, timeToBathe, timeToDress);
	}

	public void createActions(BasketPool basketsPool, CubiclePool cubiclesPool, int timeToUndress, int timeToBathe, int timeToDress) throws ActionFinishedException, ActionInProgressException {
		this.addAction(new TakeBasketAction(basketsPool, basketUser));
		this.addAction(new FindCubicleAction(cubiclesPool, cubiclesUser));
		this.addAction(new UndressAction(timeToUndress));
		this.addAction(new FreeCubicleAction(cubiclesPool, cubiclesUser));
		this.addAction(new TakeBathAction(timeToBathe));
		this.addAction(new FindCubicleAction(cubiclesPool, cubiclesUser));
		this.addAction(new DressAction(timeToDress));
		this.addAction(new FreeCubicleAction(cubiclesPool, cubiclesUser));
		this.addAction(new FreeBasketAction(basketsPool, basketUser));
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
