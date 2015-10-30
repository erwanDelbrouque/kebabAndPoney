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

/**
 * <b>A swimmer is a basket and cubicle user that execute actions like a Sequential Scheduler</b>
 * <br>
 * Actions are :<br>
 * - Take a basket<br>
 * - Take a cubicle<br>
 * - Undress<br>
 * - Free the cubicle<br>
 * - Take a bathe<br>
 * - Take a cubicle<br>
 * - Dress<br>
 * - Free the cubicle<br>
 * - Free the basket<br>
 * 
 * @see IScheduler
 * @see Scheduler
 * @see SequentialScheduler
 */
public class Swimmer extends SequentialScheduler {

	/**
	 * A user variable that can hold a basket resource
	 */
	protected BasketResourcefulUser basketUser;

	/**
	 * A user variable that can hold a Cubicle resource
	 */
	protected CubicleResourcefulUser cubiclesUser;

	/**
	 * The basket pool which with this swimmer is provided
	 */
	protected BasketPool basketsPool;

	/**
	 * The basket pool which with this swimmer is provided
	 */
	protected CubiclePool cubiclesPool;


	/**
	 * Swimmer constructor
	 * @param name The name of this swimmer
	 * @param basketsPool The basket pool
	 * @param cubiclesPool The cubicle pool
	 * @param timeToUndress The time this swimmer takes to undress
	 * @param timeToBathe The time this swimmer takes to bathe
	 * @param timeToDress The time this swimmer takes to dress
	 * @throws ActionFinishedException When we try to add an action while this swimmer has finished his activity (impossible in this case)
	 * @throws ActionInProgressException When we try to add an action while this swimmer has begun his activity (impossible in this case)
	 */
	public Swimmer(String name, BasketPool basketsPool, CubiclePool cubiclesPool, int timeToUndress, int timeToBathe, int timeToDress) throws ActionFinishedException, ActionInProgressException, IllegalArgumentException{
		super(name);
		this.basketsPool = basketsPool;
		this.cubiclesPool = cubiclesPool;
		basketUser = new BasketResourcefulUser(this.name);
		cubiclesUser = new CubicleResourcefulUser(this.name);

		createActions(basketsPool, cubiclesPool, timeToUndress, timeToBathe, timeToDress);
	}

	/**
	 * Creates this swimmer's actions in the order
	 * <br>
	 * Actions are :<br>
	 * - Take a basket<br>
	 * - Take a cubicle<br>
	 * - Undress<br>
	 * - Free the cubicle<br>
	 * - Take a bathe<br>
	 * - Take a cubicle<br>
	 * - Dress<br>
	 * - Free the cubicle<br>
	 * - Free the basket<br>
	 * 
	 * @param basketsPool The basket pool
	 * @param cubiclesPool The Cubicle pool
	 * @param timeToUndress The time this swimmer takes to undress
	 * @param timeToBathe The time this swimmer takes to bathe
	 * @param timeToDress The time this swimmer takes to dress
	 * @throws ActionFinishedException When we try to add an action while this swimmer has finished his activity (impossible in this case)
	 * @throws ActionInProgressException When we try to add an action while this swimmer has begun his activity (impossible in this case)
	 */
	public void createActions(BasketPool basketsPool, CubiclePool cubiclesPool, int timeToUndress, int timeToBathe, int timeToDress) throws ActionFinishedException, ActionInProgressException, IllegalArgumentException {
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
