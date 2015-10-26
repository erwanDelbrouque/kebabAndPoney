package model.actions;

import model.ressources.Cubicle;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public class FreeCubicleAction extends FreeResourceAction<Cubicle> {

	public FreeCubicleAction(ResourcePool<Cubicle> pool, ResourcefulUser<Cubicle> user) {
		super(pool, user);
	}
	
}
