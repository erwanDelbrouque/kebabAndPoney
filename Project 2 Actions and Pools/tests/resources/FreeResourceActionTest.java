package resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import mockedclasses.resources.MockedResource;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.actions.resourcepoolactions.freeactions.FreeResourceAction;
import model.exceptions.ActionFinishedException;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public class FreeResourceActionTest extends ResourcePoolActionTest {
	
	protected ResourcePoolAction<MockedResource> r;
	protected MockedResource mockedResource; 
	
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
	
	@Test(expected=NoSuchElementException.class)
	public void freeNullResourceTest() throws NoSuchElementException, ActionFinishedException {
		user.resetResource();
		assertNull(user.getResource());
		r.doStep();
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void freeInvalideResourceType() throws NoSuchElementException, ActionFinishedException, IllegalArgumentException{
		mockedResource = new MockedResource();
		user.setResource(mockedResource);
		assertFalse(pool.getUsedResources().contains(mockedResource));
		assertFalse(pool.getFreeResources().contains(mockedResource));
		r.doStep();
	}
	
	@Test
	public void freeValideResourceType() throws NoSuchElementException, ActionFinishedException{
		assertTrue(pool.getUsedResources().contains(mockedResource));
		assertFalse(pool.getFreeResources().contains(mockedResource));
		r.doStep();
		assertTrue(pool.getFreeResources().contains(mockedResource));
		assertFalse(pool.getUsedResources().contains(mockedResource));
	}
	
}
