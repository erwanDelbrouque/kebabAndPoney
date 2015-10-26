package model.actions.resourcepoolactions;

import model.actions.Action;
import model.ressources.Resource;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public abstract class ResourcePoolAction<R extends Resource> extends Action {

	protected ResourcePool<R> pool;
	protected ResourcefulUser<R> user;
	
	public ResourcePoolAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		this.pool = pool;
		this.user = user;
	}
	
}
