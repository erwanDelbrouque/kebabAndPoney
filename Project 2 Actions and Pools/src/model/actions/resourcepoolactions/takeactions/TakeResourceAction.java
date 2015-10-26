package model.actions.resourcepoolactions.takeactions;

import java.util.NoSuchElementException;

import model.actions.Action.ACTION_STATE;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.exceptions.ActionFinishedException;
import model.ressources.Resource;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<R> {

	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	@Override
	public void doStep() throws ActionFinishedException, NoSuchElementException {
		super.doStep();

		R resource = null;
		resource = pool.provideRessource();
		
		this.user.setResource(resource);
		this.actionState = ACTION_STATE.FINISHED;
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
