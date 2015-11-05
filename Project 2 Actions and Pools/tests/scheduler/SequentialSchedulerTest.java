package scheduler;

import model.actions.Action;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.FairScheduler;
import model.scheduler.IScheduler;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

import org.junit.Test;

public class SequentialSchedulerTest extends SchedulerTest {

	/* (non-Javadoc)
	 * @see scheduler.SchedulerTest#createScheduler()
	 */
	@Override
	protected Scheduler createScheduler() {
		return new SequentialScheduler();
	}

	/* (non-Javadoc)
	 * @see scheduler.SchedulerTest#createScheduler(model.actions.Action[])
	 */
	@Override
	protected IScheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		return new SequentialScheduler(actions);
	}

	/**
	 * Tests a sequential scheduler with only actions in it
	 */
	@Test
	public void sequentialSchedulerTest() throws ActionFinishedException, ActionInProgressException {
		Scheduler scheduler = createScheduler();
		Action a1 = createAction(2);
		Action a2 = createAction(2);

		scheduler.addActions(a1, a2);

		isReadyTest(scheduler);
		isReadyTest(a1);
		isReadyTest(a2);

		scheduler.doStep();

		isInProgressTest(scheduler);
		isInProgressTest(a1);
		isReadyTest(a2);

		scheduler.doStep();

		isInProgressTest(scheduler);
		isFinishedTest(a1);
		isReadyTest(a2);

		scheduler.doStep();

		isInProgressTest(scheduler);
		isFinishedTest(a1);
		isInProgressTest(a2);

		scheduler.doStep();

		isFinishedTest(scheduler);
		isFinishedTest(a1);
		isFinishedTest(a2);

	}

	/**
	 * Tests a sequential scheduler with action and another sequential scheduler in it
	 */
	@Test
	public void sequentialSchedulerInSequentialSchedulerTest() throws ActionFinishedException, ActionInProgressException {
		Scheduler ss = createScheduler();
		Scheduler ss2 = createScheduler();
		Action a1 = createAction(2);
		Action a2 = createAction(2);
		Action a3 = createAction(2);

		ss2.addActions(a1, a2);
		ss.addActions(ss2, a3);

		isReadyTest(ss);
		isReadyTest(ss2);
		isReadyTest(a1);
		isReadyTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isInProgressTest(ss2);
		isInProgressTest(a1);
		isReadyTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isInProgressTest(ss2);
		isFinishedTest(a1);
		isReadyTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isInProgressTest(ss2);
		isFinishedTest(a1);
		isInProgressTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isFinishedTest(ss2);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isFinishedTest(ss2);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isInProgressTest(a3);
		
		ss.doStep();

		isFinishedTest(ss);
		isFinishedTest(ss2);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isFinishedTest(a3);

	}

	/**
	 * Tests a sequential scheduler with actions and a fair scheduler in it
	 */
	@Test
	public void fairSchedulerInSequentialSchedulerTest() throws ActionFinishedException, ActionInProgressException {
		Scheduler ss = createScheduler();
		Scheduler fs = new FairScheduler();
		Action a1 = createAction(2);
		Action a2 = createAction(2);
		Action a3 = createAction(2);

		fs.addActions(a1, a2);
		ss.addActions(fs, a3);

		isReadyTest(ss);
		isReadyTest(fs);
		isReadyTest(a1);
		isReadyTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isInProgressTest(fs);
		isInProgressTest(a1);
		isReadyTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isInProgressTest(fs);
		isInProgressTest(a1);
		isInProgressTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isInProgressTest(fs);
		isFinishedTest(a1);
		isInProgressTest(a2);
		isReadyTest(a3);

		ss.doStep();

		isInProgressTest(ss);
		isFinishedTest(fs);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isReadyTest(a3);
		
		ss.doStep();

		isInProgressTest(ss);
		isFinishedTest(fs);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isInProgressTest(a3);
		
		ss.doStep();
		isFinishedTest(ss);
		isFinishedTest(fs);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isFinishedTest(a3);
	}



}