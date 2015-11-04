package resources;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import mockedclasses.resources.MockedResource;
import model.actions.IAction;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.actions.resourcepoolactions.takeactions.TakeResourceAction;
import model.exceptions.ActionFinishedException;
import model.ressources.pools.ResourcePool;
import model.ressources.users.ResourcefulUser;

import org.junit.Test;

public class TakeRessourceActionTest extends ResourcePoolActionTest {

	@Override
	protected ResourcePoolAction<MockedResource> createAction(ResourcePool<MockedResource> pool, ResourcefulUser<MockedResource> user) {
		return new TakeResourceAction<>(pool, user);
	}
	
	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return createAction(pool, user);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRessourceEnAttente() throws ActionFinishedException, NoSuchElementException {
		ResourcePoolAction<MockedResource> r =  createAction();
		ArrayList<MockedResource> allRessource = new ArrayList<MockedResource>();
		
		for(int i = 0; i < n; i++) {
			allRessource.add(pool.provideRessource());
		}
		
		isReadyTest(r);
		
		r.doStep();
		isInProgressTest(r);
		r.doStep();
		isInProgressTest(r);
		
		pool.freeRessource(allRessource.get(0));
		r.doStep();
		isFinishedTest(r);
		
	}
	
	

}
