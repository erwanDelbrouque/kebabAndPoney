package model.actions.resourcepoolactions.freeactions;

import model.ressources.Cubicle;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This action frees a cubicle from a cubicle user and put it in the cubicle pool</b>
 */
public class FreeCubicleAction extends FreeResourceAction<Cubicle> {

	/**
	 * Constructor with a cubicle pool and a user
	 * @param pool The cubicle pool
	 * @param user The user
	 */
	public FreeCubicleAction(ResourcePool<Cubicle> pool, ResourcefulUser<Cubicle> user) {
		super(pool, user);
	}
	
}
