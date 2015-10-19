package model.actions;

import model.ressources.Basket;
import model.ressources.Resource;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public class TakeBasketAction<R extends Resource> extends TakeResourceAction<Basket> {

	public TakeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

}
