package model.actions.resourcepoolactions.freeactions;

import model.ressources.Cubicle;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class FreeCubicleAction extends FreeResourceAction<Cubicle> {

	public FreeCubicleAction(ResourcePool<Cubicle> pool, ResourcefulUser<Cubicle> user) {
		super(pool, user);
	}
	
}
