package model.scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.ActionFinishedException;
import model.actions.ActionInProgressException;

public interface IScheduler {

	public void addAction(Action action) throws ActionFinishedException, ActionInProgressException;
	public Action getNextAction();
	public void checkState(Action lastAction);
	public List<Action> getActions();

}