package model.actions.resourcepoolactions.freeactions;

import model.ressources.Basket;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class FreeBasketAction extends FreeResourceAction<Basket>{

	public FreeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user) {
		super(pool, user);	
	}
}
