package model.ressources.users;

import model.ressources.Resource;

/**
 * <b>This class represents a User than can use a generic Resource type</b> 
 * @param <R> The Reources type that user can use
 */
public class ResourcefulUser<R extends Resource> {
	
	/**
	 * The name of the user
	 */
	protected String name;
	
	/**
	 * The resource used by the user
	 */
	protected R resource;
	
	/**
	 * Default constructor with a default name ("User")
	 */
	public ResourcefulUser() {
		this("User");
	}
	/**
	 * Constructor of a ResourcefulUser with a name
	 * @param name The name of the user
	 */
	public ResourcefulUser(String name) {
		this.name = name;
	}
	
	/**
	 * @return The resource used by this user, null if there are no resource used
	 */
	public R getResource() {
		return resource;
		
	}
	
	/**
	 * Sets the resource used by this user
	 * @param resource The resource to use
	 */
	public void setResource(R resource) {
		this.resource = resource;
		
	}
	
	/**
	 * Resets the resource used by this user
	 */
	public void resetResource() {
		this.resource = null;
		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}