package action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.exceptions.ActionFinishedException;

import org.junit.Test;

/**
 * This class tests the Action class
 * 
 * @see Action
 * @see IAction
 */
public abstract class ActionTest {
	/**
	 * @return A simple action (generally a OneStepAction)
	 */
	protected abstract IAction createAction();
	
	/**
	 * Creates an action with the number of steps to do before being finished 
	 * @param nbStepsMax The number of steps to do to finish this action
	 * @return An action with the number of steps to do before being finished 
	 */
	protected abstract IAction createAction(int nbStepsMax);
	

	/**
	 * Creates an action with a name and the number of steps to do before being finished 
	 * @param name The name of teh action
	 * @param nbStepsMax The number of steps to do to finish this action
	 * @return
	 */
	protected abstract IAction createAction(String name,int nbStepsMax);

	/**
	 * Tests if an action do throw an exception when we try to execute it after it's finished
	 */
	@Test(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException {
		IAction action = createAction();

		doStepUntilFinished(action);

		assertTrue(action.isFinished());
		action.doStep();
	}

	/**
	 * Tests if an action is ready
	 * @param action The action to test
	 */
	protected void isReadyTest(IAction action) {

		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());

	}

	/**
	 * Tests if an action is in progress
	 * @param action The action to test
	 */
	protected void isInProgressTest(IAction action) {

		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());

	}

	/**
	 * Tests if an action is finished
	 * @param action The action to test
	 */
	protected void isFinishedTest(IAction action) {

		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());

	}
	
	/**
	 * Execute an action until it's finished
	 * @param action
	 */
	protected void doStepUntilFinished(IAction action) {
		while (!action.isFinished()) {
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("action was not supposed to be finished, we just checked");
			}
		}
	}
	
	/**
	 * Tests if one state is valid at each moment in a foreseeableAction
	 */
	@Test
	public void onlyOneValidStateAtEachMomentForForeseeableAction() throws ActionFinishedException {
		onlyOneValidStateAtEachMoment(createAction(10));
	}
	
	/**
	 * Tests if one state is valid at each moment in an action
	 * @param action The action to test
	 */
	protected void onlyOneValidStateAtEachMoment(IAction action) throws ActionFinishedException {
		isReadyTest(action);
		while (!action.isFinished()) {
			action.doStep();
			// isFinished xor isInProgress
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		isFinishedTest(action);
	}

	/**
	 * Tests if a name is not null 
	 * @throws NullPointerException If the name is null
	 */
	@Test(expected = NullPointerException.class)
	public void nullNameTest() throws NullPointerException, IllegalArgumentException {
		new ForeseeableAction(null,1);
	}

	/**
	 * Tests is a name is not empty
	 * @throws IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void emptyNameTest() throws NullPointerException, IllegalArgumentException {
		new ForeseeableAction("",1);
	}
}