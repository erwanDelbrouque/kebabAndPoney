package model.scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

/**
 * <b>This interface is implemented by the Scheduler class</b>
 * 
 * @see Scheduler
 * @see SequentialScheduler
 * @see FairScheduler
 * @see IAction
 * @see Action
 */
public interface IScheduler extends IAction {

	/**
	 * Adds an action to the list of actions of this scheduler
	 * @param action The action to add
	 * @throws ActionFinishedException When trying to add an action while this scheduler has finished to interate on all actions in it
	 * @throws ActionInProgressException When trying to add an action while the scheduler is in progress
	 * @throws IllegalArgumentException When action is null
	 */
	public void addAction(Action action) throws ActionFinishedException,
			ActionInProgressException, IllegalArgumentException;

	/**
	 * @return The list of actions in this scheduler
	 */
	public List<Action> getActions();
	
	/**
	 * Adds multiple actions at once
	 * @param actions Actions to add
	 * @throws ActionFinishedException When trying to add an action while this scheduler has finished to interate on all actions in it
	 * @throws ActionInProgressException When trying to add an action while the scheduler is in progress
	 * @throws IllegalArgumentException When action is null
	 */
	public void addActions(Action... actions) throws ActionFinishedException,
			ActionInProgressException;

	/**
	 * @return The next action to execute
	 */
	public IAction getNextAction();

}