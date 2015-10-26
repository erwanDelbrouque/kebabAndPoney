package model.ressources.pools;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.ressources.Resource;

public abstract class ResourcePool<R extends Resource> implements IResourcePool<R> {
	
	protected String name;
	protected ArrayList<R> freeResources;
	protected ArrayList<R> usedResources;
	
	public ResourcePool(String name, int n) {
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

