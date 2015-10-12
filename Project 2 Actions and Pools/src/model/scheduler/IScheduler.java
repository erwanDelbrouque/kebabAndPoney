package model.scheduler;

import java.util.List;

import model.actions.Action;
import model.actions.ActionFinishedException;

public interface IScheduler {

	public void addAction(Action action) throws ActionFinishedException;
	public Action getNextAction();
	public void checkState(Action lastAction);
	public Action getAction(int n);
	public List<Action> getActions();

}