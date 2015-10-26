package model.scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

public interface IScheduler {

	public void addAction(Action action) throws ActionFinishedException,
			ActionInProgressException, IllegalArgumentException;

	public void doStep() throws ActionFinishedException;

	public List<Action> getActions();

	public void checkState(IAction lastAction);

	public void addActions(Action... actions) throws ActionFinishedException,
			ActionInProgressException;

	public String getMessageBeforeAction();

	public String getMessageAfterAction();
	
	public IAction getNextAction();

}