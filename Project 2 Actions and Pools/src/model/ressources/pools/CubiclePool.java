package model.ressources.pools;

import model.ressources.Cubicle;

/**
 * This class represents a Cubicle Pool that provides cubicles
 * 
 * @see IResourcePool
 * @see ResourcePool
 * @see Cubicle
 * @see CubicleResourcefulUser
 */
public class CubiclePool  extends ResourcePool<Cubicle>  {

	/**
	 * Constructor with default name "Cubicle" and a number of cubicles to create
	 * @param n The number of cubicles to create
	 * @throws NullPointerException When name is empty
	 * @throws IllegalArgumentException When name is empty or n is <= 0
	 */
	public CubiclePool(int n) throws NullPointerException, IllegalArgumentException {
		super("Cubicle", n);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
