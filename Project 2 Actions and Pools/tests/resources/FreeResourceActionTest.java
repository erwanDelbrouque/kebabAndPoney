package resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import mockedclasses.resources.MockedResource;
import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.actions.resourcepoolactions.freeactions.FreeResourceAction;
import model.exceptions.ActionFinishedException;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class FreeResourceActionTest extends ResourcePoolActionTest {
	
	/**
	 * An action that intercat with a pool and a user
	 */
	protected ResourcePoolAction<MockedResource> r;
	
	/**
	 * A mock resource
	 */
	protected MockedResource mockedResource; 
	
	/* (non-Javadoc)
	 * @see resources.ResourcePoolActionTest#createAction(model.ressources.pools.ResourcePool, model.ressources.users.ResourcefulUser)
	 */
	@Override
	protected ResourcePoolAction<MockedResource> createAction(ResourcePool<MockedResource> pool,
			ResourcefulUser<MockedResource> user) {
		return new FreeResourceAction<>(pool, user);
	}
	
	@Before
	public void setUp(){
		r =  createAction();
		mockedResource = pool.provideRessource();
		user.setResource(mockedResource);
	}

	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(java.lang.String, int)
	 */
	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return new ForeseeableAction(name,nbStepsMax);
	}
	
	/**
	 * Tests freeing a null resource
	 */
	@Test(expected=NoSuchElementException.class)
	public void freeNullResourceTest() throws NoSuchElementException, ActionFinishedException {
		user.resetResource();
		assertNull(user.getResource());
		r.doStep();
		
	}
	
	/**
	 * Tests freeing a resource that does not belong to a pool
	 */
	@Test(expected = IllegalArgumentException.class)
	public void freeInvalideResourceType() throws NoSuchElementException, ActionFinishedException, IllegalArgumentException{
		mockedResource = new MockedResource();
		user.setResource(mockedResource);
		assertFalse(pool.getUsedResources().contains(mockedResource));
		assertFalse(pool.getFreeResources().contains(mockedResource));
		r.doStep();
	}
	
	/**
	 * Tests freeing a valid resource type
	 */
	@Test
	public void freeValideResourceType() throws NoSuchElementException, ActionFinishedException{
		assertTrue(pool.getUsedResources().contains(mockedResource));
		assertFalse(pool.getFreeResources().contains(mockedResource));
		r.doStep();
		assertTrue(pool.getFreeResources().contains(mockedResource));
		assertFalse(pool.getUsedResources().contains(mockedResource));
	}
	
}
