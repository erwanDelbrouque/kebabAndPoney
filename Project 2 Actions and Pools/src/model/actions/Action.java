package model.actions;

import java.util.NoSuchElementException;

public abstract class Action implements IAction {
	
	public enum ACTION_STATE {
		READY, IN_PROGRESS, FINISHED;
	}
	
	protected String name;
	protected ACTION_STATE actionState;
	
	public Action() {
		this.actionState = ACTION_STATE.READY;
	}
	
	public Action(String name) {
		this();
		this.name = name;
	}
	
	@Override
	public void doStep() throws ActionFinishedException, NoSuchElementException {
		if(this.isFinished()) {
			throw new ActionFinishedException(name + " has finished to do all his actions");
		}
		
		if(isReady()) {
			this.actionState = ACTION_STATE.IN_PROGRESS;
		}
	}
	
	@Override
	public boolean isReady() {
		return this.actionState == ACTION_STATE.READY;
	}
	
	@Override
	public boolean isInProgress() {
		return this.actionState == ACTION_STATE.IN_PROGRESS;
	}
	
	@Override
	public boolean isFinished() {
		return this.actionState == ACTION_STATE.FINISHED;
	}

}
