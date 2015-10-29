package model.scheduler;

import java.util.Iterator;

import model.actions.Action;
import model.actions.IAction;
import model.exceptions.ActionFinishedException;
import model.exceptions.ActionInProgressException;

/**
 * <b>A Fair Scheduler is a scheduler that iterates on each action that it contains and execute them one by one until all are finished</b>
 * 
 * @see IScheduler
 * @see Scheduler
 */
public class FairScheduler extends Scheduler {
	
	/**
	 * The iterator that iterates on each action
	 */
	protected Iterator<Action> actionIterator;
	
	/**
	 * Default constructor with default name ("Fair Scheduler")
	 */
	public FairScheduler() {
		this("Fair scheduler");
	}

	/**
	 * Constructor with a name
	 * @param name The name of this fair scheduler
	 * @throws NullPointerException When the name is null
	 * @throws IllegalArgumentException When the name is empty
	 */
	public FairScheduler(String name) throws NullPointerException, IllegalArgumentException {
		super(name);
	}
	
	/**
	 * Constructor with actions at the begining 
	 * @param actions The actions of this fair scheduler
	 * @throws ActionFinishedException When we try to add an action while this fair scheduler has finished his activity (impossible in this case)
	 * @throws ActionInProgressException When we try to add an action while this fair scheduler has begun his activity (impossible in this case)
	 */
	public FairScheduler(Action... actions) throws ActionFinishedException, ActionInProgressException {
		super(actions);
	}
	
	@Override
	public void checkState() {
		if(currentAction.isFinished()) {
			actionIterator.remove();
		}
		
		super.checkState();
	}
	
	@Override
	public IAction getNextAction() {
		if(this.actionIterator == null) { //If it's the first time we do a step
			this.actionIterator = actions.iterator(); //We create a new iterator
		}
		
		if(!this.actionIterator.hasNext()) { //If there are no more actions left to execute (if we are at the end of the list of actions)
			this.actionIterator = actions.iterator();
		}
		
		return actionIterator.next();
		
	}
}
