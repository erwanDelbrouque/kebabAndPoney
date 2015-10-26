package model.actions.resourcepoolactions.takeactions;

import model.ressources.Basket;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class TakeBasketAction extends TakeResourceAction<Basket> {

	public TakeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user) {
		super(pool, user);
	}
	
}
