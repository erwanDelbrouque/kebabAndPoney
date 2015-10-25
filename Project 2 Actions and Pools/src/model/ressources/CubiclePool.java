package model.ressources;

public class CubiclePool  extends ResourcePool<Cubicle>  {

	public CubiclePool(int n) {
		super("Cubicle", n);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
