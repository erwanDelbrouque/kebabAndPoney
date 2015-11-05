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

/**
 * Ce test teste la classe Scheduler
 *
 */

public abstract class SchedulerTest extends ActionTest {
	
	/**
	 * @return A new scheduler
	 */
	protected abstract Scheduler createScheduler();
	
	/**
	 * Returns a scheduler with actions in it
	 * @param actions The actions to add at the creation of the scheduler
	 * @return A scheduler with action in it
	 */
	protected abstract IScheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException;
	
	/* (non-Javadoc)
	 * @see action.ActionTest#createAction()
	 */
	@Override
	protected Action createAction() {
		return new OneStepAction();
	}

	/* (non-Javadoc)
	 * @see action.ActionTest#createAction(int)
	 */
	@Override
	protected Action createAction(int nbStepsMax) {
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
	 * Tests if there is one valid state at each moment for a scheduler
	 */
	@Test
	public void onlyOneValidStateAtEachMomentForScheduler() throws ActionFinishedException, ActionInProgressException {
		Scheduler scheduler = createScheduler();
		scheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(scheduler);
	}
	
	/**
	 * Tests adding a null action to a scheduler
	 */
	@Test(expected=NullPointerException.class)
	public void addNullActionTest() throws ActionFinishedException, ActionInProgressException {
		IScheduler s = createScheduler();
		s.addAction(null);
	}
	
	/**
	 * Tests adding an actions in a scheduler when it's in progress
	 */
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
	
	/**
	 * Tests adding an action already contained in a scheduler
	 */
	@Test(expected=IllegalArgumentException.class)
	public void addSameActionInSchedulerTest() throws ActionFinishedException, ActionInProgressException {
		Scheduler s1 = createScheduler();
		Action a1 = createAction();
		s1.addAction(a1);
		isReadyTest(s1);
		s1.addAction(a1);
	}
	
	/**
	 * Tests adding an action when a scheduler is finished
	 */
	@Test(expected=ActionFinishedException.class)
	public void addActionWhenSchedulerFinished() throws IllegalArgumentException, ActionFinishedException, ActionInProgressException {
		Scheduler s = createScheduler();
		s.addAction(createAction());
		s.addAction(createAction());
		
		doStepUntilFinished(s);
		
		s.addAction(createAction());
		
	}
	
	/**
	 * Tests executing an empty scheduler
	 */
	@Test(expected=NoSuchElementException.class)
	public void doStepWithoutActionsAdded() throws ActionFinishedException {
		Scheduler s = createScheduler();
		isReadyTest(s);
		s.doStep();
	}

	
	
}
