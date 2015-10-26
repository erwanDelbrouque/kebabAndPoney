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
	public void checkState(IAction lastAction) {
		if(lastAction.isFinished()) {
			this.actions.remove(lastAction);
		}
		
		super.checkState(lastAction);
		
	}
	
	@Override
	public IAction getNextAction() {
		return this.actions.get(0);
	}

}
