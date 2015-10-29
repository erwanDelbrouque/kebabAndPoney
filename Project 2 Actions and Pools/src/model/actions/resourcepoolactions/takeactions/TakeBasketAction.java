package model.actions.resourcepoolactions.takeactions;

import model.ressources.Basket;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This action provides a basket from a basket pool, to a user</b>
 * 
 * @see ResourcePoolAction
 * @see TakeResourceAction
 */
public class TakeBasketAction extends TakeResourceAction<Basket> {
	
	/**
	 * Constructor with a basket pool and a user
	 * @param pool The basket pool
	 * @param user The user to provide
	 */
	public TakeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user) {
		super(pool, user);
	}
	
}
