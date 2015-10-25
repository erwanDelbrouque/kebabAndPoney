package scheduler;

import static org.junit.Assert.*;
import model.actions.Action;
import model.actions.ActionFinishedException;
import model.actions.ForeseeableAction;
import model.actions.OneStepAction;
import model.scheduler.FairScheduler;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

import org.junit.Before;
import org.junit.Test;

import action.ActionTest;

public class FairSchedulerTest extends SchedulerTest {
	
	protected Scheduler createScheduler() {
		return new FairScheduler();
	}

	protected Scheduler createScheduler(Action... actions) throws ActionFinishedException {
		return new FairScheduler(actions);
	}
	
	@Test
	public void fairSchedulerTest() throws ActionFinishedException {
		Scheduler scheduler = createScheduler();
		Action a1 = new ForeseeableAction(2);
		Action a2 = new ForeseeableAction(2);

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
		isInProgressTest(a1);
		isInProgressTest(a2);
		
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
