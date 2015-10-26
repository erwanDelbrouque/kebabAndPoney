package scheduler;

import model.actions.Action;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.IScheduler;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

import org.junit.Test;

public class SequentialSchedulerTest extends SchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new SequentialScheduler();
	}

	@Override
	protected IScheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		return new SequentialScheduler(actions);
	}

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





}