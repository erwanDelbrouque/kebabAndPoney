package model.actions;

import java.util.NoSuchElementException;


public interface IAction {
	
	public boolean isReady();
	public boolean isInProgress();
	public boolean isFinished();
	public void doStep() throws ActionFinishedException, NoSuchElementException;
}
