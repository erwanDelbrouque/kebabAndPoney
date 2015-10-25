package model.actions;

import model.ressources.Cubicle;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public class FindCubicleAction extends TakeResourceAction<Cubicle>{

	public FindCubicleAction(ResourcePool<Cubicle> pool, ResourcefulUser<Cubicle> user) {
		super(pool, user);
	}
}
