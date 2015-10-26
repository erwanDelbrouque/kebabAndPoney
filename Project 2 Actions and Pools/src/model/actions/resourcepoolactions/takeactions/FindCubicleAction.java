package model.actions.resourcepoolactions.takeactions;

import model.ressources.Cubicle;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class FindCubicleAction extends TakeResourceAction<Cubicle>{

	public FindCubicleAction(ResourcePool<Cubicle> pool, ResourcefulUser<Cubicle> user) {
		super(pool, user);
	}
}
