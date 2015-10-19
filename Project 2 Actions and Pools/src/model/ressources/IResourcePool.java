package model.ressources;

import java.util.NoSuchElementException;

public interface IResourcePool<R extends Resource> {

	public R provideRessource() throws NoSuchElementException;

	public boolean hasAvailableRessource();

	public void freeRessource(R ressource) throws IllegalArgumentException;

	public R createResource();
}