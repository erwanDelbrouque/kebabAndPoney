package model.actions.resourcepoolactions.takeactions;

import model.ressources.Cubicle;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This action provides a cubicle from a cubicle pool, to a user</b>
 * 
 * @see ResourcePoolAction
 * @see TakeResourceAction
 */
public class FindCubicleAction extends TakeResourceAction<Cubicle>{

	/**
	 * Constructor with a cubicle pool and a user
	 * @param pool The cubicle pool
	 * @param user The user to provide
	 */
	public FindCubicleAction(ResourcePool<Cubicle> pool, ResourcefulUser<Cubicle> user) {
		super(pool, user);
	}
}
