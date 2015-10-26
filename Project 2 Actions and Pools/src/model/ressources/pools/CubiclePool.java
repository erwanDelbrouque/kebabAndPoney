package model.ressources.pools;

import model.ressources.Cubicle;

public class CubiclePool  extends ResourcePool<Cubicle>  {

	public CubiclePool(int n) {
		super("Cubicle", n);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
