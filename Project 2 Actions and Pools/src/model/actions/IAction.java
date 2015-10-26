package model.actions;

import java.util.NoSuchElementException;

import model.actions.foreseeableactions.ForeseeableAction;
import model.actions.foreseeableactions.OneStepAction;
import model.actions.resourcepoolactions.ResourcePoolAction;
import model.exceptions.ActionFinishedException;
import model.scheduler.Scheduler;

/**
 * <b>Interface implemented by the Action class</b>
 *
 * @see Action
 * @see ForeseeableAction
 * @see OneStepAction
 * @see ResourcePoolAction
 * @see Scheduler
 */
public interface IAction {

	
	/**
	 * Accomplish an action step
	 * 
	 * @throws ActionFinishedException When the action is already finished
	 * @throws NoSuchElementException In a scheduler : When no action has been added yet
	 */
	public void doStep() throws ActionFinishedException, NoSuchElementException;

	/**
	 * Check the state of this action
	 */
	public void checkState();
	
	/**
	 * @return true if this action is ready else false
	 */
	public boolean isReady();

	/**
	 * @return true if this action is in progress else false
	 */
	public boolean isInProgress();

	/**
	 * @return true if this action is finished else false
	 */
	public boolean isFinished();

	/**
	 * @return The message to display before doing a step (can be empty)
	 */
	public String getMessageBeforeAction();

	/**
	 * @return The message to display after doing a step (can be empty)
	 */
	public String getMessageAfterAction();

}