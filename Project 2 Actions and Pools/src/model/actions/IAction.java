package model.actions;

import java.util.NoSuchElementException;

import model.exceptions.ActionFinishedException;


public interface IAction {
	
	public boolean isReady();
	public boolean isInProgress();
	public boolean isFinished();
	public void doStep() throws ActionFinishedException, NoSuchElementException;
}
