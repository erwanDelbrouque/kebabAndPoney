package scheduler;

import model.actions.Action;
import model.actions.foreseeableactions.ForeseeableAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.FairScheduler;
import model.scheduler.IScheduler;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

import org.junit.Test;

public class FairSchedulerTest extends SchedulerTest {
	
	protected Scheduler createScheduler() {
		return new FairScheduler();
	}

	protected IScheduler createScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		return new FairScheduler(actions);
	}
	
	
	@Test
	public void fairSchedulerTest() throws ActionFinishedException, ActionInProgressException {
		Scheduler scheduler = createScheduler();
		Action a1 = new ForeseeableAction(2);
		Action a2 = new ForeseeableAction(2);

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
	
	//TODO : Add a test to test a scheduler in a scheduler
	
	
	

}
