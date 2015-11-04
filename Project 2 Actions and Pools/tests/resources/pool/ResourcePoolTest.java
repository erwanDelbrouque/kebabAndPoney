package resources.pool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import action.ActionTest;
import mockedclasses.resources.MockedResourcePool;
import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;

public class ResourcePoolTest extends ActionTest{

	MockedResourcePool mockedResourcePool;
	@Override
	protected IAction createAction() {
		return createAction(1);
	}

	@Override
	protected IAction createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}
	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return new ForeseeableAction(name,nbStepsMax);
	}
	
	@Test
	public void creationTest(){
		mockedResourcePool  = new  MockedResourcePool("test",2);
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
