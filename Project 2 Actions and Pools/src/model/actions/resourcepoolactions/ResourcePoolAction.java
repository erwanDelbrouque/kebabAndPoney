package model.actions.resourcepoolactions;

import model.actions.Action;
import model.ressources.Resource;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This class represents an Action that act on a resource and a user</b>
 * 
 * @param <R> Type of manipulated resource
 * 
 *  @see TakeResourceAction
 *  @see FreeResourceAction
 */
public abstract class ResourcePoolAction<R extends Resource> extends Action {

	/**
	 * The resource pool
	 */
	protected ResourcePool<R> pool;
	
	/**
	 * The user
	 */
	protected ResourcefulUser<R> user;
	
	/**
	 * Constructor with a pool and a user
	 * @param pool The resource pool
	 * @param user The user
	 */
	public ResourcePoolAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		//TODO : Verification here and tests
		this.pool = pool;
		this.user = user;
	}
	
	@Override
	public void checkState() {
		actionState = ACTION_STATE.FINISHED;
	}
	
}
