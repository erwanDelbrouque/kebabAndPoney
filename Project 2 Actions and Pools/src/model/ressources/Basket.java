package model.ressources;

/**
 * <b>This class represents a Basket resource contained in a Basket Pool</b>
 * 
 * @see Resource
 * @see BasketPool
 * @see BasketResourcefulUser
 */
public class Basket implements Resource {
	
	@Override
	public String description() {
		return "A basket";
	}

}
