package scheduler;

import model.actions.Action;
import model.actions.ActionFinishedException;
import model.actions.ForeseeableAction;
import model.actions.OneStepAction;
import model.scheduler.Scheduler;

import org.junit.Test;

import action.ActionTest;

public abstract class SchedulerTest extends ActionTest {
	
	protected abstract Scheduler createScheduler();
	protected abstract Scheduler createScheduler(Action... actions) throws ActionFinishedException;
	
	@Override
	protected Action createAction() {
		return new OneStepAction();
	}

	@Override
	protected Action createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}

	
	@Test
	public void onlyOneValidStateAtEachMomentForScheduler() throws ActionFinishedException {
		Scheduler scheduler = createScheduler();
		scheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(scheduler);
	}
	
	//TODO : Add a test to test a scheduler in a scheduler
	
}
