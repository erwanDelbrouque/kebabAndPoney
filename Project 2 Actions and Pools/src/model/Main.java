package model;

import model.actions.ForeseeableAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

public class Main {
	
	public static void main(String[] args) throws ActionFinishedException, ActionInProgressException {
		Scheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseeableAction(2));
		scheduler.addAction(new ForeseeableAction(1));
		scheduler.addAction(new ForeseeableAction(3));
	}

}
