package resources;

import model.actions.Action;
import model.actions.ResourcePoolAction;
import model.ressources.MockedResource;
import model.ressources.MockedResourcePool;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;
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
	
}
