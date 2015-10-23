package model.actions;

import model.ressources.Basket;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public class FreeBasketAction extends FreeResourceAction<Basket>{

	public FreeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user) {
		super(pool, user);	
	}
}
