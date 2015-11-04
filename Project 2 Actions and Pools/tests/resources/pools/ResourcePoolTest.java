package resources.pools;

import static org.junit.Assert.assertEquals;
import mockedclasses.resources.MockedResourcePool;
import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.actions.foreseeableactions.OneStepAction;

import org.junit.Test;

import action.ActionTest;

public class ResourcePoolTest extends ActionTest{

	protected MockedResourcePool mockedResourcePool;
	
	@Override
	protected IAction createAction() {
		return new OneStepAction();
	}

	@Override
	protected IAction createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}
	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return new ForeseeableAction(name,nbStepsMax);
	}
	
	protected MockedResourcePool createPool(String name, int nbResources) {
		return new MockedResourcePool(name, nbResources);
	}
	
	@Test
	public void creationTest(){
		mockedResourcePool = createPool("test", 2);
		assertEquals(2, mockedResourcePool.getFreeResources().size());
		assertEquals("test", mockedResourcePool.getName());
	}
	
	@Test(expected = NullPointerException.class)
	public void nullNameTest() throws NullPointerException, IllegalArgumentException {
		new MockedResourcePool(null,1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyNameTest() throws NullPointerException, IllegalArgumentException {
		new MockedResourcePool("",1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalideNbTest() throws NullPointerException, IllegalArgumentException {
		new MockedResourcePool("test",-1);
	}
	
	@Test(expected=NullPointerException.class)
	public void freeNullResource() {
		new MockedResourcePool(1).freeRessource(null);
	}

	
}
