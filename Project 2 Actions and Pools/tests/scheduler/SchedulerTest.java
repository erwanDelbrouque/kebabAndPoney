package scheduler;

import model.actions.Action;
import model.actions.ActionFinishedException;
import model.actions.ActionInProgressException;
import model.actions.ForeseeableAction;
import model.actions.OneStepAction;
import model.scheduler.Scheduler;

import org.junit.Test;

import action.ActionTest;

public abstract class SchedulerTest extends ActionTest {
	
	protected abstract Scheduler createScheduler();
	protected abstract Scheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException;
	
	@Override
	protected Action createAction() {
		return new OneStepAction();
	}

	@Override
	protected Action createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}

	
	@Test
	public void onlyOneValidStateAtEachMomentForScheduler() throws ActionFinishedException, ActionInProgressException {
		Scheduler scheduler = createScheduler();
		scheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(scheduler);
	}
	
	@Test(expected=ActionInProgressException.class)
	public void cannotAddActionWhileSchedulerInProgress() throws ActionFinishedException, ActionInProgressException {
		Scheduler s1 = createScheduler();
		Action a1 = createAction(2);
		Action a2 = createAction(2);
		s1.addAction(a1);
		isReadyTest(s1);
		s1.doStep();
		isInProgressTest(s1);
		s1.addAction(a2);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotAddSameActionInScheduler() throws ActionFinishedException, ActionInProgressException {
		Scheduler s1 = createScheduler();
		Action a1 = createAction();
		s1.addAction(a1);
		isReadyTest(s1);
		s1.addAction(a1);
	}
	
	//TODO : Add a test to test a scheduler in a scheduler
	
	
}
