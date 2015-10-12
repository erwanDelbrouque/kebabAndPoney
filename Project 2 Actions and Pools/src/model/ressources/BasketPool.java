package model.ressources;


public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int n) {
		super(n);
	}
	
	@Override
	protected Basket createResource() {
		return new Basket();
	}

}
