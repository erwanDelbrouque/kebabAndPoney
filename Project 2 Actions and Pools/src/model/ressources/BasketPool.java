package model.ressources;


public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int n) {
		super("Basket", n);
	}
	
	@Override
	public Basket createResource() {
		return new Basket();
	}

}
