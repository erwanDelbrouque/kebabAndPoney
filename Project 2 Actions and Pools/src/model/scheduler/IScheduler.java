package model.scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

public interface IScheduler {

	public void addAction(Action action) throws ActionFinishedException, ActionInProgressException;
	public void addActions(Action... actions) throws ActionFinishedException, ActionInProgressException;
	public IAction getNextAction();
	public void checkState(IAction lastAction);
	public List<Action> getActions();

}