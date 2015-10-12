package model;

import model.actions.ActionFinishedException;
import model.actions.ForeseeableAction;
import model.scheduler.Scheduler;
import model.scheduler.SequentialScheduler;

public class Main {
	
	public static void main(String[] args) throws ActionFinishedException {
		Scheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseeableAction(2));
		scheduler.addAction(new ForeseeableAction(1));
		scheduler.addAction(new ForeseeableAction(3));
	}

}
