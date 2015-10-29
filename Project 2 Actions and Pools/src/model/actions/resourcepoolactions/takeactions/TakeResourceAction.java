package model.actions.resourcepoolactions.takeactions;

import java.util.NoSuchElementException;

import model.actions.resourcepoolactions.ResourcePoolAction;
import model.exceptions.ActionFinishedException;
import model.ressources.Resource;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This action takes a resource from a pool and provide it to a user</b>
 * 
 * @param <R> Type of provided resource
 * 
 * @see ResourcePoolAction
 * @see FreeResourceAction
 */
public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<R> {

	/**
	 * Constructor with a pool and a user
	 * @param pool The resource pool
	 * @param user The user to provide
	 */
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	@Override
	public void doStep() throws ActionFinishedException, NoSuchElementException {
		super.doStep();

		R resource = null;
		resource = pool.provideRessource();
		
		this.user.setResource(resource);
		checkState();
	}
	
	@Override
	public String getMessageBeforeAction() {
		return user + " trying to get ressource from pool " + pool;	
	}

	@Override
	public String getMessageAfterAction() {
		return "...success";
	}

}
