package model.scheduler;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;


public class SequentialScheduler extends Scheduler {

	public SequentialScheduler() {
		this("Sequential Scheduler");
	}

	public SequentialScheduler(String name) {
		super(name);
	}
	
	public SequentialScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		super(actions);
	}

	@Override
	public void checkState() {
		if(currentAction.isFinished()) {
			this.actions.remove(currentAction);
		}
		
		super.checkState();
		
	}
	
	@Override
	public IAction getNextAction() {
		return this.actions.get(0);
	}

}
