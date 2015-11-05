package resources;

import org.junit.Test;

import action.ActionTest;
import mockedclasses.resources.MockedResource;
import mockedclasses.resources.MockedResourcePool;
import model.actions.IAction;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

public abstract class ResourcePoolActionTest extends ActionTest {
	
	/**
	 * A default number of resource to create in the pool
	 */
	protected int n = 2;
	
	/**
	 * A pool of resource
	 */
	protected MockedResourcePool pool = new MockedResourcePool(n);
	
	/**
	 * A resource user
	 */
	protected ResourcefulUser<MockedResource> user = new ResourcefulUser<MockedResource>();
	
	
	/* (non-Javadoc)
	 * @see action.ActionTest#createAction()
	 */
	@Override
	protected ResourcePoolAction<MockedResource> createAction() {
		return createAction(pool, user);
	}
	
	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(int)
	 */
	@Override
	protected IAction createAction(int nbStepsMax) {
		return createAction();
	}
	
	protected abstract ResourcePoolAction<MockedResource> createAction(ResourcePool<MockedResource> pool, ResourcefulUser<MockedResource> user);

	/**
	 * Test the creation of an action with a null pool parameter
	 */
	@Test(expected = NullPointerException.class)
	public void nullPoolTest(){
		createAction(null,user);
	}
	
	/**
	 * Test the creation of an action with a null user parameter
	 */
	@Test(expected = NullPointerException.class)
	public void nullUserTest(){
		createAction(pool,null);
	}
	
}
