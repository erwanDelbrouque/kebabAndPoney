package model.ressources;


public class BasketPool<R extends Basket> extends ResourcePool<Basket> {

	public BasketPool(int n) {
		super(n);
	}
	
	@Override
	public Basket createResource() {
		return new Basket();
	}

}
