package model.scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

/**
 * <b>A scheduler is an action which can contain and execute other Actions</b>
 * This interface is implemented by the Scheduler class
 * 
 * @see Scheduler
 * @see SequentialScheduler
 * @see FairScheduler
 * @see IAction
 * @see Action
 */
public interface IScheduler extends IAction {

	public void addAction(Action action) throws ActionFinishedException,
			ActionInProgressException, IllegalArgumentException;

	public List<Action> getActions();

	public void checkState(IAction lastAction);

	public void addActions(Action... actions) throws ActionFinishedException,
			ActionInProgressException;

	public IAction getNextAction();

}