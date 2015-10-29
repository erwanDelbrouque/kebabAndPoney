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
	
	/**
	 * The different states of an actions.
	 */
	public enum ACTION_STATE {
		READY, //When doStep() hasn't been called yet
		IN_PROGRESS, //When doStep() has been called at least once
		FINISHED; //When the action is finished (depends of subclasses finishing way
	}
	
	/**
	 * The action name
	 */
	protected String name;
	
	/**
	 * The action state
	 * 
	 *  @see ACTION_STATE
	 */
	protected ACTION_STATE actionState;
	
	public Action() {
		this.actionState = ACTION_STATE.READY;
	}
	
	/**
	 * Constructor with name
	 * @param name The name of this action
	 * @throws NullPointerException When name is null
	 * @throws IllegalArgumentException When name is empty
	 */
	public Action(String name) throws NullPointerException, IllegalArgumentException {
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
	
	/* (non-Javadoc)
	 * @see model.actions.IAction#checkState()
	 */
	@Override
	public abstract void checkState();
	
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
