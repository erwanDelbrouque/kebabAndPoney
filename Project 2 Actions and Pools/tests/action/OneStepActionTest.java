package action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.actions.OneStepAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.FairScheduler;
import model.scheduler.Scheduler;

import org.junit.Test;

public class OneStepActionTest {

	@Test
	public void with1OneStepAction() throws ActionFinishedException, ActionInProgressException {
		OneStepAction action1 = new OneStepAction();
		Scheduler scheduler = createScheduler(action1);
		assertFalse(scheduler.isFinished());
		assertFalse(action1.isFinished());
		scheduler.doStep();
		assertTrue(scheduler.isFinished());
		assertTrue(action1.isFinished());
	}

	private Scheduler createScheduler(OneStepAction action1) throws ActionFinishedException, ActionInProgressException {
		return new FairScheduler(action1);
	}

}
