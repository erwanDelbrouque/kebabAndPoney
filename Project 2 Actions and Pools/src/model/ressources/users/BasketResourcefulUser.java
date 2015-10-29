package model.ressources.users;

import model.ressources.Basket;

/**
 * <b>This class represents a Basket user</b>
 * 
 * @see ResourcefulUser
 * @see Basket
 * @see BasketPool
 */
public class BasketResourcefulUser extends ResourcefulUser<Basket> {
	
	/**
	 * Default constructor with default name ("Basket User")
	 * @param name The name of the basket user
	 */
	public BasketResourcefulUser() {
		super("Basket User");
	}
	
	/**
	 * Basket user constructor with a name 
	 * @param name The name of the basket user
	 */
	public BasketResourcefulUser(String name) {
		super(name);
	}
	

}
