package action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import model.actions.Action;
import model.exceptions.ActionFinishedException;

import org.junit.Test;

public abstract class ActionTest {
	protected abstract Action createAction();
	protected abstract Action createAction(int nbStepsMax);

	@Test(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException {
		Action action = createAction();

		doStepUntilFinished(action);

		assertTrue(action.isFinished());
		action.doStep();
	}

	protected void isReadyTest(Action action) {

		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());

	}

	protected void isInProgressTest(Action action) {

		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());

	}

	protected void isFinishedTest(Action action) {

		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());

	}
	
	protected void doStepUntilFinished(Action action) {
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
	
	protected void onlyOneValidStateAtEachMoment(Action action) throws ActionFinishedException {
		isReadyTest(action);
		while (!action.isFinished()) {
			action.doStep();
			// isFinished xor isInProgress
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		isFinishedTest(action);
	}

}