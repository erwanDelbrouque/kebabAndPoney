package model.actions;

import java.util.NoSuchElementException;

import model.ressources.Resource;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public abstract class ResourcePoolAction<R extends Resource> extends Action {

	protected ResourcePool<R> pool;
	protected ResourcefulUser<R> user;
	
	public ResourcePoolAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		this.pool = pool;
		this.user = user;
	}
	
}
