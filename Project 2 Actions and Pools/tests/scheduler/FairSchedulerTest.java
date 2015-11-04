package scheduler;

import model.actions.Action;
import model.actions.foreseeableactions.ForeseeableAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.FairScheduler;
import model.scheduler.IScheduler;
import model.scheduler.Scheduler;

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
	@Test 
	public void fairSchedulerInFairScheduler() throws ActionFinishedException, ActionInProgressException{
		Scheduler scheduler1 = new FairScheduler();
		Scheduler scheduler2 = new FairScheduler();
		
		Action a1 = new ForeseeableAction(2);
		Action a2 = new ForeseeableAction(2);
		Action a3 = new ForeseeableAction(2);
		Action a4 = new ForeseeableAction(2);
		
		scheduler1.addActions(a1,a2);
		// one fairScheduler inside another fairScheduler
		scheduler2.addActions(a3,scheduler1,a4);
		
		isReadyTest(scheduler2);
		isReadyTest(a3);
		isReadyTest(scheduler1);
		isReadyTest(a1);
		isReadyTest(a2);
		isReadyTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isInProgressTest(a3);
		isReadyTest(scheduler1);
		isReadyTest(a1);
		isReadyTest(a2);
		isReadyTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isInProgressTest(a3);
		isInProgressTest(scheduler1);
		isInProgressTest(a1);
		isReadyTest(a2);
		isReadyTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isInProgressTest(a3);
		isInProgressTest(scheduler1);
		isInProgressTest(a1);
		isReadyTest(a2);
		isInProgressTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isFinishedTest(a3);
		isInProgressTest(scheduler1);
		isInProgressTest(a1);
		isReadyTest(a2);
		isInProgressTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isFinishedTest(a3);
		isInProgressTest(scheduler1);
		isInProgressTest(a1);
		isInProgressTest(a2);
		isInProgressTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isFinishedTest(a3);
		isInProgressTest(scheduler1);
		isInProgressTest(a1);
		isInProgressTest(a2);
		isFinishedTest(a4);
		
		scheduler2.doStep();
		
		isInProgressTest(scheduler2);
		isFinishedTest(a3);
		isInProgressTest(scheduler1);
		isFinishedTest(a1);
		isInProgressTest(a2);
		isFinishedTest(a4);
		
		scheduler2.doStep();
		
		isFinishedTest(scheduler2);
		isFinishedTest(a3);
		isFinishedTest(scheduler1);
		isFinishedTest(a1);
		isFinishedTest(a2);
		isFinishedTest(a4);
	}
	
	

}
