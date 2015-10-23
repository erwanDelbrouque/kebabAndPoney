package model.actions;

import java.util.NoSuchElementException;

import model.ressources.Resource;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

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
	
}
