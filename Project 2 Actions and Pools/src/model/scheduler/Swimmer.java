package model.scheduler;

import model.actions.foreseeableactions.DressAction;
import model.actions.foreseeableactions.TakeBathAction;
import model.actions.foreseeableactions.UndressAction;
import model.actions.resourcepoolactions.freeactions.FreeBasketAction;
import model.actions.resourcepoolactions.freeactions.FreeCubicleAction;
import model.actions.resourcepoolactions.takeactions.FindCubicleAction;
import model.actions.resourcepoolactions.takeactions.TakeBasketAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.ressources.pools.BasketPool;
import model.ressources.pools.CubiclePool;
import model.ressources.users.BasketResourcefulUser;
import model.ressources.users.CubicleResourcefulUser;

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
