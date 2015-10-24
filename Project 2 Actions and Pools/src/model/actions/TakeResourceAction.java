package model.actions;

import java.util.NoSuchElementException;

import model.ressources.Resource;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<R> {

	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	@Override
	public void doStep() throws ActionFinishedException, NoSuchElementException {
		super.doStep();

		R resource = null;

		try {
			resource = pool.provideRessource();
			notify("...success");
		}
		catch(NoSuchElementException e) {
			throw e;
		}
		
		this.user.setResource(resource);
		this.actionState = ACTION_STATE.FINISHED;
	}

	@Override
	public String getMessageAfterAction() {
		return user + " trying to get ressource from pool " + pool;
	}

}
