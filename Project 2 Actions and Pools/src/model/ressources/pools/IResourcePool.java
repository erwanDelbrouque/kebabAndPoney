package model.ressources.pools;

import java.util.NoSuchElementException;

import model.ressources.Resource;

public interface IResourcePool<R extends Resource> {

	public R provideRessource() throws NoSuchElementException;

	public boolean hasAvailableRessource();

	public void freeRessource(R ressource) throws IllegalArgumentException;

	public R createResource();
}