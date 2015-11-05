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
	
	/* (non-Javadoc)
	 * @see action.ActionTest#createAction()
	 */
	@Override
	protected IAction createAction() {
		return new OneStepAction();
	}

	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(int)
	 */
	@Override
	protected IAction createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}
	
	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(java.lang.String, int)
	 */
	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return new ForeseeableAction(name,nbStepsMax);
	}
	
	/**
	 * Returns a new Resource Pool
	 * @param name The name of the pool
	 * @param nbResources The number of resource to create
	 * @return
	 */
	protected MockedResourcePool createPool(String name, int nbResources) {
		return new MockedResourcePool(name, nbResources);
	}
	
	/**
	 * Tests the instanciation of a pool
	 */
	@Test
	public void creationTest(){
		mockedResourcePool = createPool("test", 2);
		assertEquals(2, mockedResourcePool.getFreeResources().size());
		assertEquals("test", mockedResourcePool.getName());
	}
	
	/* (non-Javadoc)
	 * @see action.ActionTest#nullNameTest()
	 */
	@Test(expected = NullPointerException.class)
	public void nullNameTest() throws NullPointerException, IllegalArgumentException {
		new MockedResourcePool(null,1);
	}

	/* (non-Javadoc)
	 * @see action.ActionTest#emptyNameTest()
	 */
	@Test(expected = IllegalArgumentException.class)
	public void emptyNameTest() throws NullPointerException, IllegalArgumentException {
		new MockedResourcePool("",1);
	}
	
	/**
	 * Tests the instanciation with an invalid number of resource to create
	 */
	@Test(expected = IllegalArgumentException.class)
	public void invalideNbTest() throws NullPointerException, IllegalArgumentException {
		new MockedResourcePool("test",-1);
	}
	
	/**
	 * Tests freeing a null resource
	 */
	@Test(expected=NullPointerException.class)
	public void freeNullResource() {
		new MockedResourcePool(1).freeRessource(null);
	}

	
}
