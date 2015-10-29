package model.actions.resourcepoolactions.freeactions;

import model.ressources.Basket;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This action frees a basket from a basket user and put it in the basket pool</b>
 */
public class FreeBasketAction extends FreeResourceAction<Basket>{

	/**
	 * Constructor with a basket pool and a user
	 * @param pool The basket pool
	 * @param user The user
	 */
	public FreeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user) {
		super(pool, user);	
	}
}
