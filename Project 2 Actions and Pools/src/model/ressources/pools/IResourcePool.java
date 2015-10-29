package model.ressources.pools;

import java.util.NoSuchElementException;

import model.ressources.Resource;

/**
 * * <b>This interface if implements by the ResourcePool class.</b>
 * @param <R> The type of the contained resource
 * 
 * @see ResourcePool
 */
public interface IResourcePool<R extends Resource> {

	/**
	 * Provides a free resource
	 * @return The resource provided to the user
	 * @throws NoSuchElementException When there are no free resources
	 */
	public R provideRessource() throws NoSuchElementException;

	/**
	 * @return true if there are free resources, else false
	 */
	public boolean hasAvailableRessource();

	/**
	 * Frees the resource given in parameter
	 * @param ressource The resource to free
	 * @throws IllegalArgumentException When the resource doesn't belong to this pool
	 */
	public void freeRessource(R ressource) throws IllegalArgumentException;

	/**
	 * Creates a new resource and return it
	 * @return The new resource created
	 */
	public R createResource();
}