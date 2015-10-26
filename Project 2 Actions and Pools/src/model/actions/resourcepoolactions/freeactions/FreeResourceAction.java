package model.actions.resourcepoolactions.freeactions;

import java.util.NoSuchElementException;

import model.actions.Action.ACTION_STATE;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.exceptions.ActionFinishedException;
import model.ressources.Resource;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class FreeResourceAction<R extends Resource> extends ResourcePoolAction<R>{

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
		
		actionState = ACTION_STATE.FINISHED;
		
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
