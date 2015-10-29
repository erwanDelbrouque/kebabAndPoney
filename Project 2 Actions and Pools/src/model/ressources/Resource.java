package model.ressources;

/**
 * <b>A resource is a object that can be contained in a Resource Pool and provided to a user by an action</b>
 * 
 * @see ResourcePool
 * @see ResourcePoolAction
 * @see ResourcefulUser
 */
public interface Resource {
	
	/**
	 * @return The description of this resource
	 */
	public String description();
}