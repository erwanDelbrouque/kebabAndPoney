package action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockedclasses.actions.BadAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

import org.junit.Test;

public class BadActionTest {
	private BadAction createAction(int timeToEnd) throws ActionFinishedException, ActionInProgressException {
		BadAction badAction = new BadAction();
		if(timeToEnd > 0) {
			badAction.addAction(new ForeseeableAction(timeToEnd));
		}
		
		return badAction;
	}
	
	@Test
	public void foreseeableAction() throws ActionFinishedException, ActionInProgressException {
		BadAction action = createAction(2);
		// 2 steps remaining
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		action.doStep();
		// 1 step remaining
		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());
		action.doStep();
		// 0 step remaining
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
	@Test
	public void scheduler() throws ActionFinishedException, ActionInProgressException {
		BadAction action1 = createAction(2);
		BadAction action2 = createAction(1);
		BadAction scheduler = createAction(0);
		scheduler.addAction(action1);
		scheduler.addAction(action2);
		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		scheduler.doStep();
		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(action2.isReady());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
	}
	@Test
	public void schedulerWithScheduler() throws ActionFinishedException, ActionInProgressException {
		BadAction action1 = createAction(2);
		BadAction subScheduler = createAction(0);
		BadAction scheduler = createAction(0);
		subScheduler.addAction(action1);
		scheduler.addAction(subScheduler);
		assertTrue(action1.isReady());
		assertTrue(subScheduler.isReady());
		scheduler.doStep();
		assertTrue(action1.isInProgress());
		assertTrue(subScheduler.isInProgress());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(subScheduler.isFinished());
	}
	
	

	
}