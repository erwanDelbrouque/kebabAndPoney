package scheduler;

import java.util.NoSuchElementException;

import model.actions.Action;
import model.actions.IAction;
import model.actions.foreseeableactions.ForeseeableAction;
import model.actions.foreseeableactions.OneStepAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.IScheduler;
import model.scheduler.Scheduler;

import org.junit.Test;

import action.ActionTest;

public abstract class SchedulerTest extends ActionTest {
	
	protected abstract Scheduler createScheduler();
	protected abstract IScheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException;
	
	@Override
	protected Action createAction() {
		return new OneStepAction();
	}

	@Override
	protected Action createAction(int nbStepsMax) {
		return new ForeseeableAction(nbStepsMax);
	}

	@Override
	protected IAction createAction(String name, int nbStepsMax) {
		return new ForeseeableAction(name,nbStepsMax);
	}
	
	@Test
	public void onlyOneValidStateAtEachMomentForScheduler() throws ActionFinishedException, ActionInProgressException {
		Scheduler scheduler = createScheduler();
		scheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(scheduler);
	}
	
	@Test(expected=NullPointerException.class)
	public void addNullActionTest() throws ActionFinishedException, ActionInProgressException {
		IScheduler s = createScheduler();
		s.addAction(null);
	}
	
	@Test(expected=ActionInProgressException.class)
	public void addActionWhileSchedulerInProgressTest() throws ActionFinishedException, ActionInProgressException {
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
	public void addSameActionInSchedulerTest() throws ActionFinishedException, ActionInProgressException {
		Scheduler s1 = createScheduler();
		Action a1 = createAction();
		s1.addAction(a1);
		isReadyTest(s1);
		s1.addAction(a1);
	}
	
	@Test(expected=ActionFinishedException.class)
	public void addActionWhenSchedulerFinished() throws IllegalArgumentException, ActionFinishedException, ActionInProgressException {
		Scheduler s = createScheduler();
		s.addAction(createAction());
		s.addAction(createAction());
		
		doStepUntilFinished(s);
		
		s.addAction(createAction());
		
	}
	
	@Test(expected=NoSuchElementException.class)
	public void doStepWithoutActionsAdded() throws ActionFinishedException {
		Scheduler s = createScheduler();
		isReadyTest(s);
		s.doStep();
	}

	
	
}
