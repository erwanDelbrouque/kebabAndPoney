package model.ressources.pools;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.ressources.Resource;

/**
 * <b>This class represents a Pool containing resources that can be used by users.</b>
 * It provides its resource to users thanks to actions
 *
 * @param <R> The type of the resources this pool contains
 * 
 * @see IResourcePool
 */
public abstract class ResourcePool<R extends Resource> implements IResourcePool<R> {
	
	/**
	 * The name of this resource pool 
	 */
	protected String name;
	
	/**
	 * A list of free resources 
	 */
	protected ArrayList<R> freeResources;
	
	/**
	 * A list of the used resources 
	 */
	protected ArrayList<R> usedResources;
	
	/**
	 * Constructor with name and number of resource to create
	 * @param name The name
	 * @param n The number of resources
	 * @throws NullPointerException When name is null
	 * @throws IllegalArgumentException When name is empty or n is <= 0
	 */
	public ResourcePool(String name, int n) throws NullPointerException, IllegalArgumentException {
		if(name == null) {
			throw new NullPointerException("You must specify a non null name !");
		}
		
		if(name.isEmpty()) {
			throw new NullPointerException("You must specify a non empty name !");
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("You must specify a number of resource > 0 !");
		}
		
		this.name = name;
		this.freeResources = new ArrayList<R>();
		this.usedResources = new ArrayList<R>();
		
		for(int i = 0; i < n; ++i) {
			this.freeResources.add(createResource());
		}
		
	}

	@Override
	public R provideRessource() throws NoSuchElementException {
		if(hasAvailableRessource()) {
			R r = freeResources.remove(0);
			usedResources.add(r);
			return r;
		}
		
		throw new NoSuchElementException("...failed");
	}

	@Override
	public boolean hasAvailableRessource() {
		return (!freeResources.isEmpty());
	}
	
	@Override
	public void freeRessource(R ressource) throws IllegalArgumentException {
		if(ressource == null) {
			throw new NullPointerException("You must specify a non null resource to free !");
		}
		
		int indexRessourceUsed = this.usedResources.indexOf(ressource);
		
		if(indexRessourceUsed != -1) {
			this.usedResources.remove(indexRessourceUsed);
			this.freeResources.add(ressource);
		} else {
			throw new IllegalArgumentException("This ressource isn't managed by this ressource pool !");
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}

