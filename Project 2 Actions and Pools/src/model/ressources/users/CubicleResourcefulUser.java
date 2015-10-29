package model.ressources.users;

import model.ressources.Cubicle;

/**
 * <b>This class represents a Cubicle user</b>
 * 
 * @see ResourcefulUser
 * @see Cubicle
 * @see CubiclePool
 */
public class CubicleResourcefulUser extends ResourcefulUser<Cubicle> {
	
	/**
	 * Default constructor with default name ("Cubicle User")
	 * @param name
	 */
	public CubicleResourcefulUser() {
		super("Cubicle user");
	}
	
	/**
	 * Cubicle user constructor with a name 
	 * @param name The name of the cubicle user
	 */
	public CubicleResourcefulUser(String name) {
		super(name);
	}
	

}
