package model.ressources.pools;

import model.ressources.Basket;


public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int n) {
		super("Basket", n);
	}
	
	@Override
	public Basket createResource() {
		return new Basket();
	}

}
