package resources;

import mockedclasses.resources.MockedResource;
import mockedclasses.resources.MockedResourcePool;
import model.actions.Action;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

import org.junit.Test;

import action.ActionTest;

public abstract class ResourcePoolActionTest extends ActionTest {
	
	protected int n = 2;
	protected MockedResourcePool pool = new MockedResourcePool(n);
	protected ResourcefulUser<MockedResource> user = new ResourcefulUser<MockedResource>();
	
	
	@Override
	protected ResourcePoolAction<MockedResource> createAction() {
		return createAction(pool, user);
	}
	
	@Override
	protected Action createAction(int nbStepsMax) {
		return createAction();
	}
	
	protected abstract ResourcePoolAction<MockedResource> createAction(ResourcePool<MockedResource> pool, ResourcefulUser<MockedResource> user);
	
	@Test(expected=NullPointerException.class)
	public void freeNullResourceTest() {
		pool.freeRessource(null);
	}
	
}
