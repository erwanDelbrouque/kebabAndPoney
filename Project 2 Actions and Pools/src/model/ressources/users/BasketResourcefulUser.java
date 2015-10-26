package model.ressources.users;

import model.ressources.Basket;

public class BasketResourcefulUser extends ResourcefulUser<Basket> {
	
	public BasketResourcefulUser(String name) {
		super(name);
	}
	
	public BasketResourcefulUser() {
		super("Basket User");
	}

}
