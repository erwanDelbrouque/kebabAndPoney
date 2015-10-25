package model.scheduler;

import java.util.Iterator;

import model.actions.Action;
import model.actions.ActionFinishedException;

public class FairScheduler extends Scheduler {
	protected Iterator<Action> actionIterator;
	
	public FairScheduler() {
		this("Fair scheduler");
	}

	public FairScheduler(String name) {
		super(name);
	}
	
	public FairScheduler(Action... actions) throws ActionFinishedException {
		super(actions);
	}
	
	@Override
	public void checkState(Action lastAction) {
		if(lastAction.isFinished()) {
			actionIterator.remove();
		}
		
		super.checkState(lastAction);
	}
	
	@Override
	public Action getNextAction() {
		if(this.actionIterator == null) {
			this.actionIterator = actions.iterator();
		}
		
		if(!this.actionIterator.hasNext()) {
			this.actionIterator = actions.iterator();
		}
		
		return actionIterator.next();
		
	}

	@Override
	public String getMessageAfterAction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
