package model.ressources.pools;

import model.ressources.Basket;

/**
 * This class represents a Basket Pool that provides baskets
 * 
 * @see IResourcePool
 * @see ResourcePool
 * @see Basket
 * @see BasketResourcefulUser
 */
public class BasketPool extends ResourcePool<Basket> {

	/**
	 * Constructor with default name "Basket" and a number of baskets to create
	 * @param n The number of baskets to create
	 * @throws NullPointerException When name is empty
	 * @throws IllegalArgumentException When name is empty or n is <= 0
	 */
	public BasketPool(int n) {
		super("Basket", n);
	}
	
	@Override
	public Basket createResource() {
		return new Basket();
	}

}
