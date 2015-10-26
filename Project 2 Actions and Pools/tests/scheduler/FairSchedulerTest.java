package scheduler;

import model.actions.Action;
import model.actions.ActionFinishedException;
import model.actions.ActionInProgressException;
import model.actions.ForeseeableAction;
import model.scheduler.FairScheduler;
import model.scheduler.Scheduler;

import org.junit.Test;

public class FairSchedulerTest extends SchedulerTest {
	
	protected Scheduler createScheduler() {
		return new FairScheduler();
	}

	protected Scheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		return new FairScheduler(actions);
	}
	
	@Test
	public void fairSchedulerTest() throws ActionFinishedException, ActionInProgressException {
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
