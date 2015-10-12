package scheduler;

import static org.junit.Assert.*;
import model.actions.Action;
import model.actions.ActionFinishedException;
import model.actions.ForeseeableAction;
import model.actions.OneStepAction;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

import org.junit.Test;

public class SequentialSchedulerTest extends SchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new SequentialScheduler();
	}

	@Override
	protected Scheduler createScheduler(Action... actions) throws ActionFinishedException {
		return new SequentialScheduler(actions);
	}

	@Test
	public void sequentialSchedulerTest() throws ActionFinishedException {
		Scheduler scheduler = createScheduler();
		Action a1 = createAction(2);
		Action a2 = createAction(2);

		scheduler.addAction(a1, a2);

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