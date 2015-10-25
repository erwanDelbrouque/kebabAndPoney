package model.scheduler;

import model.actions.Action;
import model.actions.ActionFinishedException;


public class SequentialScheduler extends Scheduler {

	public SequentialScheduler() {
		this("Sequential Scheduler");
	}

	public SequentialScheduler(String name) {
		super(name);
	}
	
	public SequentialScheduler(Action... actions) throws ActionFinishedException {
		super(actions);
	}

	@Override
	public void checkState(Action lastAction) {
		if(lastAction.isFinished()) {
			this.actions.remove(lastAction);
		}
		
		super.checkState(lastAction);
		
	}
	
	@Override
	public Action getNextAction() {
		return this.actions.get(0);
	}

	@Override
	public String getMessageAfterAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
