package resources;

import mockedclasses.resources.MockedResource;
import mockedclasses.resources.MockedResourcePool;
import model.actions.IAction;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.ressources.Basket;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	protected IAction createAction(int nbStepsMax) {
		return createAction();
	}
	
	protected abstract ResourcePoolAction<MockedResource> createAction(ResourcePool<MockedResource> pool, ResourcefulUser<MockedResource> user);

	
}
