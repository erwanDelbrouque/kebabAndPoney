package model.actions.resourcepoolactions.freeactions;

import java.util.NoSuchElementException;

import model.actions.resourcepoolactions.ResourcePoolAction;
import model.exceptions.ActionFinishedException;
import model.ressources.Resource;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

/**
 * <b>This action frees a resource from a user and put it in the corresponding pool</b>
 *
 * @param <R> The freed resource type
 */
public class FreeResourceAction<R extends Resource> extends ResourcePoolAction<R>{

	/**
	 * Constructor with a pool and a user
	 * @param pool The pool
	 * @param user The user
	 */
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	@Override
	public void doStep() throws ActionFinishedException, NoSuchElementException {
		super.doStep();
		
		if(user.getResource() == null) {
			throw new NoSuchElementException("There are no ressources used by the User");
		}
		
		pool.freeRessource(user.getResource());
		
		user.resetResource();
		checkState();
	}

	@Override
	public String getMessageBeforeAction() {
		return user + " freeing ressource from pool " + pool;
	}
	
	@Override
	public String getMessageAfterAction() {
		return "";
	}
	
	
	
}
