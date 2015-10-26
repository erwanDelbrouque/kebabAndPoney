package model.actions;

import java.util.NoSuchElementException;
import java.util.Observable;

import model.exceptions.ActionFinishedException;

/**
 * An action has 3 states : ready, in progress and finished
 * An action can have one or multiple steps to do to before beiing finished
 * 
 * A message can be displayed before the doing the step and after.
 * 
 * @see IAction
 */
public abstract class Action extends Observable implements IAction {
	
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
		if(name == null) {
			throw new NullPointerException("You must specify a non null name to this action !");
		}
		
		if(name.isEmpty()) {
			throw new IllegalArgumentException("You must specify a non empty name to this action !");
		}
		
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see model.actions.IAction#doStep()
	 */
	@Override
	public void doStep() throws ActionFinishedException, NoSuchElementException {
		if(this.isFinished()) {
			throw new ActionFinishedException(name + " has finished to do all his actions");
		}
		
		if(isReady()) {
			this.actionState = ACTION_STATE.IN_PROGRESS;
		}
	}
	
	protected void notify(String message){
		setChanged();
		notifyObservers(message);
	}
	
	/* (non-Javadoc)
	 * @see model.actions.IAction#isReady()
	 */
	@Override
	public boolean isReady() {
		return this.actionState == ACTION_STATE.READY;
	}
	
	/* (non-Javadoc)
	 * @see model.actions.IAction#isInProgress()
	 */
	@Override
	public boolean isInProgress() {
		return this.actionState == ACTION_STATE.IN_PROGRESS;
	}
	
	/* (non-Javadoc)
	 * @see model.actions.IAction#isFinished()
	 */
	@Override
	public boolean isFinished() {
		return this.actionState == ACTION_STATE.FINISHED;
	}

	/* (non-Javadoc)
	 * @see model.actions.IAction#getMessageBeforeAction()
	 */
	@Override
	public abstract String getMessageBeforeAction();
	/* (non-Javadoc)
	 * @see model.actions.IAction#getMessageAfterAction()
	 */
	@Override
	public abstract String getMessageAfterAction();
}
