package model.ressources;

/**
 * <b>This class represents a Cubicle resource contained in a Cubicle Pool</b>
 * 
 * @see Resource
 * @see CubiclePool
 * @see CubicleResourcefulUser
 */
public class Cubicle implements Resource {

	@Override
	public String description() {
		return "A cubicle";
	}

}
