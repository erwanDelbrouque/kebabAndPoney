package model.actions;

import model.ressources.Basket;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

public class TakeBasketAction extends TakeResourceAction<Basket> {

	public TakeBasketAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user) {
		super(pool, user);
	}
	
	@Override
	public String getMessageAfterAction() {
		return "Trying ot get basket";
	}

}
