package model.actions;

import java.util.NoSuchElementException;

import model.exceptions.ActionFinishedException;

/**
 * <b>Interface implemented by the Action class</b>
 * An action has 3 states : ready, in progress and finished
 * An action can have one or multiple steps to do to before beiing finished
 * 
 * A message can be displayed before the doing the step and after.
 *
 * @see Action
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