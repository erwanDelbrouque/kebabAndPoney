package resources;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.actions.ActionFinishedException;
import model.actions.ResourcePoolAction;
import model.actions.TakeResourceAction;
import model.ressources.MockedResource;
import model.ressources.ResourcePool;
import model.ressources.ResourcefulUser;

import org.junit.Test;

public class TakeRessourceActionTest extends ResourcePoolActionTest {

	@Override
	protected ResourcePoolAction<MockedResource> createAction(ResourcePool<MockedResource> pool, ResourcefulUser<MockedResource> user) {
		return new TakeResourceAction<>(pool, user);
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
