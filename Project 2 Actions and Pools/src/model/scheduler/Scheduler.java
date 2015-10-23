package model.scheduler;

import java.util.ArrayList;
import java.util.List;

import model.actions.Action;
import model.actions.ActionFinishedException;

public abstract class Scheduler extends Action implements IScheduler {
	
	protected List<Action> actions;
	
	public Scheduler() {
		this("Scheduler");
	}
	
	public Scheduler(String name) {
		super(name);
		this.actions = new ArrayList<Action>();
	}
	
	public Scheduler(Action ... actions) throws ActionFinishedException {
		this();
		for(Action action : actions) {
			addAction(action);
		}
	}

	@Override
	public void addAction(Action action) throws ActionFinishedException {
		if(this.isFinished()) {
			throw new ActionFinishedException("This scheduler has finished to do all his actions");
		}
		
		if(this.isInProgress()) {
			throw new ActionFinishedException("You can't add actions in progress");
		}
		
		this.actions.add(action);
		
	}
	
	@Override
	public void doStep() throws ActionFinishedException {
		super.doStep();
		
		if(this.actions.isEmpty()) {
			throw new ActionFinishedException("There are no actions in this scheduler, add some");
		}
		
		Action action = getNextAction();
		action.doStep();
		
		checkState(action);
	}

	@Override
	public Action getAction(int i) {
		//TODO : Verifiy i
		return this.actions.get(i);
	}

	@Override
	public List<Action> getActions() {
		return this.actions;
	}
	
	@Override
	public void checkState(Action lastAction) {
		if(this.actions.isEmpty()) {
			this.actionState = ACTION_STATE.FINISHED;
		}
	}

	public void addAction(Action... actions) throws ActionFinishedException {
		for(Action action : actions) {
			addAction(action);
		}
	}
	
	
	
	

}
