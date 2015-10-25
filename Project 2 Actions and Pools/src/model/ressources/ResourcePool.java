package model.ressources;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ResourcePool<R extends Resource> implements IResourcePool<R> {
	
	protected String name;
	protected ArrayList<R> freeResources;
	protected ArrayList<R> usedResources;
	
	public ResourcePool(String name, int n) {
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

