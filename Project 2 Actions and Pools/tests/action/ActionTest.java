package action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.exceptions.ActionFinishedException;

import org.junit.Test;

import mockedclasses.resources.MockedResourcePool;

public abstract class ActionTest {
	protected abstract IAction createAction();
	protected abstract IAction createAction(int nbStepsMax);
	protected abstract IAction createAction(String name,int nbStepsMax);

	@Test(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException {
		IAction action = createAction();

		doStepUntilFinished(action);

		assertTrue(action.isFinished());
		action.doStep();
	}

	protected void isReadyTest(IAction action) {

		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());

	}

	protected void isInProgressTest(IAction action) {

		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());

	}

	protected void isFinishedTest(IAction action) {

		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());

	}
	
	protected void doStepUntilFinished(IAction action) {
		while (!action.isFinished()) {
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("action was not supposed to be finished, we just checked");
			}
		}
	}
	
	@Test
	public void onlyOneValidStateAtEachMomentForForeseeableAction() throws ActionFinishedException {
		onlyOneValidStateAtEachMoment(createAction(10));
	}
	
	protected void onlyOneValidStateAtEachMoment(IAction action) throws ActionFinishedException {
		isReadyTest(action);
		while (!action.isFinished()) {
			action.doStep();
			// isFinished xor isInProgress
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		isFinishedTest(action);
	}

	@Test(expected = NullPointerException.class)
	public void nullNameTest() throws NullPointerException, IllegalArgumentException {
		new ForeseeableAction(null,1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyNameTest() throws NullPointerException, IllegalArgumentException {
		new ForeseeableAction("",1);
	}
}