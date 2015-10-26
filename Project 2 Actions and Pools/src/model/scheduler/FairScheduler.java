package model.scheduler;

import java.util.Iterator;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

public class FairScheduler extends Scheduler {
	protected Iterator<Action> actionIterator;
	
	public FairScheduler() {
		this("Fair scheduler");
	}

	public FairScheduler(String name) {
		super(name);
	}
	
	public FairScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		super(actions);
	}
	
	@Override
	public void checkState(IAction lastAction) {
		if(lastAction.isFinished()) {
			actionIterator.remove();
		}
		
		super.checkState(lastAction);
	}
	
	@Override
	public IAction getNextAction() {
		if(this.actionIterator == null) {
			this.actionIterator = actions.iterator();
		}
		
		if(!this.actionIterator.hasNext()) {
			this.actionIterator = actions.iterator();
		}
		
		return actionIterator.next();
		
	}
}
